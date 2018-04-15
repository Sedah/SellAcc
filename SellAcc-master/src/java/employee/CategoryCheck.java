/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "CategoryCheck", urlPatterns = {"/admin/CategoryCheck"})
public class CategoryCheck extends HttpServlet {

    @Resource(name = "test")
    private DataSource test;
    private Connection conn;
    
    public void init()
    {
        try {
            conn = test.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession();
        String employee_name = (String) session.getAttribute("name");
        PreparedStatement stmt = conn.prepareStatement("select * from category");
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = 0;
        
        
        if (employee_name != null)
        {
            out.print("<a href='Accessory'>In-stock</a> | ");
            out.print("<a href='OrderCheck'> Order</a> | ");
            out.print("<a href='PaymentCheck'> Payment</a> |"  );
            out.print("<a href='EmLogoutServlet'> Logout</a><br>");
            out.print("<h1> Category </h1>");
            out.print("<table border='1'>");
        while (rs.next())
        {
            if (count == 0)
            {
                out.print("<tr>");
                for (int i=0;i<rsmd.getColumnCount();i++)
                {
                    out.print("<td>"+ rsmd.getColumnName(i+1)+"</td>");
                }
                out.print("</tr>");
            }
            out.print("<tr>");
            for (int i=0;i<rsmd.getColumnCount();i++)
            {
                out.print("<td>"+rs.getString(i+1)+"</td>");    
            }
            out.print("</tr>");
            count += 1;
        }
        out.print("</table>");
        }
        else
            response.sendRedirect("Accessory");
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "LogServlet", urlPatterns = {"/admin/LogServlet"})
public class LogServlet extends HttpServlet {

    @Resource(name = "project")
    private DataSource project;


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
        Connection conn = null;
               try {
            conn = project.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("connection-error").log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String employee_id = (String) session.getAttribute("employee_id");
            String order_id = (String) session.getAttribute("order_id");
            String old_status = (String) session.getAttribute("old_status");
            String new_status = (String) session.getAttribute("new_status");
            String action = (String) session.getAttribute("action");
            String sql = "select * from orders where order_id = ?";
            
            if (action.equals("status_change"))
            {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order_id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i=0;i<rsmd.getColumnCount();i++)
            {
                
            }
            java.sql.Date d = null;
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date2 = formatter.format(date);
            
            
        
            //out.print(date2+": Change order "+order_id+"status from "+old_status+" to "+new_status);
            
            sql = "insert into employee_order values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, date2);
            stmt.setString(2, "Change order "+order_id+" status from "+old_status+" to "+new_status);
            stmt.setString(3, employee_id);
            stmt.setString(4, order_id);
            stmt.executeUpdate();
            
            response.sendRedirect("OrderCheck");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger("connection-close").log(Level.SEVERE, null, ex);
            }
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

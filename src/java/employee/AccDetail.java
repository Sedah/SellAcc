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
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AccDetail", urlPatterns = {"/admin/AccDetail"})
public class AccDetail extends HttpServlet {


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
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
               try {
            conn = project.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("connection-error").log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int acc_id = Integer.parseInt(request.getParameter("view"));
            out.print(acc_id);
            String sql = "select * from accessories where acc_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, acc_id);
            ResultSet detail = stmt.executeQuery();
            ResultSetMetaData rsmd = detail.getMetaData();
            out.print("<form method='GET' action='AccEditServlet'>");
            while (detail.next())
            {
                for (int i=0;i<rsmd.getColumnCount();i++)
                {
                    out.print("<input type='hidden' name = 'acc_id' value='"+detail.getString(1)+"'/><br>");
                    if (rsmd.getColumnName(i+1).equals("description"))
                    {
                        out.print("<br>"+rsmd.getColumnName(i+1)+" <br>");
                        out.print("<textarea name='description' rows='4' cols='20'>"+detail.getString(i+1)+"</textarea>");
                    }
                    else if (i!=0)
                    {
                    out.print(rsmd.getColumnName(i+1)+": ");
                    out.print("<input type='text' name='"+rsmd.getColumnName(i+1)+"' value='"+detail.getString(i+1)+"'/>");
                    }
                    
                    
                    out.print("<br>");
                }
            }
            
            out.print("<button type='submit' name='action' value='update'>update</button>");
            //out.print("<input type='submit' name = 'action' value='update'>");
            //out.print("<input type='submit' name = 'action' value='delete'>");
            out.print("</form>");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(AccDetail.class.getName()).log(Level.SEVERE, null, ex);
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

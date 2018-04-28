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
@WebServlet(name = "AccEditServlet", urlPatterns = {"/admin/AccEditServlet"})
public class AccEditServlet extends HttpServlet {

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
        try{
            conn = project.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AccEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            
            if (action.equals("update"))
            {
                
                String name = request.getParameter("name");
            int acc_id = Integer.parseInt(request.getParameter("acc_id"));
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String image = request.getParameter("image");
            int cate_cate_id = Integer.parseInt(request.getParameter("cate_cate_id"));
            String sql = "update accessories set `name` = ?, description= ?,price= ?, image= ?, cate_cate_id = ? where acc_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setFloat(3, price);
            stmt.setString(4, image);
            stmt.setInt(5, cate_cate_id);
            stmt.setInt(6, acc_id);
            stmt.executeUpdate();
            
            
            out.print("<br><a href='Accessory'><h1>Update Complete!</h1></a>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AccEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null)
        {
            try{
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccEditServlet.class.getName()).log(Level.SEVERE, null, ex);
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

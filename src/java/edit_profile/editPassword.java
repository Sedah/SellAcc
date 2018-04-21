/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edit_profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "editPassword", urlPatterns = {"/editPassword"})
public class editPassword extends HttpServlet {

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
            String new_pass = request.getParameter("new_pass");
            String old_pass = request.getParameter("old_pass");
            
            //find cus_id
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            String mem = "SELECT * FROM member WHERE username = ?";
            PreparedStatement c = conn.prepareStatement(mem);
            c.setString(1, username);
            ResultSet rs = c.executeQuery();
            rs.next();
            int cus_id = rs.getInt("cus_cus_id");
            //check old pass
            String check = "SELECT * FROM member WHERE password = ?";
            PreparedStatement o = conn.prepareStatement(check);
            o.setString(1, old_pass);
            ResultSet o_pass = o.executeQuery();
            o_pass.next();

            //update password
            String edit_pass = "UPDATE member"
                    + " SET password = ? WHERE cus_cus_id = ?";
            PreparedStatement p = conn.prepareStatement(edit_pass);
            p.setString(1, new_pass);
            p.setInt(2, cus_id);
            if (rs.getString("password").equals(old_pass)){
                p.executeUpdate();
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit_comp.jsp");
                rd.forward(request, response);
                return;
            }
            else {
                int fail = 1;
                request.setAttribute("password", fail);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit_profile.jsp");
                rd.forward(request, response);
                return;
            }

        } catch (SQLException ex) {
            Logger.getLogger(editPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn != null) {
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

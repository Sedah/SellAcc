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
@WebServlet(name = "addAddress", urlPatterns = {"/addAddress"})
public class addAddress extends HttpServlet {

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

            String province = request.getParameter("province");
            String district = request.getParameter("district");
            String house_n = request.getParameter("h_num");
            String street = request.getParameter("street");
            String area = request.getParameter("area");
            String postcode = request.getParameter("postcode");
            
            //find cus_id
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            String mem = "SELECT * FROM member WHERE username = ?";
            PreparedStatement c = conn.prepareStatement(mem);
            c.setString(1, username);
            ResultSet rs = c.executeQuery();
            rs.next();
            int cus_id = rs.getInt("cus_cus_id");

            //insert address
            String insert_add = "INSERT INTO address"
                    + "(province, district,house_num, street, area, postcode, member_cus_id) VALUES"
                    + "(?, ?, ?, ?, ?,?,?)";

            PreparedStatement a = conn.prepareStatement(insert_add);
            a.setString(1, province);
            a.setString(2, district);
            a.setString(3, house_n);
            a.setString(4, street);
            a.setString(5, area);
            a.setString(6, postcode);
            a.setInt(7, cus_id);
            a.executeUpdate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit_comp.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addAddress.class.getName()).log(Level.SEVERE, null, ex);
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

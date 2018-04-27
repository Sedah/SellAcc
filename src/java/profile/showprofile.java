package profile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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
import model.Order;

/**
 *
 * @author Chronical
 */
@WebServlet(urlPatterns = {"/showprofile"})
public class showprofile extends HttpServlet {

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
            String username = (String) session.getAttribute("username");
            String mem = "SELECT * FROM member WHERE username = ?";
            PreparedStatement c = conn.prepareStatement(mem);
            c.setString(1, username);
            ResultSet rs = c.executeQuery();
            rs.next();
            int cus_id = rs.getInt("cus_cus_id");
            int point = rs.getInt("point");
            ArrayList<Order> ordlist = new ArrayList<Order>();
            String find_order = "SELECT * FROM `order` WHERE cus_cus_id = ?";
            PreparedStatement a = conn.prepareStatement(find_order);
            a.setInt(1, cus_id);
            ResultSet rs_a = a.executeQuery();
             while (rs_a.next()) {
                Order ord = new Order();
                ord.setOrder_id(rs_a.getInt("order_id"));
                ord.setBuy_date(rs_a.getDate("buy_date"));
                ord.setStatus(rs_a.getString("status_order"));
                ord.setUse_point(rs_a.getInt("use_point"));
                ord.setRecieve_point(rs_a.getInt("recieve_point"));
                ord.setTotal_price(rs_a.getInt("total_price"));
                ord.setAddress(rs_a.getString("address"));
                ord.setCus_cus_id(rs_a.getInt("cus_cus_id"));
                ordlist.add(ord);
                }
            
            request.setAttribute("ordlist", ordlist);
            request.setAttribute("point", point);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(showprofile.class.getName()).log(Level.SEVERE, null, ex);
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

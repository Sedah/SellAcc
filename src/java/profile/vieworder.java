/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

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
import model.Accessory;
import model.Order;
import model.OrderItem;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "vieworder", urlPatterns = {"/vieworder"})
public class vieworder extends HttpServlet {

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
            String order = request.getParameter("ord_id");
            int order_id = Integer.parseInt(order);
            ArrayList<OrderItem> ordlist = new ArrayList<OrderItem>();
            ArrayList<Accessory> acclist = new ArrayList<Accessory>();
            String sql = "select * from order_item where order_order_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, order_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OrderItem ord = new OrderItem(getServletContext());
                ord.setPrice(rs.getDouble("price"));
                ord.setQuentity(rs.getInt("quentity"));
                ord.setAcc_id(rs.getInt("acc_acc_id"));
                ord.setItem_num(rs.getInt("item_num"));
                ord.setOrder_id(rs.getInt("order_order_id"));
                ordlist.add(ord);
            }
            String s_order = "select * from `order` where order_id = ?";
            PreparedStatement s_ord = conn.prepareStatement(s_order);
            s_ord.setInt(1, order_id);
            ResultSet rs_s = s_ord.executeQuery();
            rs_s.next();
            Order ord_s = new Order();
            ord_s.setOrder_id(rs_s.getInt("order_id"));
            ord_s.setBuy_date(rs_s.getDate("buy_date"));
            ord_s.setStatus(rs_s.getString("status_order"));
            ord_s.setUse_point(rs_s.getInt("use_point"));
            ord_s.setRecieve_point(rs_s.getInt("recieve_point"));
            ord_s.setTotal_price(rs_s.getDouble("total_price"));
            request.setAttribute("ordlist", ordlist);
            request.setAttribute("ord_s", ord_s);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/orderdetail.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(vieworder.class.getName()).log(Level.SEVERE, null, ex);
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

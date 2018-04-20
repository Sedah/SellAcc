/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "paymentServlet", urlPatterns = {"/paymentServlet"})
public class paymentServlet extends HttpServlet {

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
            String oid = request.getParameter("order_id");
            String s_date = request.getParameter("date");
            String s_time = request.getParameter("time");
            String s_amount = request.getParameter("amount");
            String url = request.getParameter("image");
            String timestamp = s_date.concat(' ' + s_time);

            int order_id = Integer.parseInt(oid);
            double amount = Double.parseDouble(s_amount);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
            Date date = null;
            try {
                date = simpleDateFormat.parse(timestamp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date == null){
                int fail = 2;
                request.setAttribute("payment", fail);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/payment.jsp");
                rd.forward(request, response);
                return;
            }
            Timestamp time = new Timestamp(date.getTime());
            System.out.println(time);

            //check order_id
            String find_id = "SELECT order_id FROM `order` WHERE order_id = ?";
            PreparedStatement fo = conn.prepareStatement(find_id);
            fo.setInt(1, order_id);
            ResultSet rs_fo = fo.executeQuery();
            if (!rs_fo.next()) {
                int fail = 1;
                request.setAttribute("payment", fail);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/payment.jsp");
                rd.forward(request, response);
                return;
            }
            
            //insert payment
            String insert_payment = "INSERT INTO payment"
                    + "(date, amount,type, image, order_order_id) VALUES"
                    + "(?, ?, ?, ?, ?)";

            PreparedStatement c = conn.prepareStatement(insert_payment);
            c.setTimestamp(1, time);
            c.setDouble(2, amount);
            c.setString(3, "money-trans");
            c.setString(4, url);
            c.setInt(5, order_id);
            c.executeUpdate();
            //forward to order comp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pay_comp.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(paymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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

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
@WebServlet(name = "OrderDetail", urlPatterns = {"/admin/OrderDetail"})
public class OrderDetail extends HttpServlet {

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
            String order_id = request.getParameter("view");
            String employee_name = (String) session.getAttribute("name");
            String sql = "select * from `order` where order_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, order_id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {

                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnName(i + 1).equals("order_id")) {
                        session.setAttribute("order_id", rs.getString(i + 1));
                    }
                    if (rsmd.getColumnName(i + 1).equals("status_order")) {
                        session.setAttribute("old_status", rs.getString(i + 1));
                    }
                    if (i == 0) {
                        out.println("<h1>" + rsmd.getColumnName(i + 1) + "  " + rs.getString(i + 1) + "</h1>");

                    } else {
                        out.println(rsmd.getColumnName(i + 1) + " : " + rs.getString(i + 1) + "<br>");
                    }
                }

            }
            String order_item = "select * from `order_item` where order_order_id = ?";
            PreparedStatement ot = conn.prepareStatement(order_item);
            ot.setString(1, order_id);
            ResultSet rs_ot = ot.executeQuery();
            while (rs_ot.next()) {
                String acc_name = "select * from accessories where acc_id = ?";
                PreparedStatement name = conn.prepareStatement(acc_name);
                name.setString(1, rs_ot.getString("acc_acc_id"));
                ResultSet rs_name = name.executeQuery();
                rs_name.next();
                out.println("รหัสสินค้า: " + rs_ot.getString("acc_acc_id") + " ");
                out.println("ชื่อสินค้า: " + rs_name.getString("name") + " ");
                out.println("จำนวน: " + rs_ot.getString("quentity") + "<br>");
            }
            out.print("<h1> Change Order Status</h1>");
            out.print("<form method='POST' action='OrderChange'  ><select class=\"form-control\" name=\"status_order\">\n"
                    + "<option>wait_verify</option>\n"
                    + "<option>verify_pass</option>\n"
                    + "<option>verify_not_pass\n</option>"
                    + "<option>send\n</option>"
                    + "<option>cancle\n</option>"
                    + "</select><br>"
                    //+"<input type='hidden' value='"+rs.getString(1)+"'>"
                    + "<br><input class=\"btn btn-b btn-round\" type='submit' value='update'></form>");

            String check = "select * from deliverie where order_order_id = ?";
            PreparedStatement chk = conn.prepareStatement(check);
            chk.setString(1, order_id);
            ResultSet rs_chk = chk.executeQuery();
            if (rs_chk.next() == false) {
                out.println("<form action='AddTracking'>");
                out.println("Type: <input type='text' name='type'/>");
                out.println("Tracking number: <input type='text' name='number'/>");
                out.println("Send date: <input type='text' name='date'/>");
                out.println("Format : YYYY-MM-DD ex. 2018-01-23");
                out.println("<input type='hidden' value='" + order_id + "' name='order_id'>");
                out.println("<input type='submit' value='add' name='number'");
                out.println("</form>");
            }
            else {
                out.println("Type: " + rs_chk.getString("type")+"<br>");
                out.println("Tracking Number: " + rs_chk.getString("tracking_number")+"<br>");
                out.println("Send Date "+rs_chk.getDate("send_date"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDetail.class.getName()).log(Level.SEVERE, null, ex);
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

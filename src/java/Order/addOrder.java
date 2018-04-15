/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
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
import model.Address;
import model.Cart;
import model.OrderItem;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "addOrder", urlPatterns = {"/addOrder"})
public class addOrder extends HttpServlet {

    @Resource(name = "project")
    private DataSource project;
    Connection conn;

    public void init() {
        try {
            conn = project.getConnection();
        } catch (Exception ex) {
            System.out.println(ex);
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

            //get cart and address for insert
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            double total = cart.getTotal();

            //get cus_id for mem and non and insert in order
            String username = (String) session.getAttribute("username");
            if (username != null) {

                //get add_id
                String add = request.getParameter("add_id");
                int add_id = Integer.parseInt(add);

                //get cus_id
                String find_mem_id = "SELECT cus_cus_id FROM member WHERE username = ?";
                PreparedStatement m = conn.prepareStatement(find_mem_id);
                m.setString(1, username);
                ResultSet rs_m = m.executeQuery();
                rs_m.next();
                int cus_id = rs_m.getInt("cus_cus_id");

                //get address
                String find_address = "SELECT * FROM address WHERE add_id = ?";
                PreparedStatement a = conn.prepareStatement(find_address);
                a.setInt(1, add_id);
                ResultSet rs_a = a.executeQuery();
                rs_a.next();
                String address = rs_a.getString("house_num") + rs_a.getString("street") + rs_a.getString("area")
                        + rs_a.getString("district") + rs_a.getString("province") + rs_a.getString("postcode");

                //insert order
                String insert_order = "INSERT INTO `order`"
                        + "(buy_date, total_price, cus_cus_id, address) VALUES"
                        + "(?, ?, ?, ?)";

                PreparedStatement c = conn.prepareStatement(insert_order);
                Timestamp date = new Timestamp(System.currentTimeMillis());
                c.setTimestamp(1, date);
                c.setDouble(2, total);
                c.setInt(3, cus_id);
                c.setString(4, address);
                c.executeUpdate();

                //find order_id
                String find_order = "SELECT MAX(order_id) as 'order_id' FROM `order` WHERE  cus_cus_id = ?";
                PreparedStatement f = conn.prepareStatement(find_order);
                f.setInt(1, cus_id);
                ResultSet rs = f.executeQuery();
                rs.next();
                int order_id = rs.getInt("order_id");

                //insert order_item
                List<OrderItem> accs = cart.getAccs();
                int item_num = 1;
                for (int i = 0; i < accs.size(); i++) {
                    OrderItem item = accs.get(i);
                    int acc_id = item.getAcc_id();
                    double price = item.getPrice();
                    int quentity = item.getQuentity();
                    String insert_item = "INSERT INTO order_item"
                            + " VALUES"
                            + "(?, ?, ?, ?, ?)";
                    PreparedStatement i_item = conn.prepareStatement(insert_item);
                    i_item.setDouble(1, price);
                    i_item.setInt(2, quentity);
                    i_item.setInt(3, acc_id);
                    i_item.setInt(4, item_num);
                    i_item.setInt(5, order_id);
                    i_item.executeUpdate();

                }
            } else {
                //find cus_id in customer
                String find_mem = "SELECT cus_id FROM customer WHERE  name = ? AND email = ? and user_type like 'non'";
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                PreparedStatement f = conn.prepareStatement(find_mem);
                f.setString(1, name);
                f.setString(2, email);
                ResultSet rs_f = f.executeQuery();

                //if not find insert them
                if (rs_f.next() == false) {
                    String insert_cus = "INSERT INTO customer"
                            + "(email, name ,user_type) VALUES"
                            + "(?, ?, ?)";
                    PreparedStatement c = conn.prepareStatement(insert_cus);
                    c.setString(1, email);
                    c.setString(2, name);
                    c.setString(3, "non");
                    c.executeUpdate();
                    //find cus_id in customer
                    String find_cus = "SELECT MAX(cus_id) as 'cus_id' FROM customer WHERE  name = ? AND email = ? and user_type like 'non'";
                    PreparedStatement fc = conn.prepareStatement(find_cus);
                    fc.setString(1, name);
                    fc.setString(2, email);
                    ResultSet rs = fc.executeQuery();
                    rs.next();
                    int cus_id = rs.getInt("cus_id");
                    //get address
                    String province = request.getParameter("province");
                    String district = request.getParameter("district");
                    String house_n = request.getParameter("h_num");
                    String street = request.getParameter("street");
                    String area = request.getParameter("area");
                    String postcode = request.getParameter("postcode");
                    String address = house_n + street + area + district + province + postcode;

                    //insert order
                    String insert_order = "INSERT INTO `order`"
                            + "(buy_date, total_price, cus_cus_id, address) VALUES"
                            + "(?, ?, ?, ?)";

                    PreparedStatement i = conn.prepareStatement(insert_order);
                    Timestamp date = new Timestamp(System.currentTimeMillis());
                    i.setTimestamp(1, date);
                    i.setDouble(2, total);
                    i.setInt(3, cus_id);
                    i.setString(4, address);
                    i.executeUpdate();

                    //find order_id
                    String find_order = "SELECT MAX(order_id) as 'order_id' FROM `order` WHERE  cus_cus_id = ?";
                    PreparedStatement fo = conn.prepareStatement(find_order);
                    fo.setInt(1, cus_id);
                    ResultSet rs_i = fo.executeQuery();
                    rs_i.next();
                    int order_id = rs_i.getInt("order_id");

                    //insert order_item
                    List<OrderItem> accs = cart.getAccs();
                    int item_num = 1;
                    for (int x = 0; x < accs.size(); x++) {
                        OrderItem item = accs.get(x);
                        int acc_id = item.getAcc_id();
                        double price = item.getPrice();
                        int quentity = item.getQuentity();
                        String insert_item = "INSERT INTO order_item"
                                + " VALUES"
                                + "(?, ?, ?, ?, ?)";
                        PreparedStatement i_item = conn.prepareStatement(insert_item);
                        i_item.setDouble(1, price);
                        i_item.setInt(2, quentity);
                        i_item.setInt(3, acc_id);
                        i_item.setInt(4, item_num);
                        i_item.setInt(5, order_id);
                        i_item.executeUpdate();
                    }
                } else {
                    //already have
                    int cus_id = rs_f.getInt("cus_id");
                    //get address
                    String province = request.getParameter("province");
                    String district = request.getParameter("district");
                    String house_n = request.getParameter("h_num");
                    String street = request.getParameter("street");
                    String area = request.getParameter("area");
                    String postcode = request.getParameter("postcode");
                    String address = house_n + street + area + district + province + postcode;

                    //insert order
                    String insert_order = "INSERT INTO `order`"
                            + "(buy_date, total_price, cus_cus_id, address) VALUES"
                            + "(?, ?, ?, ?)";

                    PreparedStatement c = conn.prepareStatement(insert_order);
                    Timestamp date = new Timestamp(System.currentTimeMillis());
                    c.setTimestamp(1, date);
                    c.setDouble(2, total);
                    c.setInt(3, cus_id);
                    c.setString(4, address);
                    c.executeUpdate();

                    //find order_id
                    String find_order = "SELECT MAX(order_id) as 'order_id' FROM `order` WHERE  cus_cus_id = ?";
                    PreparedStatement fo = conn.prepareStatement(find_order);
                    fo.setInt(1, cus_id);
                    ResultSet rs = fo.executeQuery();
                    rs.next();
                    int order_id = rs.getInt("order_id");

                    //insert order_item
                    List<OrderItem> accs = cart.getAccs();
                    int item_num = 1;
                    for (int i = 0; i < accs.size(); i++) {
                        OrderItem item = accs.get(i);
                        int acc_id = item.getAcc_id();
                        double price = item.getPrice();
                        int quentity = item.getQuentity();
                        String insert_item = "INSERT INTO order_item"
                                + " VALUES"
                                + "(?, ?, ?, ?, ?)";
                        PreparedStatement i_item = conn.prepareStatement(insert_item);
                        i_item.setDouble(1, price);
                        i_item.setInt(2, quentity);
                        i_item.setInt(3, acc_id);
                        i_item.setInt(4, item_num);
                        i_item.setInt(5, order_id);
                        i_item.executeUpdate();
                    }
                }

            }
            //forward to order comp
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/order_comp.jsp");
            rd.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(addOrder.class.getName()).log(Level.SEVERE, null, ex);
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

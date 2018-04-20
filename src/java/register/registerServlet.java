package register;

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
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {

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
    //ถ้า customer เคยซื้อแล้วอยากสมัครสมาชิกจะทำการสร้ง cus_id ใหม่ เพื่อไม่ให้มีประวัติการสั่งซื้อเก่าไว้ เนื่องจากลูกค้าพึ่งสมัครสมาชิกไม่ควรมีประวัติการสั่งซื้อเก่า
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Connection conn = null;
               try {
            conn = project.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("connection-error").log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String user = request.getParameter("user");
            String password = request.getParameter("pass");
            String name = request.getParameter("name");
            String email = request.getParameter("mail");
            String province = request.getParameter("province");
            String district = request.getParameter("district");
            String house_n = request.getParameter("h_num");
            String street = request.getParameter("street");
            String area = request.getParameter("area");
            String postcode = request.getParameter("postcode");

            //find same username,email
            String find_sameuser = "SELECT username FROM member WHERE  username = ?";
            String find_sameemail = "SELECT * FROM customer WHERE  email = ? and user_type like 'mem'";
            PreparedStatement sameuser = conn.prepareStatement(find_sameuser);
            sameuser.setString(1, user);
            PreparedStatement sameemail = conn.prepareStatement(find_sameemail);
            sameemail.setString(1, email);
            ResultSet user_rs = sameuser.executeQuery();
            ResultSet email_rs = sameemail.executeQuery();
            if (user_rs.next() == true) {
                int fail = 1;
                request.setAttribute("flag", fail);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
                return;
            } else if (email_rs.next()) {
                int fail = 1;
                request.setAttribute("flag", fail);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
                rd.forward(request, response);
                return;
            }

            //insert customer
            String insert_cus = "INSERT INTO customer"
                    + "(name, email) VALUES"
                    + "(?, ?)";
            PreparedStatement c = conn.prepareStatement(insert_cus);
            c.setString(1, name);
            c.setString(2, email);
            c.executeUpdate();

            //find cus_id in customer
            String find_mem = "SELECT cus_id FROM customer WHERE  name = ? AND email = ?";
            PreparedStatement f = conn.prepareStatement(find_mem);
            f.setString(1, name);
            f.setString(2, email);

            //insert in member
            String insert_mem = "INSERT INTO member"
                    + "(cus_cus_id, username, password) VALUES"
                    + "(?, ?, ?)";
            PreparedStatement m = conn.prepareStatement(insert_mem);
            ResultSet rs = f.executeQuery();
            rs.next();
            int cus_id = rs.getInt("cus_id");
            m.setInt(1, cus_id);
            m.setString(2, user);
            m.setString(3, password);
            m.executeUpdate();
            //insert in add
            String insert_add = "INSERT INTO address"
                    + "(province, district, house_num, street, area, postcode, member_cus_id) VALUES"
                    + "(?, ?, ?, ?, ? ,?, ?)";
            PreparedStatement a = conn.prepareStatement(insert_add);
            a.setString(1, province);
            a.setString(2, district);
            a.setString(3, house_n);
            a.setString(4, street);
            a.setString(5, area);
            a.setString(6, postcode);
            a.setInt(7, cus_id);
            a.executeUpdate();
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/regis_comp.html");
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(registerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

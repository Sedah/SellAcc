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
import model.Address;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "addressServlet", urlPatterns = {"/addressServlet"})
public class addressServlet extends HttpServlet {

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
            //get point
            String up = request.getParameter("use_point");
                int use_point = 0;
                try{
                use_point = Integer.parseInt(up);
                }catch(NumberFormatException e){}

            //get cus_id from member
            String username = (String) session.getAttribute("username");
            String find_mem = "SELECT * FROM member WHERE username = ?";
            PreparedStatement mem = conn.prepareStatement(find_mem);
            mem.setString(1, username);
            ResultSet rs = mem.executeQuery();

            //member
            if (rs.next() != false) {
                int cus_id = rs.getInt("cus_cus_id");

                //find add in address table that match cus_id and insert them in list
                ArrayList<Address> add_list = new ArrayList<Address>();
                String find_add = "SELECT * FROM address WHERE member_cus_id = ?";
                PreparedStatement address = conn.prepareStatement(find_add);
                address.setInt(1, cus_id);
                ResultSet rs_add = address.executeQuery();
                while (rs_add.next()) {
                    Address add = new Address();
                    add.setAdd_id(rs_add.getInt("add_id"));
                    add.setProvince(rs_add.getString("province"));
                    add.setDistrict(rs_add.getString("district"));
                    add.setHouse_num(rs_add.getString("house_num"));
                    add.setStreet(rs_add.getString("street"));
                    add.setArea(rs_add.getString("area"));
                    add.setPostcode(rs_add.getString("postcode"));
                    add.setStatus(rs_add.getString("status"));
                    add.setMember_cus_id(rs_add.getInt("member_cus_id"));
                    add_list.add(add);

                }
                request.setAttribute("add_list", add_list);
                session.setAttribute("use_point", use_point);
                //forward to select add
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/mem_order.jsp");
                rd.forward(request, response);

            } else {
                //forward to type add
                RequestDispatcher fd = getServletContext().getRequestDispatcher("/non_order.jsp");
                fd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(addressServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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

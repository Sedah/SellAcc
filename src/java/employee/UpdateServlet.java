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
import java.sql.SQLException;
import java.sql.Statement;
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
import model.Category;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/admin/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

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
            String employee_name = (String) session.getAttribute("name");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            float price = Float.parseFloat(request.getParameter("price"));
            String image = request.getParameter("image");
            String cate_name = request.getParameter("cate_name");
            
            ArrayList<Category> cat_list = new ArrayList<Category>();
            String find_cat = "SELECT * FROM category";
            PreparedStatement c = conn.prepareStatement(find_cat);
            ResultSet rs_cat = c.executeQuery();
            while (rs_cat.next()) {
                Category cat = new Category();
                cat.setCate_id(rs_cat.getInt("cate_id"));
                cat.setName(rs_cat.getString("name"));
                cat_list.add(cat);

            }
            request.setAttribute("cat_list", cat_list);
            
            
            
            String find_cat_id = "SELECT * FROM category WHERE name = ?";
            PreparedStatement i = conn.prepareStatement(find_cat_id);
            i.setString(1, cate_name);
            ResultSet cat_detail = c.executeQuery();
            cat_detail.next();
            int cat_id = cat_detail.getInt("cate_id");
            String sql = "insert into accessories (name, description, price, image, cate_cate_id)  value (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            //stmt.setString(1, acc_id);
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setFloat(3, price);
            stmt.setString(4, image);
            stmt.setInt(5, cat_id);
            stmt.executeUpdate();
            
            response.sendRedirect("Accessory");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
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
import model.Comment;

/**
 *
 * @author Chronical
 */
@WebServlet(name = "commServlet", urlPatterns = {"/commServlet"})
public class commServlet extends HttpServlet {

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
            String name = request.getParameter("name");
            String review = request.getParameter("review");
            String email = request.getParameter("email");
            String acc_num = request.getParameter("acc_id");
            String a = "/SellAcc/viewAcc?id=" + acc_num + "&value=1";
            String a_f = "/SellAcc/viewAcc?id=" + acc_num + "&value=0";
            int acc_deci = Integer.parseInt(acc_num);
            Timestamp date = new Timestamp(System.currentTimeMillis());
            
            //find cus_id in customer
            String find_mem = "SELECT cus_id FROM customer WHERE email = ?";
            PreparedStatement f = conn.prepareStatement(find_mem);
            f.setString(1, email);
            ResultSet rs_f = f.executeQuery();
            
            if (rs_f.next() == false) {
                response.sendRedirect(a_f);
                return;
            }
            int cus_id = rs_f.getInt("cus_id");
            
            
            //insert in comment table
            String insert_comm = "INSERT INTO comment"
                    + "(name, review, date, cus_cus_id , acc_acc_id) VALUES"
                    + "(?, ?, ?, ?,?)";
            PreparedStatement c = conn.prepareStatement(insert_comm);
            c.setString(1, name);
            c.setString(2, review);
            c.setTimestamp(3, date);
            c.setInt(4, cus_id);
            c.setInt(5, acc_deci);
            c.executeUpdate();
            
           response.sendRedirect(a);
           

        } catch (SQLException ex) {
            Logger.getLogger(commServlet.class.getName()).log(Level.SEVERE, null, ex);
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

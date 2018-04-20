package viewAcc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.print.Book;
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
import model.Comment;

/**
 *
 * @author Chronical
 */
@WebServlet(urlPatterns = {"/viewAcc"})
public class viewAcc extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String acc_num = request.getParameter("id");
            int acc_deci = Integer.parseInt(acc_num);
            String find_acc = "SELECT * FROM accessories WHERE  acc_id = ?";
            PreparedStatement acc_db = conn.prepareStatement(find_acc);
            acc_db.setInt(1, acc_deci);
            ResultSet rs = acc_db.executeQuery();
            if (rs.next()) {
                Accessory acc = new Accessory();
                acc.setAcc_id(acc_deci);
                acc.setName(rs.getString("name"));
                acc.setDescription(rs.getString("description"));
                acc.setPrice(rs.getFloat("price"));
                acc.setImage(rs.getString("image"));
                request.setAttribute("acc", acc);
            }
            //show comment
            ArrayList<Comment> comm_list = new ArrayList<Comment>();
            String find_com = "SELECT com_id,name,review,date FROM comment WHERE acc_acc_id = ?" ;
            PreparedStatement f = conn.prepareStatement(find_com);
            f.setInt(1, acc_deci);
            ResultSet rs_f = f.executeQuery();
            while (rs_f.next()) {
                Comment comm = new Comment();
                comm.setComm_id(rs_f.getInt("com_id"));
                comm.setName(rs_f.getString("name"));
                comm.setReview(rs_f.getString("review"));
                comm.setDate(rs_f.getTimestamp("date"));
                comm_list.add(comm);
            }
            request.setAttribute("comm_list", comm_list);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewacc.jsp");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(viewAcc.class.getName()).log(Level.SEVERE, null, ex);
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

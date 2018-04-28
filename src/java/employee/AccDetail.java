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
@WebServlet(name = "AccDetail", urlPatterns = {"/admin/AccDetail"})
public class AccDetail extends HttpServlet {


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
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
               try {
            conn = project.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("connection-error").log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int acc_id = Integer.parseInt(request.getParameter("view"));
           HttpSession session = request.getSession();
            String employee_name = (String) session.getAttribute("name");
  
            String sql = "select * from accessories where acc_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, acc_id);
            ResultSet detail = stmt.executeQuery();
            ResultSetMetaData rsmd = detail.getMetaData();
            out.print("<form method='GET' action='AccEditServlet'>");
            out.print("<html lang=\"en-US\" dir=\"ltr\">\n"
                        + "  <head>\n"
                        + "    <meta charset=\"utf-8\">\n"
                        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "    <!--  \n"
                        + "    Document Title\n"
                        + "    =============================================\n"
                        + "    -->\n"
                        + "    <title>Sehda | Multipurpose HTML5 Template</title>\n"
                        + "    <!--  \n"
                        + "    Favicons\n"
                        + "    =============================================\n"
                        + "    -->\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"assets/images/favicons/apple-icon-57x57.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"assets/images/favicons/apple-icon-60x60.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"assets/images/favicons/apple-icon-72x72.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/images/favicons/apple-icon-76x76.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"assets/images/favicons/apple-icon-114x114.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"assets/images/favicons/apple-icon-120x120.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"assets/images/favicons/apple-icon-144x144.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"assets/images/favicons/apple-icon-152x152.png\">\n"
                        + "    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"assets/images/favicons/apple-icon-180x180.png\">\n"
                        + "    <link rel=\"icon\" type=\"image/png\" sizes=\"192x192\" href=\"assets/images/favicons/android-icon-192x192.png\">\n"
                        + "    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"assets/images/favicons/favicon-32x32.png\">\n"
                        + "    <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/images/favicons/favicon-96x96.png\">\n"
                        + "    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/images/favicons/favicon-16x16.png\">\n"
                        + "    <link rel=\"manifest\" href=\"/manifest.json\">\n"
                        + "    <meta name=\"msapplication-TileColor\" content=\"#ffffff\">\n"
                        + "    <meta name=\"msapplication-TileImage\" content=\"assets/images/favicons/ms-icon-144x144.png\">\n"
                        + "    <meta name=\"theme-color\" content=\"#ffffff\">\n"
                        + "    <!--  \n"
                        + "    Stylesheets\n"
                        + "    =============================================\n"
                        + "    \n"
                        + "    -->\n"
                        + "    <!-- Default stylesheets-->\n"
                        + "    <link href=\"assets/lib/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                        + "    <!-- Template specific stylesheets-->\n"
                        + "    <link href=\"https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700\" rel=\"stylesheet\">\n"
                        + "    <link href=\"https://fonts.googleapis.com/css?family=Volkhov:400i\" rel=\"stylesheet\">\n"
                        + "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/animate.css/animate.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/components-font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/et-line-font/et-line-font.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/flexslider/flexslider.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/owl.carousel/dist/assets/owl.carousel.min.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/magnific-popup/dist/magnific-popup.css\" rel=\"stylesheet\">\n"
                        + "    <link href=\"assets/lib/simple-text-rotator/simpletextrotator.css\" rel=\"stylesheet\">\n"
                        + "    <!-- Main stylesheet and color file-->\n"
                        + "    <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n"
                        + "    <link id=\"color-scheme\" href=\"assets/css/colors/default.css\" rel=\"stylesheet\">\n"
                        + "  </head>\n"
                        + "  <body data-spy=\"scroll\" data-target=\".onpage-navigation\" data-offset=\"60\">\n"
                        + "    <main>\n"
                        + "      <div class=\"page-loader\">\n"
                        + "        <div class=\"loader\">Loading...</div>\n"
                        + "      </div>\n"
                        + "                <nav class=\"navbar navbar-custom navbar-fixed-top\" role=\"navigation\">\n"
                        + "                    <div class=\"container\">\n"
                        + "                        <div class=\"navbar-header\">\n"
                        + "                            <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#custom-collapse\"><span class=\"sr-only\">Toggle navigation</span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button><a class=\"navbar-brand\" href=\"index.html\">Sehda</a>\n"
                        + "                        </div>\n"
                        + "                        <div class=\"collapse navbar-collapse\" id=\"custom-collapse\">\n"
                        + "                            <ul class=\"nav navbar-nav navbar-right\">\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                                <li class=\"active\"><a href=\"Accessory\">In-stock</a></li>\n"
                        + "                                <li class=\"active\"><a href=\"OrderCheck\">Order</a></li>\n"
                        + "                                <li class=\"active\"><a href=\"CategoryCheck\">Category</a></li>\n"
                        + "\n"
                        + "                                <li class=\"active\"><a href=\"UpdateStock\">Add Product</a></li>\n"
                        + "                                <li class=\"active\"><a href=\"EmLogoutServlet\">Logout</a></li>"
                        + "                                <li class=\"active\"><a href=\"Accessory\">Hi! "+employee_name+"</a></li>"
                        );
                out.print( "</ul>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </nav>");
                out.print("<div class=\"main\">");
                out.print("<main>");
                out.print("<section class=\"module\">\n");
                out.print("<div class=\"container\">\n"
                        + "            <div class=\"row\">\n"
                        + "              <div class=\"col-xs-6\">\n"
                        + "                <h4 class=\"font-alt\">Accessory#"+acc_id+"</h4>\n"
                        + "                <hr class=\"divider-w mb-10\">\n");
            while (detail.next())
            {
                for (int i=0;i<rsmd.getColumnCount();i++)
                {
                    out.print("<input class=\"form-control\" type='hidden' name = 'acc_id' value='"+detail.getString(1)+"' \"/>");
                    if (rsmd.getColumnName(i+1).equals("description"))
                    {
                        out.print(""+rsmd.getColumnName(i+1)+" <br>");
                        out.print("<textarea class=\"form-control\" name='description' rows='4' cols='20'>"+detail.getString(i+1)+"</textarea>");
                    }
                    else if (i!=0)
                    {
                    out.print(rsmd.getColumnName(i+1)+": ");
                    out.print("<input class=\"form-control\" type='text' name='"+rsmd.getColumnName(i+1)+"' value='"+detail.getString(i+1)+"'/>");
                    }
                    
                    
                    out.print("<br>");
                }
            }
            
            out.print("<button class=\"btn btn-b btn-round\" type='submit' name='action' value='update'>update</button>");
            //out.print("<input type='submit' name = 'action' value='update'>");
            //out.print("<input type='submit' name = 'action' value='delete'>");
            out.print("</form>");
            out.print("</div>");
                out.print("</main>");
                out.print("</table>");
                out.print(" <script src=\"assets/lib/jquery/dist/jquery.js\"></script>\n"
                        + "    <script src=\"assets/lib/bootstrap/dist/js/bootstrap.min.js\"></script>\n"
                        + "    <script src=\"assets/lib/wow/dist/wow.js\"></script>\n"
                        + "    <script src=\"assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js\"></script>\n"
                        + "    <script src=\"assets/lib/isotope/dist/isotope.pkgd.js\"></script>\n"
                        + "    <script src=\"assets/lib/imagesloaded/imagesloaded.pkgd.js\"></script>\n"
                        + "    <script src=\"assets/lib/flexslider/jquery.flexslider.js\"></script>\n"
                        + "    <script src=\"assets/lib/owl.carousel/dist/owl.carousel.min.js\"></script>\n"
                        + "    <script src=\"assets/lib/smoothscroll.js\"></script>\n"
                        + "    <script src=\"assets/lib/magnific-popup/dist/jquery.magnific-popup.js\"></script>\n"
                        + "    <script src=\"assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js\"></script>\n"
                        + "    <script src=\"assets/js/plugins.js\"></script>\n"
                        + "    <script src=\"assets/js/main.js\"></script>\n"
                        + "  </body>\n"
                        + "</html>");
           
        } catch (SQLException ex) {
            Logger.getLogger(AccDetail.class.getName()).log(Level.SEVERE, null, ex);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pgcil
 */
public class ques extends HttpServlet {

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
        String basepath=request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
         int q=(int) session.getAttribute("q");
         int arr[]=(int []) session.getAttribute("arr");
         int i;
        
        
        int diff=(int) session.getAttribute("diff");
        int id=0;
        db2load db2=new db2load();
        ResultSet rs=db2.load(diff);
        int set=0;
        String ans=null,ques="null",opt1="null",opt2="null",opt3="null",opt4="null";
        try {
            //int diff=1;
            ///int count=0;
            while(rs.next())
            {
            
             id=rs.getInt("id");
             log("id is"+id);
             for(i=0;i<q;i++)
             {
                 if(id==arr[i])
                 {
                     response.sendRedirect("ques");
                     set=1;
                     break; 
                 }
             }
             if(set==1)
                 break;
             arr[q]=id;
             ques=rs.getString("ques");
             
             opt1=rs.getString("option a");
             opt2=rs.getString("option b");
             opt3=rs.getString("option c");
             opt4=rs.getString("option d");
             ans=rs.getString("answer");
             session.setAttribute("ans", ans);
             session.setAttribute("q", ++q);
             session.setAttribute("arr",arr);
            }
                  try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap-theme.min.css\">");
            out.println("<script src=\"bootstrap/jquery-1.11.1.min.js\"></script>");
            out.println("<script src=\"bootstrap/js/bootstrap.min.js\"></script>");
            out.println("<title>Servlet ques</title>");            
            out.println("</head>");
            out.println("<body >");
            out.println("<h1 class=\"text-center\">WELCOME! Please answer the question below!</h1><br/>");
            out.println("<p class=\"text-center\">Q"+q+"."+ques+"</p>");
            out.println("<form action=checkans method=\"post\" class=\"form-group\" role=\"form\">");
            
            out.println("   <div class=\"col-md-4 center-block\">\n" +
"    <div class=\"container\">\n" +
"    <br>\n" +
"	<div class=\"row\">\n" +
"        <div class=\"col-md-3 col-md-offset-5\">\n" +
"<div class=\"radio\"><label><input type=\"radio\" name=\"opt\" value=\"1\">"+opt1+"</label></div>" +
"        </div>\n" +
"	</div>\n" +
"    <hr>\n" +
"    <div class=\"row\">\n" +
"    <div class=\"col-md-3 col-md-offset-5\">\n" +
"           \n" +
"<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"2\">"+opt2+"</label></div>" +
"        </div>\n" +
"	</div>\n" +
"    <hr>\n" +
"    <div class=\"row\">\n" +
"        <div class=\"col-md-3 col-md-offset-5\">\n" +
"            \n" +
"<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"3\">"+opt3+"</label></div>" +
"        </div>\n" +
"    </div>\n" +
"    <hr>\n" +
"    <div class=\"row\">\n" +
"    <div class=\"col-md-3 col-md-offset-5\">\n" +
"<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"4\">"+opt4+"</label></div>" +
"        </div>\n" +
"    </div>\n" +
"    <hr>\n" +
"    <div class=\"row\">\n" +
"    <div class=\"col-md-3 col-md-offset-5\">\n" +
"<br/><input type=\"submit\" class=\"btn btn-primary\" value=\"Submit\">" +
"        </div>\n" +
"    </div>\n" +
"    <hr>\n" +                    
"\n" +
"    <br>\n" +
"</div>\n" +
"</div>");
            
        /*    out.println("<div class=\"radio\"><label><input type=\"radio\" name=\"opt\" value=\"1\">"+opt1+"</label></div>");
            out.println("<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"2\">"+opt2+"</label></div>");
            out.println("<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"3\">"+opt3+"</label></div>");
            out.println("<div class=\"radio\"><label><input type=\"radio\"  name=\"opt\" value=\"4\">"+opt4+"</label></div>");
            out.println("<br/><input type=\"submit\" class=\"btn btn-primaryl\" value=\"submit\">");
          */  out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
        } catch (SQLException ex) {
            Logger.getLogger(ques.class.getName()).log(Level.SEVERE, null, ex);
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

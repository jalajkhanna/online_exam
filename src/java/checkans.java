/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pgcil
 */
@WebServlet(urlPatterns = {"/checkans"})
public class checkans extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        int n=(int)session.getAttribute("userid"); 
        int q=(int) session.getAttribute("q");
        String s=(String) session.getAttribute("ans");
        int diff=(int) session.getAttribute("diff");
        int score=(int) session.getAttribute("score");
       
        String abc;
        String abc1=request.getParameter("opt");
        if(s.equals(abc1))
        {
            abc="correct";
            
            score++;
            if(diff<3)
                diff++;
        }
        else
        {
            abc="incorrect";
            if(diff>1)
                diff--;
        }
        
        session.setAttribute("diff", diff);
        session.setAttribute("score", score);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(q==7)
            {
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
              out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap-theme.min.css\">");
            out.println("<script src=\"bootstrap/jquery-1.11.1.min.js\"></script>");
            out.println("<script src=\"bootstrap/js/bootstrap.min.js\"></script>");
            out.println("<title>Servlet checkans</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p class=\"lead\">you are done with test thanks.<br>Your final score is "+score+"</p>");
            out.println("<form action=\"submitmarks\"><input type=\"submit\" class=\"btn btn-primary \" value=\"submit marks\"></form> ");
            out.println("</body>");
            out.println("</html>");
            }
            else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
               out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap-theme.min.css\">");
            out.println("<script src=\"bootstrap/jquery-1.11.1.min.js\"></script>");
            out.println("<script src=\"bootstrap/js/bootstrap.min.js\"></script>");
            out.println("<title>Servlet checkans</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class=\"h1\">Your answer was " +abc+"<br/>Your score is "+score+ "</h1>");
            out.println("<form action=\"ques\"><input type=\"submit\" class=\"btn btn-primary \" value=\"next question\"></form> </body>");
            out.println("</html>");}
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

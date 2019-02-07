/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pgcil
 */
public class test extends HttpServlet {

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
        HttpSession session=request.getSession(false);  
        int n=(int)session.getAttribute("userid");
        int arr[]=new int[7];
        session.setAttribute("arr",arr);
        session.setAttribute("score", 0);
        session.setAttribute("q", 0);
        session.setAttribute("diff", 1);
        DataBaseLoader db1=new DataBaseLoader();
        ResultSet rs=db1.load();
        try {
            while(rs.next())
            {
                if(rs.getInt("id")==n)                
                {   log(rs.getString("name"));
                    log(rs.getString("testgiven"));
                    if(rs.getString("testgiven").equals("Y"))
                    {RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
                    PrintWriter out=response.getWriter();
                    String score=rs.getString("testscore");
                    String grade=rs.getString("grade");
                    out.println("<font color=red>Test already given with score <b>"+score+"</b> and grade <b>"+grade+"</b></font>");
                    rd.include(request, response);
                    }
                      //  log("test already given with score");
                    else
                    {
                        response.sendRedirect("ques");
                    }
                }
            }
            
            
            
            // scheduling the task at interval
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
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

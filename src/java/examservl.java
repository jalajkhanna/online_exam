

import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class examservl extends HttpServlet {
    int id;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
         
        try {
            String email=request.getParameter("inputEmail3");
            String pass=request.getParameter("inputPassword3");
            response.setContentType("text/html;charset=UTF-8");
            DataBaseLoader db=new DataBaseLoader();
            ResultSet rs=db.load();
            String str1,str2;
            log("from form"+email+pass);
            int k=0;
            while(rs.next())
            {
               
                str1=rs.getString("name");
                str2=rs.getString("pass");
                log(str1+str2);
                
                
                if(str1.equals(email) && str2.equals(pass))
                {   k=1;
                    id=rs.getInt("id");
                    /*log("matched");
                    out.println("<form action=\"home.html\" method=\"GET\">");
                    out.println("<input type=\"submit\" value=\"submit\">");
                    out.println("</form>");*/
                    response.sendRedirect("HomePage?user_id="+id+"");
                    break;
                }   else{
                   
                    
                }
             
               
            }
            if(k==0)
            {
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                    
                    out.println("<font color=red>Either user name or password is wrong.</font>");
                    rd.include(request, response);
             
            }
            db.closeconn();
        } catch (Exception ex) {
            //Logger.getLogger(examservl.class.getName()).log(Level.SEVERE, null, ex);
            log(ex.toString());
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
        
       // processRequest(request, response);
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

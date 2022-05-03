
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

 
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         Date createtime = new Date(session.getCreationTime());
         Date lastaccesstime = new 
          Date(session.getLastAccessedTime());
        String title = "Welcome back to my Website";
        Integer visitcount = 0;
        String visitcountkey = "visitcount";
        response.setContentType("text/html;charset=UTF-8");
         try ( PrintWriter out = response.getWriter()) {
        if(session.isNew()){
             title = "Welcome to my Website";
         }
      else
      {
        visitcount = (Integer) 
        session.getAttribute(visitcountkey);
        visitcount = visitcount + 1;
         }
        session.setAttribute(visitcountkey, visitcount);
           out.println("<h1 align='center'>" + title +"</h1>" + "<br/><br/>");
           out.println("Session ID: " + session.getId() + "<br/>");
           out.println("Session Creation time: " + createtime + "<br/>");
           out.println("Time of last Access: " + lastaccesstime + "<br/>");
           out.println("Visit Count: " + visitcount + "<br/>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

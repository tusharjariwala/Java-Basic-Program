
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "checkServlet", urlPatterns = {"/checkServlet"})
public class checkServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       Integer age=Integer.parseInt(request.getParameter("Age"));
       RequestDispatcher rd=request.getRequestDispatcher("index.html");
       
        try ( PrintWriter out = response.getWriter()) {
       
            if(age<18)
            {
                rd.include(request, response);
            out.println("<center><span style='color:red'>Sorry !you are not eligible to Vote</span></center>");
            
        }else
            {
                rd.include(request, response);
                out.println("<center><span style='color:red'> you are  eligible to Vote</span></center>");
            
            }
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

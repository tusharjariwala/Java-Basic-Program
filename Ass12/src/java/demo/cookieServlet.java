
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "cookieServlet", urlPatterns = {"/cookieServlet"})
public class cookieServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Cookie ck=new Cookie("Name",request.getParameter("name"));
            Cookie ck1=new Cookie("email",request.getParameter("email"));
            response.addCookie(ck);
            response.addCookie(ck1);
            
            Cookie ck2[]=request.getCookies();
            for(int i=0;i<ck2.length;i++)
            {
                out.println("<br>"+ck2[i].getName()+":" +ck2[i].getValue());
            }
            out.println("</html>");
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

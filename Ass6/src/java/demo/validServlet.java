
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "validServlet", urlPatterns = {"/validServlet"})
public class validServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        
        boolean status=false;
        
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/test2";
        
        String user="root";
        String pass="root";
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
           Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);

           PreparedStatement ps = con.prepareStatement("SELECT * FROM users where username=? and password=?");
           ps.setString(1, name);
           ps.setString(2, password);
 
           ResultSet rs = ps.executeQuery();
 
           status = rs.next();
 
           if(status)
           {
           RequestDispatcher rd = 
           request.getRequestDispatcher("success");
          rd.forward(request, response);
          }
           else
           {
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request, response);
          out.println("<center><span style='color:red'>Please enter correct username or password</span></center>");
          }
 
 
      } catch(Exception e){
         System.out.println(e);
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

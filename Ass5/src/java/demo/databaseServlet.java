
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;;

@WebServlet(name = "databaseServlet", urlPatterns = {"/databaseServlet"})
public class databaseServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String driver = "com.mysql.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/test2";
     String user = "root";
       String pass = "root";
       
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            Class.forName(driver);
 

     Connection con = DriverManager.getConnection(url, user, pass);
 

       Statement stmt = con.createStatement();
       String sql = "SELECT * FROM users";
       ResultSet rs = stmt.executeQuery(sql);
 
       out.println("<html><body><table border='1' style='border-collapse: collapse'>");
       out.println("<tr>");
       out.println("<td>ID</td>" + "<td>UserName</td>" + "<td>Password</td>");
        out.println("</tr>");
 
         while(rs.next()){
       int id = rs.getInt("userId");
       String username = rs.getString("username");
       String password = rs.getString("password");
 
       out.println("<tr>");
       out.println("<td>" + id + "</td>");
       out.println("<td>" + username + "</td>");
       out.println("<td>" + password + "</td>");
       out.println("</tr>");
      }
      out.println("</table></body></html>");
 
      rs.close();
      stmt.close();
       con.close();
      } catch (Exception e) {
       e.printStackTrace();
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

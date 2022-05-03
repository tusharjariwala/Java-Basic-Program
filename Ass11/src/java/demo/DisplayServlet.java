
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DisplayServlet", urlPatterns = {"/DisplayServlet"})
public class DisplayServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test2";
 
        String user = "root";
        String pass = "root";
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Class.forName(driver);
 
            Connection con = DriverManager.getConnection(url, user, pass);
 
            Statement stmt = con.createStatement();
            String sql = "SELECT * from mobile_master";
            ResultSet rs = stmt.executeQuery(sql);
 
           out.println("<html><body><center><table border='1' style='border-collapse: collapse'>");
           out.println("<tr>");
           out.println("<td>ID</td><td>Mobile Brand</td><td>Model</td><td>Price</td>");
           out.println("</tr>");
 
           while(rs.next()){
         int id = rs.getInt("ID");
         String brand = rs.getString("Brand");
         String model = rs.getString("Model");
         String price = rs.getString("Price");
 
         out.println("<tr>");
         out.println("<td>" + id + "</td>");
         out.println("<td>" + brand + "</td>");
         out.println("<td>" + model + "</td>");
         out.println("<td>" + "Rs. " + price + "/-" + "</td>");
         out.println("</tr>");
        }
         out.println("</table></center></body></html>");
 
        rs.close();
       stmt.close();
       con.close();
      }catch(Exception e){
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


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


@WebServlet(name = "showServlet", urlPatterns = {"/showServlet"})
public class showServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String driver="com.mysqli.jdbc.Driver";
         String url="jdbc:mysql://localhost:3306/test2";
        
        String user="root";
        String pass="root";
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pass);
            
            Statement stmt=con.createStatement();
            String sql="select * from teachers";
            ResultSet rs=stmt.executeQuery(sql);
            out.println("<html><body><center><table border='1' style='border-collapse:collapse'>");
            out.println("<tr>");
            out.println("<td>ID</td><td>Name</td><td>Department</td><td>Subject</td>");
            out.println("</tr>");
   
            while(rs.next())
            {
                int id=rs.getInt("teacherId");
                String name=rs.getString("name");
                String department=rs.getString("department");
                String subject=rs.getString("subject");
                
                out.println("<tr>");
                out.println("<td>"+id+"</td>");
                out.println("<td>"+name+"</td>");
                out.println("<td>"+department+"</td>");
                out.println("<td>"+subject+"</td>");
                out.println("<tr>");
                  
            }
          out.println("</table></center></body></html>");
                rs.close();
                stmt.close();
                con.close();
        }catch(Exception e)
        {
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

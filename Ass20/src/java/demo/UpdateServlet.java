
package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String driver="com.mysql.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/test2";
       String user="root";
       String pass="root";
       int empid=Integer.parseInt(request.getParameter("empid"));
       int salary=Integer.parseInt(request.getParameter("salary"));
       
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
          Class.forName(driver);
          Connection con=DriverManager.getConnection(url,user,pass);
          PreparedStatement ps=con.prepareStatement("update employee_master set salary=? where id=?");
         
          ps.setInt(1,salary);
          ps.setInt(2,empid);
         
          ps.executeUpdate();
          ps.close();
          con.close();
         
          RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
          rd.include(request,response);
          out.println("<center><span>Record Updated</span></center>");
          
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

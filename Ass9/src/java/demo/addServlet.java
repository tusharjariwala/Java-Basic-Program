
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

@WebServlet(name = "addServlet", urlPatterns = {"/addServlet"})
public class addServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String driver="com.mysql.jdbc.Driver";
         String url="jdbc:mysql://localhost:3306/test2";
         
         String user="root";
         String pass="root";
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps=con.prepareStatement("insert into teachers(name,department,subject) values(?,?,?)");
            ps.setString(1, request.getParameter("teachername"));
            ps.setString(2, request.getParameter("department"));
            ps.setString(3, request.getParameter("subject"));
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
            RequestDispatcher rd= request.getRequestDispatcher("index.html");
            rd.include(request,response);
            out.println("<center><span>Record Inserted sucessfully!</span></center>");
            
            
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

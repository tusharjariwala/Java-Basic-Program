
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Data</title>
    </head>
    <body>
           <div align="center">
            <h1>Employee Data</h1>
            <form action="UpdateServlet" method="post">
                Employee ID:<input type="text" name="empid" /><br/><br/>
                New Salary:<input type="text" name="salary" /><br/><br/>
                <input type="submit" value="Update Salary"/><br/><br/>
             </form>
            
            <sql:setDataSource var="empdata" driver="com.mysql.jdbc.Driver"url="jdbc:mysql://localhost/test2"user="root" password="root" />
             <sql:query dataSource="${empdata}" var="result">
             SELECT * from employee_master;
              </sql:query>

            <table border="1" width="20%">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Salary</th>
                   
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><c:out value="${row.id}" /></td>
                            <td><c:out value="${row.name}" /></td>
                            <td><c:out value="${row.department}" /></td>
                            <td><c:out value="${row.salary}" /></td>
                            
                            </tr>
                    </c:forEach>
                            
            </table>
        </div>
    </body>
</html>

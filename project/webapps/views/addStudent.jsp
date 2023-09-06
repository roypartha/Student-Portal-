<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<html>
<head>
<title>New Applicants</title>
<style>
table {
  border-collapse: collapse;
  margin: 0 auto;
}
th, td {
  border: 2px solid black;
  padding: 10px;
  text-align: center;
}
td a {
  text-decoration: none;
}
</style>
</head>
<body>
<h1 align="center">New Applicants List</h1>
<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Department</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Birthdate</th>
    <th>Add</th>
    <th>Delete</th>
</tr>
<%
    // Get a data source from JNDI
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");

    // Create a database connection
    Connection conn = ds.getConnection();

    // Execute a query to get all records from the new_applicant table
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM new_applicant");

    // Loop through the result set and output a table row for each record
    while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String dept = rs.getString("dept");
        String email = rs.getString("email");
        String mobile = rs.getString("mobile");
        Date birthdate = rs.getDate("birthdate");
%>
<tr>
    <td><%=id%></td>
    <td><%=name%></td>
    <td><%=age%></td>
    <td><%=dept%></td>
    <td><%=email%></td>
    <td><%=mobile%></td>
    <td><%=birthdate%></td>
    <td><a href="/project/addDelete?id=<%=id%>&set=1">Add</a></td>
    <td><a href="/project/addDelete?id=<%=id%>&set=2">Delete</a></td>
</tr>
<%
    }
%>
</table>
<%
    // Close the database connection and result set
    rs.close();
    stmt.close();
    conn.close();
%>
</body>
</html>
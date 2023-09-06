<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<html>
<head>
	<title>Student Info Form</title>
</head>
<body>
	<h1 align="center" >Student Info Form</h1>
	<form method="post" >
		<%
			String id = request.getParameter("id");


			if (id != null && !id.equals("")) {
				// Get a data source from JNDI
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");

				// Create a database connection
				Connection conn = ds.getConnection();

				// Execute a query to get the students information
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student_info WHERE id=?");
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					String name = rs.getString("name");
					String age = rs.getString("age");
					String dept = rs.getString("dept");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					String birthdate = rs.getString("birthdate");
		%>
		<p>
			<label>Name:</label>
			<input type="text" name="name" value="<%=name%>" />
		</p>
		<p>
			<label>Age:</label>
			<input type="text" name="age" value="<%=age%>" />
		</p>
		<p>
			<label>Department:</label>
			<input type="text" name="dept" value="<%=dept%>" />
		</p>
		<p>
			<label>Email:</label>
			<input type="text" name="email" value="<%=email%>" />
		</p>
		<p>
			<label>Mobile:</label>
			<input type="text" name="mobile" value="<%=mobile%>" />
		</p>
		<p>
			<label>Birthdate:</label>
			<input type="text" name="birthdate" value="<%=birthdate%>" />
		</p>
		<%
				}

				// Close the database connection and result set
				rs.close();
				stmt.close();
				conn.close();
			}
		%>
		<p>
			<label>ID:</label>
			<input type="text" name="id" value="<%=id%>" />
		</p>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>

<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%
    // Get the "set" parameter value from the request
    String setParam = request.getParameter("set");

    // Check if the "set" parameter is present and has a value of "1"
    if (setParam != null && setParam.equals("1")) {
        // Get the "id" parameter value from the request
        String idParam = request.getParameter("id");

        // Check if the "id" parameter is present
        if (idParam != null) {
            // Convert the "id" parameter to an integer
            int id = Integer.parseInt(idParam);

            try {
                // Get a data source from JNDI
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");

                // Create a database connection
                Connection conn = ds.getConnection();

                // Insert the new record into the student_info table
                PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO student_info (id, name, age, email, mobile, birthdate,dept) SELECT id, name, age, email, mobile, birthdate,dept FROM new_applicant WHERE id = ?");
                insertStmt.setInt(1, id);
                int rowsInserted = insertStmt.executeUpdate();

                // Delete the record from the new_applicant table
                PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM new_applicant WHERE id = ?");
                deleteStmt.setInt(1, id);
                int rowsDeleted = deleteStmt.executeUpdate();

                // Close the database connections
                insertStmt.close();
                deleteStmt.close();
                conn.close();

                // Redirect the user to the home page
                response.sendRedirect(request.getContextPath() + "/views/addStudent.jsp");
            } catch (Exception e) {
                // Handle any database errors
                e.printStackTrace();
            }
        }
    } else if (setParam != null && setParam.equals("2")) {
        // Get the "id" parameter value from the request
        String idParam = request.getParameter("id");

        // Check if the "id" parameter is present
        if (idParam != null) {
            // Convert the "id" parameter to an integer
            int id = Integer.parseInt(idParam);

            try {
                // Get a data source from JNDI
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/student");

                // Create a database connection
                Connection conn = ds.getConnection();

                // Delete the record from the new_applicant table
                PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM new_applicant WHERE id = ?");
                deleteStmt.setInt(1, id);
                int rowsDeleted = deleteStmt.executeUpdate();

                // Close the database connections
                deleteStmt.close();
                conn.close();

                // Redirect the user to the home page
                response.sendRedirect(request.getContextPath() + "/views/addStudent.jsp");
            } catch (Exception e) {
                // Handle any database errors
                e.printStackTrace();
            }
        }
    }
%>

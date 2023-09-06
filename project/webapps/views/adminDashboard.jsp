<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Dashboard</title>
</head>
<body>
<h1 align="center" >Admin Dashboard</h1>
<p align="center">Welcome, <%=session.getAttribute("email")%>!</p>
	<table border="1">
		<thead>
			<tr>
				<th>Dashboard Options</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<td><a href="/project/adminProfile">Profile</a></td>
			</tr>
			<tr>
				<td><a href="/project/addStudent">Add Student</a></td>
			</tr>
			<tr>
				<td><a href="/project/deleteStudent">Delete Student</a></td>
			</tr>
			<tr>
				<td><a href="/project/update">Update Student Information</a></td>
			</tr>
			<tr>
            	<td><a href="/project/changePassword">Change Password</a></td>
            </tr>

			<tr>
				<td><a href="/project/studentList?dept=cse">(View Student List)->CSE</a></td>
			</tr>
			<tr>
				<td><a href="/project/studentList?dept=eee">(View Student List)->EEE</a></td>
			</tr>
			<tr>
                <td><a href="/project/logout">Logout</a></td>
            </tr>
		</tbody>
	</table>
</body>
</html>

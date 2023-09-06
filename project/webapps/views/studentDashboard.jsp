<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Dashboard</title>
</head>
<body>
<h1 align="center" >Student Dashboard</h1>
<p align="center">Welcome, <%=session.getAttribute("email")%>!</p>
	<table border="1">
		<thead>
			<tr>
				<th>Dashboard Options</th>

			</tr>
		</thead>
		<tbody>

			<tr>
				<td><a href="/project/studentProfile">Profile</a></td>
			</tr>
			<tr>
				<td><a href="/project/">Registration</a></td>
			</tr>
			<tr>
				<td><a href="/project/">Account</a></td>
			</tr>
			<tr>
				<td><a href="/project/">Course</a></td>

			</tr>
			<tr>
                <td><a href="/project/">Result</a></td>
            </tr>

			<tr>
                <td><a href="/project/changePassword">Change Password</a></td>
            </tr>

			<tr>
                <td><a href="/project/logout">Logout</a></td>
            </tr>
		</tbody>
	</table>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile</title>

<style>
/* Center the image */
img {
  display: block;
  margin: 0 auto;
}

/* Make the image circular */
img.circular {
  border-radius: 50%;
}
</style>

</head>
<body>
	<h1 align="center">Admin Profile</h1>
	<p align="center">Welcome, <%=session.getAttribute("email")%>!</p>
	<img src="views/img.png" alt="Student Profile Picture" class="circular">
	<hr>
	<table align="center">


		<tr>
			<th>ID:</th>
			<td><%=session.getAttribute("email")%></td>
		</tr>


	</table>


</body>
</html>

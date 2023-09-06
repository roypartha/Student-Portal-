<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Update</title>
	<style>
    		input[type="submit"] {
    			background-color: blue;
    			color: white;
    		}

    	</style>
</head>
<body>

	<div align="center">
		<h1>Update Student</h1>
		<hr>

		<form method="post">
			<table>
				<tr>
					<td>
						<fieldset>
							<legend><b>Update:</b></legend>
							<table>
								<tr>
									<th>
										<label for="id">Enter Student ID : </label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="id" id="id" value=${requestScope.email}>
									</td>
									<td>
									    <p style="color: red;">${requestScope.emailErrMsg}</p>
  									</td>
								</tr>

									<td align="right">
										<input type="submit" value="Submit">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>


	</div>


</body>
</html>


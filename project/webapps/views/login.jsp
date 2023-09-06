<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<style>
    		input[type="submit"] {
    			background-color: blue;
    			color: white;
    		}

    	</style>
</head>
<body>

	<div align="center">
		<h1>Login Page </h1>
		<hr>
		<div align="left">
        		    <button type="button" ><a href="/project/index">HOME</a></button>
        </div>
        <br>
        <fieldset>
		<form method="post">
			<table>
				<tr>
					<td>
						<fieldset>
							<legend><b>Login:</b></legend>
							<table>
								<tr>
									<th>
										<label for="email">User Name</label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="email" id="email" value=${requestScope.email}>
									</td>
									<td>
									    <p style="color: red;">${requestScope.emailErrMsg}</p>
  									</td>
								</tr>
								<tr>
									<th>
										<label for="password">Password</label>
									</th>
									<td>:</td>
									<td>
										<input type="password" name="password" id="password">
									</td>
									<td>
									    <p style="color: red;">${requestScope.passwordErrMsg}</p>
									</td>
								</tr>
								<tr>
									<th></th>
									<td></td>
									<td align="right">
										<input type="submit" value="Login">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>

        <p style="color: red;">${requestScope.errMsg}</p>

		<p>Don't have an account?  <a href="/project/registration">New Applicant</a></p>
		<p> Can’t access your account?  <a href="/project/forgetPassword">Forget Password</a></p>

	</fieldset>
	</div>


</body>
</html>
<%@ include file="includes/footer.jsp" %>
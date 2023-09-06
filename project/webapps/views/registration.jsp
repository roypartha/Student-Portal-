<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Registration</title>
	<style>
        input[type="submit"] {
            background-color: blue;
            color: white;
        }

    </style>
</head>
<body>

	<div align="center">
		<h1>Registration</h1>
		<hr>
		<div align="left">
		    <button type="button" ><a href="/project/index">HOME</a></button>
		</div>

		<form method="post">
			<table>
				<tr>
					<td>
					     <fieldset>
                            <p> <h3 style = " color: green;">Applicant Registration</h3>
                              Welcome to new applicant registration. Please fill out the following information.</p>
                         </fieldset>
                         <br>
						<fieldset>
							<legend><b style = " color: green;">Personal Information:</b></legend>
							<table>
								<tr>
									<th>
										<label for="name">Name</label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="name" id="name" value="${requestScope.name}">
									</td>
									<td>
									    ${requestScope.nameErrMsg}
  									</td>
								</tr>
								<tr>
									<th>
										<label for="age">Age</label>
									</th>
									<td>:</td>
									<td>
										<input type="number" name="age" id="age" value="${requestScope.age}">
									</td>
									<td>
									    ${requestScope.ageErrMsg}
									</td>
								</tr>
								<tr>
									<th>
										<label for="birthdate">Birthdate</label>
									</th>
									<td>:</td>
									<td>
										<input type="date" name="birthdate" id="birthdate" value="${requestScope.birthdate}">
									</td>
									<td>
									    ${requestScope.birthdateErrMsg}
									</td>
								</tr>
								<tr>
									<th>
										<label for="mobile">Mobile</label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="mobile" id="mobile" value="${requestScope.mobile}">
									</td>
									<td>
									    ${requestScope.mobileErrMsg}
									</td>
								</tr>
								<tr>
									<th>
										<label for="email">Email</label>
									</th>
									<td>:</td>
									<td>
										<input type="email" name="email" id="email" value="${requestScope.email}">
									</td>
									<td>
									   ${requestScope.emailErrMsg}
									</td>

								</tr>
                                <tr>
									<th>
										<label for="dept">Department:</label>
									</th>
									<td>:</td>
									<td>
										<select name="dept" id="dept">
                                        <option value="CSE">CSE</option>
                                        <option value="EEE">EEE</option>
                                    </select>
									</td>
									<td>
									   ${requestScope.emailErrMsg}
									</td>

								</tr>


								<tr>
									<th></th>
									<td></td>
									<td align="right">
										<input type="submit" value="Register">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>

		${requestScope.errMsg}

		<p>Already have an account?  <a href="/project/login">Login</a>.</p>
	</div>

</body>
</html>

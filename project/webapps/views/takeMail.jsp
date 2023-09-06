<%@ include file="includes/header.jsp" %>

<h1 align="center">Forget Password</h1>
<hr>
<br>
<form method="post" >
			<table>
				<tr>
					<td>
						<fieldset>
							<legend><b>Forget Password:</b></legend>
							<table>
								<tr>
									<th>
										<label for="email">Email</label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="email" id="email" value=${requestScope.currentPassword}>
									</td>
									<td>
									    ${requestScope.currentPasswordErrMsg}
  									</td>
								</tr>
								<tr>
									<th>
										<label for="ID">ID</label>
									</th>
									<td>:</td>
									<td>
										<input type="text" name="id" id="id">
									</td>
									<td>
									    ${requestScope.newPasswordErrMsg}
									</td>
								</tr>


								<tr>
									<th></th>
									<td></td>
									<td align="right">
										<input type="submit" value="forget Password">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>


<%@ include file="includes/footer.jsp" %>
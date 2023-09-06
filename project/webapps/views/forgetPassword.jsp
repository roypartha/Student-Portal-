<%@ include file="includes/header.jsp" %>

<h1 align="center">Change Password</h1>
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
                                        <label for="id">ID</label>
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
									<th>
										<label for="new_password">New Password</label>
									</th>
									<td>:</td>
									<td>
										<input type="password" name="new_password" id="new_password">
									</td>
									<td>
									    ${requestScope.newPasswordErrMsg}
									</td>
								</tr>
								<tr>
                                    <th>
                                        <label for="confirm_password">Confirm Password</label>
                                    </th>
                                    <td>:</td>
                                    <td>
                                        <input type="password" name="confirm_password" id="confirm_password">
                                    </td>
                                    <td>
                                        ${requestScope.confirmPasswordErrMsg}
                                    </td>
                                </tr>
								<tr>
									<th></th>
									<td></td>
									<td align="right">
										<input type="submit" value="Change Password">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>

<%@ include file="includes/footer.jsp" %>
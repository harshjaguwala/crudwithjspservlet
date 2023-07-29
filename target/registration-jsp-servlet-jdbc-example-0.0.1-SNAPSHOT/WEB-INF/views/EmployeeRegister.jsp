<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee form</h1>

		<form action="<%=request.getContextPath()%>/register" method="post">
			<table style="width: 80%">
				<tr>
					<td>id :</td>
					<td><input type="text" name=id" /></td>
				</tr>

				<tr>
					<td>First Name :</td>
					<td><input type="text" name="firstname" /></td>
				</tr>

				<tr>
					<td>skills :</td>
					<td><input type="text" name="skills" /></td>
				</tr>

				<tr>
					<td>Age :</td>
					<td><input type="text" name="age" /></td>
				</tr>

				<tr>
					<td>salary :</td>
					<td><input type="text" name="salary" /></td>
				</tr>


				<tr>
					<td>Joining date :</td>
					<td><input type="text" name="joiningdate" /></td>
				</tr>


				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employee</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a><br/>
				<form method="post" action="showskillwise">
					<select name="skills" >
						<option value="">select skill</option>
						<c:forEach var="skills" items="${skills}">
							<option value="">${skills.skills}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-info"  >Show</button>
				</form>
			</div>

			<div></div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>

						<th>Name</th>
						<th>skills</th>
						<th>age</th>
						<th>salary</th>
						<th>joiningdate</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="emp" items="${listemp}">

						<tr>

							<td><c:out value="${emp.firstname}" /></td>
							<td><c:out value="${emp.skills}" /></td>
							<td><c:out value="${emp.age}" /></td>
							<td><c:out value="${emp.salary}" /></td>
							<td><c:out value="${emp.joiningdate}" /></td>
							<td><a href="edit?id=<c:out value='${emp.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${emp.id}' />">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
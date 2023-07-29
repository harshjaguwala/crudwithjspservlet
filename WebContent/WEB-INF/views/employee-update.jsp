<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div align="center">
				<a href="https://www.javaguides.net" class="navbar-brand"> Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
            			Edit User
            		</c:if>
						<c:if test="${emp == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${emp != null}">
					<input type="hidden" name="id" value="<c:out value='${emp.id}' />" />
					<%-- <input type="hidden" name="id1" value="<c:out value='${emp.skillid}' />" /> --%>
				</c:if>
				
				<fieldset class="form-group">
					<label>First Name</label>
					<input type="text" value="<c:out value='${emp.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>

				

				<fieldset class="form-group">
					<label>Age</label>
					<input type="text" value="<c:out value='${emp.age}' />" class="form-control"
						name="age" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>salary</label>
					<input type="text" value="<c:out value='${emp.salary}' />" class="form-control"
						name="salary" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>joiningdate</label>
					<input type="text" value="<c:out value='${emp.joiningdate}' />" class="form-control"
						name="joiningdate" required="required">
				</fieldset>
				
				
				
				<fieldset class="form-group">
					<label>gender</label>
					<c:if test = "${fn:contains({emp.gender}, 'Male')}">
         				Male : <input type="radio"  value='Male' name="gender" required="required" checked>
         				Female : <input type="radio"  value='Female' name="gender" required="required" >
         			</c:if>
      				 <c:if test = "${fn:contains({emp.gender}, 'Female')}">
         				Male : <input type="radio"  value='Male' name="gender" required="required" >
         				Female : <input type="radio"  value='Female' name="gender" required="required" checked>
         			 </c:if>
         			 
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Skill</label>
					  <c:if test = "${fn:contains({emp.skills}, 'java')}">
         				Java  : <input type="checkbox" value="Java" checked name="skill" >
         				Mysql  : <input type="checkbox" value="Mysql"   name="skill" >
         			</c:if>
      				 <c:if test = "${fn:contains({emp.skills}, 'Mysql')}">
         				Mysql  : <input type="checkbox" value="Mysql"  checked name="skill" >
         				Java  : <input type="checkbox" value="Java"  name="skill" >
         			 </c:if>
					
					 <%-- <c:choose>
         				 <c:when test = "${fn:contains({emp.skills}, 'java')} && ${fn:contains({emp.skills}, 'Mysql')}">
				            Java  : <input type="checkbox" value="<c:out value='${emp.skills}' />" checked name="skill" >
         					Mysql  : <input type="checkbox" value="<c:out value='${emp.skills}' />" checked  name="skill" >
				         </c:when>
				         
				         <c:when test = "${fn:contains({emp.skills}, 'java')}}">
				            Java  : <input type="checkbox" value="<c:out value='${emp.skills}' />" checked name="skill" >
         					Mysql  : <input type="checkbox" value="<c:out value='${emp.skills}' />"   name="skill" >

				         </c:when>
				         
				         <c:otherwise>
				            Mysql  : <input type="checkbox" value="<c:out value='${emp.skills}' />"  checked name="skill" >
         					Java  : <input type="checkbox" value="<c:out value='${emp.skills}' />"  name="skill" >
				         </c:otherwise>
				     </c:choose> --%>
				</fieldset>

				<button type="submit" class="btn btn-success"  >Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
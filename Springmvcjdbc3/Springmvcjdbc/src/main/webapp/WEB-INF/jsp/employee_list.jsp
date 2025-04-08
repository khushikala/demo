<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../webjars/jquery/3.0.0/js/jquery.min.js"></script>

</head>
<body>
	<div class="container">
		<h2>Employee List Details</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Job Title</th>
					<th>Country</th>
					<th>SEX</th>
					<th>FirstAttempt</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employee_list}" var="employee">
					<tr>
						<td>${employee.employeeId}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.email}</td>
						<td>${employee.phone}</td>
						<td>${employee.jobtitle}</td>
						<td>${employee.country}</td>
						<td>${employee.sex}</td>
						<td>${employee.firstAttempt}</td>
						
						<td><spring:url
								value="/employee/update/${employee.employeeId }" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a></td>
						<td><spring:url
								value="/employee/delete/${employee.employeeId }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }"   role="button">Delete</a>


						</td>


					</tr>



				</c:forEach>


			</tbody>
		</table>
		
		<spring:url value="/employee/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New
			Employee</a>
		
	</div>

</body>
</html>
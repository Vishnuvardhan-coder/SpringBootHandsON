<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<script>

function confirmDelete(){
	return confirm("Are you sure, you want to delete?")
}

</script>

</head>
<body>

	<a href="loadForm" class="btn btn-success">+Add New Contact</a>

	<h3>View Details Here</h3>

	<table border="2" width="70%" cellpadding="2">
		<thead border="1">
			<tr>

				<th>Contact Name</th> 
				<th>Contact Number</th> 
				<th>Contact Email</th>
			    <th>Action</th>

			</tr>
		</thead>

		<tbody>

			<c:forEach items="${contacts}" var="c">

				<tr>
					<td>${c.contactName}</td>
					<td>${c.contactNumber}</td>
					<td>${c.contactEmail}</td> &nbsp;
					<td><a href="edit?cid=${c.contactId}" class="btn btn-primary">Edit</a> &nbsp; 
					<a href="delete?cid=${c.contactId}" onclick="return confirmDelete()" class="btn btn-danger">Delete</a></td>
				</tr>


			</c:forEach>


		</tbody>



	</table>

</body>
</html>
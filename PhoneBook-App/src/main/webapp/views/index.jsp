<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>

	<h4>Save Contact</h4>

	${succMsg} ${errMsg}

	<form:form action="saveContact?contactId=${contact.contactId}"
		method="POST" modelAttribute="contact">

		<%-- <table>
			<tr>
				<td>Contact Name :</td>
				<td><form:input path="contactName" /></td>
			</tr>

			<tr>
				<td>Contact Number</td>
				<td><form:input path="contactNumber" /></td>
			</tr>

			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail" /></td>
			</tr>  --%>



		<div class=container>
			Contact Name :
			<form:input path="contactName" value="${contact.contactName}"
				class="form-control" />
		</div>

		<div class=container>
			Contact Number :
			<form:input path="contactNumber" value="${contact.contactNumber}"
				class="form-control" />
		</div>


		<div class=container>
			Contact Email :
			<form:input path="contactEmail" value="${contact.contactEmail}"
				class="form-control" />
		</div>


 <div class="text-center">
				<input type="submit"  class='btn btn-success'  value="Enroll" />
            </div>

		<br />
		<a href="viewContacts" type="button" class="btn btn-primary">View
			All Contacts</a>
	</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Create: Student Database</title>
</head>
<body>
	<h3>Fill student information below:</h3>
	<form id="submitForm" action="create/studentdatabase" method="post">
		<table>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" id="name" required></td>
			</tr>
			<tr>
				<td>DOB: </td>
				<td><input type="date" name="dob" id="dob" required></td>
			</tr>
			<tr>
				<td>Roll No.: </td>
				<td><input type="number" name="rollNo" id="rollNo" required></td>
				<td id="errorRollNo"></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><input type="text" name="address" id="address" required></td>
			</tr>
			<tr> 
				<td>Phone: </td>
				<td><input type="number" name="phone" id="phone" required></td>
				<td id="errorPhone"></td>
			</tr>
			<tr>
				<td>Department: </td>
				<td><input type="text" name="department" id="department" required></td>
			</tr>
		</table>
		<br>
		<input type="submit">
	</form>

	<script type="text/javascript" src="/scripts/create.js"></script>
</body>
</html>
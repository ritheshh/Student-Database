<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit: Student Database</title>
</head>
<body>
	<h3>Enter the student Roll No. to Edit:</h3>
	<div id="div_RollNo">
		<form action="editDatabase" id="submit_RollNo">
			<table>
				<tr>
					<td>Roll No.: </td>
					<td><input type="number" name="rollNo" id="rollNo" required></td>
					<td id="errorRollNo"></td>
				</tr>
			</table>
			<br>
			<input type="submit">
		</form>
	</div>
	<div id="div_StudentData" style="display: none;">
		<form id="submit_StudentData" action="edit/studentdatabase" method="post">
			<table>
				<tr>
					<td>Name: </td>
					<td><input type="text" name="name" id="name_StudentData" required></td>
				</tr>
				<tr>
					<td>DOB: </td>
					<td><input type="date" name="dob" id="dob_StudentData" required></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><input type="text" name="address" id="address_StudentData" required></td>
				</tr>
				<tr> 
					<td>Phone: </td>
					<td><input type="number" name="phone" id="phone_StudentData" required></td>
					<td id="errorPhone"></td>
				</tr>
				<tr>
					<td>Department: </td>
					<td><input type="text" name="department" id="department_StudentData" required></td>
				</tr>
			</table>
			<input type="hidden" name="rollNo" id="rollNo_StudentData" required>
			<br>
			<input type="submit">
		</form>
	</div>
	<script type="text/javascript" src="/scripts/edit.js"></script>
</body>
</html>
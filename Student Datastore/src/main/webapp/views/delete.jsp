<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete: Student Database</title>
</head>
<body>
	<h3>Enter the student Roll No. to Delete:</h3>
	<form action="deleteDatabase" id="submitForm">
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
	
	<script type="text/javascript" src="/scripts/delete.js"></script>
</body>
</html>
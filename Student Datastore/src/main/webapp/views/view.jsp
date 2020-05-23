<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View: Student Database</title>
<style>
	td,th {
		padding: 10px 30px 10px 0px;
	}
</style>
</head>
<body>
	<table>
	<caption> <h3>Student Database</h3> </caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>DOB</th>
				<th>Roll No.</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Department</th>
			</tr>
		</thead>
		<tbody id="tableBody_SD"> 

		</tbody>
	</table>
	<br>
	<form action="index.html">
		<input type="submit" value="Return">
	</form>
	<script type="text/javascript" src="/scripts/view.js"></script>
</body>
</html>
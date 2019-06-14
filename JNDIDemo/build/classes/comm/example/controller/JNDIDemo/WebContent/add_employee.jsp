<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		List<String> l = (List<String>) request.getAttribute("ERROR");
		if (l != null) {
			
			for(String str:l)
			{%>
				<font color='red'><%=str%></font><br/>
			<% }%>

		<% }%>
	


	<form id="form-1" action="controller.do1" method="post">

		<h1>ADD AN EMPLOYEE</h1>
		<table id="table-1">
			<tbody>
				<tr>
					<td><label>Employee ID:</label></td>
					<td><input id="input-1" name="e_id" required="true"
						type="text" /></td>

				</tr>
				<tr>
					<td><label>First Name</label></td>
					<td><input id="input-2" name="e_fname" required="true"
						type="text" /></td>

				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><input id="input-3" name="e_lname" required="true"
						type="text" /></td>

				</tr>
				<tr>
					<td><label>Salary</label></td>
					<td><input id="input-4" name="e_sal" placeholder="Text"
						min="1000" max="20000" required="true" type="number" /></td>

				</tr>
				<tr>
					<td><input type="submit" value="Add Employee" id="button-1" /></td>
					<td><input type="reset" value="Reset Data"></td>

				</tr>
			</tbody>
		</table>

	</form>

</body>
</html>
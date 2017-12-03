<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Add user</title>
</head>
<body>
<h3>Welcome, Enter The User Details</h3>
<form:form method="POST" action="addUser" modelAttribute="addUser">
	<table>
		<tr>
			<td><form:label path="email">email</form:label></td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td><form:label path="password">password</form:label></td>
			<td><form:password path="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>
</form:form>
</body>
</html>

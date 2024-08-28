<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to signup form</h1>
	<form action ="./pm" method ="post">
		<table>
			<tr>
				<td>userName</td>
			</tr>

			<tr>
				<td><input type="text" name="name"></td>
			</tr>
 
            
            
			<tr>
				<td>password</td>
			</tr>

			<tr>
				<td><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td>address</td>
			</tr>

			<tr>
				<td><textarea rows="1" cols="10" name = "address"></textarea></td>
			</tr>
			
			<tr>
				<td>contact</td>
			</tr>

			<tr>
				<td><input type="number" name="contact"></td>
			</tr>
			
			<tr>
				<td>email</td>
			</tr>

			<tr>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td><button type = "submit" name="action" value="SignUp">signup</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
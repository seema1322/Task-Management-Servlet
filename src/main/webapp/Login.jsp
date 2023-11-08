<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css">
*{
color:rgb(168, 50, 127);
}
.form fieldset{
	width: 40%;
	background-image: url("https://cdn.pixabay.com/photo/2020/01/15/20/37/sea-4768869_1280.jpg");
}

</style>
</head>
<body>
	<form class="form" action="login" method="post">
		<fieldset>
			<label>LOGIN</label><br><br>
			
			<b>User-Email</b><br>
			<input type="text" name="User_Email" placeholder="Enter your email"><br><br>
			<b>Password</b> <br>
			<input type="password" name="User_Password" placeholder="Enter password"><br><br>
			
			<input type="submit" value="LOGIN">
			
		</fieldset>
	</form>
</body>
</html>
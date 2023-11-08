<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up page</title>
</head>
<body>

<form action="signup" method="post">
<fieldset style="width: 40%;">
<label>Create Account</label><br><br>

User-Name<br>
<input type="text" name="User_Name" placeholder="Enter your name"><br><br>
User-Email<br>
<input type="text" name="User_Email" placeholder="Enter your email"><br><br>
Password <br>
<input type="password" name="User_Password" placeholder="Enter password"><br><br>
Role<br>
<input type="text" name="User_role" disabled="disabled" value="Manager"><br><br>
<input type="submit" value="Register">
</fieldset>

</form>

</body>
</html>
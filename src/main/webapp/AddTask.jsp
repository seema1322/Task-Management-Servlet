<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Details</title>
</head>
<body>

<form action="task" method="post">
<fieldset>
<legend>Assign Task</legend>
User-Email<br>
<input type="text" name="User_Email" placeholder="Enter employee email to assign task"><br><br>
Task-Description <br>
<input type="text" name="Task_Desc" placeholder="Enter task details"><br><br>

<input type="submit" value="Assign">
</fieldset>
</form>

</body>
</html>
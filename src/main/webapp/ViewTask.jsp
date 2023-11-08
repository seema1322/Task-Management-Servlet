<%@page import="java.util.stream.Collectors"%>
<%@page import="com.ty.task_management.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.task_management.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
margin-top:30px;
background-image: url("https://cdn.pixabay.com/photo/2018/03/06/17/40/paper-3204064_1280.jpg");
color:#590458;
background-position: center;
background-repeat: no-repeat;
background-size: cover;

}
h3 {
	margin-left: 30%;
}
</style>
</head>
<body>
	<h3>Task Details</h3>
	<%
	User user = (User) request.getAttribute("user");
	List<Task> tasks = user.getTask();

	tasks = (List<Task>) tasks.stream().sorted((task1, task2) -> task1.getStatus().compareTo(task2.getStatus()))
			.collect(Collectors.toList());
	%>
	<table border="1" style="margin: 0 auto; margin-top: 70px">
		<tr>
			<th>Task Id</th>
			<th>Description</th>
			<th>Created Time&Date</th>
			<th>Updated Time&Date</th>
			<th>Status</th>
			<th>Update Status</th>
		</tr>
		<%
		for (Task task : tasks) {
		%>

		<tr>

			<td><%=task.getId()%></td>
			<td><%=task.getDescription()%></td>
			<td><%=task.getCreatedDateTime()%></td>
			<td><%=task.getCompletedDateTime()%></td>
			<td><%=task.getStatus()%></td>
			<td><a
				href="updatetask?id=<%=task.getId()%>&userId=<%=user.getId()%>">Completed</a></td>

		</tr>
		<%
		}
		%>

	</table>
</body>
</html>
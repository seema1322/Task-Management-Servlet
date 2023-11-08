<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<style type="text/css">
body{
background-image: url("https://cdn.pixabay.com/photo/2017/10/10/21/47/laptop-2838921_1280.jpg");
background-position: center;
background-repeat: no-repeat;
background-size: cover;
}

</style>

</head>
<body>
<h1 style="text-align: center; color:white;">MANAGER HOME</h1>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="RegisterEmployee.jsp">On-Board an Employee<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="viewemployee">View Employees</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddTask.jsp">Assign Task</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Logout</a>
      </li>
    </ul>
  </div>
</nav>

</body>
</html>
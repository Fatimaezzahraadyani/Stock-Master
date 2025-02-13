<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>StockMaster</title>
</head>


<body>
<header>
<nav class="navbar navbar-expend-md navbar-dark" style="background-color: black">
  <div>
    <a href="https://javaguides.net" class="navbar-brand">Stock Master Application</a>
    </div>
    <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
     </ul>
     
</nav>
</header>
 
</body>
</html>
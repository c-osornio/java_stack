<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div> 
	
		<h1 class="text-center">Here's Your Omikuji!</h1>
		<div class="container row mx-auto p-5 col-3 border border-dark" style="background-color: powderblue;">
			<h2 class="text-center"><c:out value="${omikuji}"/></h2>
		</div>
		<div class="text-center">
			<a href="/">Go back</a>
		</div>
	</div>
</body>
</html>
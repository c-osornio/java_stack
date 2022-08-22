<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Visit Count</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1 class="text-center p-5">You have visited <a href="/your_server">http://your_server</a> <c:out value="${countToShow}"/> times.</h1>
	<h2 class="text-center p-2"><a href="/your_server" >Test another visit?</a></h2>
	<h2 class="text-center p-2"><a href="/your_server/resetCounter" >Reset counter?</a></h2>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Page</title>
	<link rel="stylesheet" href="style.css">
</head>

<body>

	<% for (int i=0; i < 2; i++) { %>
	<h1> Hello World</h1>
	<%} %>

	
	<h4><c:out value="${dojoName}"/></h4>
	
</body>
</html>
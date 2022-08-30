<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show ${language.name} Language!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-success">

	<div class="container row p-3 mx-auto bg-dark text-info rounded mt-5">
	
		<div class="d-flex justify-content-center gap-3">
	    	<h1 class="text-center">Language Details</h1>
	    	<a href="/languages" class="mt-2 ps-3">Go back</a>
		</div>  
		
		<table class="text-warning table mt-3 table-dark rounded">
			<tr>
				<th>Language Name:</th>
				<td class="text-info"><c:out value="${language.name}"/></td>
			</tr>
			<tr>
				<th>Language Creator:</th>
				<td class="text-info"><c:out value="${language.creator}"/></td>
			</tr>
			<tr>
				<th>Version:</th>
				<td class="text-info"><c:out value="${language.currentVersion}"/></td>
			</tr>
		</table>
	</div>
   
</body>
</html>
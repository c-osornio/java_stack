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
    <title>Show ${expense.name} Expense!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-success">

	<div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5">
	
		<div class="d-flex justify-content-center gap-3">
	    	<h1 class="text-primary text-warning text-center">Expense Details</h1>
	    	<a href="/expenses" class="mt-2 ps-3">Go back</a>
		</div>  
		
		<table class="table mt-3 table-dark text-warning rounded">
			<tr>
				<th>Expense Name:</th>
				<td class="text-success"><c:out value="${expense.name}"/></td>
			</tr>
			<tr>
				<th>Expense Description:</th>
				<td class="text-success"><c:out value="${expense.description}"/></td>
			</tr>
			<tr>
				<th>Vendor:</th>
				<td class="text-success"><c:out value="${expense.vendor}"/></td>
			</tr>
			<tr>
				<th>Amount Spent:</th>
				<td class="text-success"><c:out value="${expense.amount}"/></td>
			</tr>
		</table>
	</div>
   
</body>
</html>
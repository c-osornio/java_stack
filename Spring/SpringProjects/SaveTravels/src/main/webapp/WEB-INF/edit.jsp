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
    <title>Edit ${expense.name} Expense!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-success">
    <div class="container row p-3 mx-auto bg-dark text-warning rounded mt-5">
		<div class="d-flex justify-content-center gap-3">
	    	<h1 class="text-warning text-warning text-center">Edit ${expense.name} expense</h1>
	    	<a href="/expenses" class="mt-2 ps-3">Go back</a>
		</div>   
    	<div class="col-6 mx-auto">
			<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<div class="form-group mt-1 row">
			    <h4>
			        <form:label class="col col-form-label text-start" path="name">Expense Name:</form:label>
			        <form:errors class="text-danger fs-6" path="name"/>
			        <form:input class="form-control" type="text" path="name"/>
			    </h4>
			</div>
			<div class="form-group mt-1 row">
			    <h4>
			        <form:label class="col col-form-label" path="vendor">Vendor:</form:label>
			        <form:errors class="text-danger fs-6" path="vendor"/>
			        <form:input class="form-control" type="text" path="vendor"/>
			    </h4>
			</div>
			<div class="form-group mt-1 row">
			    <h4>
			        <form:label class="col col-form-label" path="amount">Amount: </form:label>
			        <form:errors class="text-danger fs-6" path="amount"/>
			        <form:input class="form-control" type="text" path="amount"/>
			    </h4>
			</div>
			<div class="form-group mt-1 row">
			    <h4>
			        <form:label class="col col-form-label" path="description">Description: </form:label>  
			        <form:errors class="text-danger fs-6" path="description"/>
			        <form:textarea class="form-control" path="description"/>
			    </h4>    
			</div>
		    <button class="mt-2 btn btn-warning">Submit</button>
			</form:form>    
    	</div>

    	
    </div>
</body>
</html>
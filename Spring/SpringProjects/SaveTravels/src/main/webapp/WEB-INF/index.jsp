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
    <title>SAVE TRAVELS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-success">
    <div class="container width=1000px">
	    <h1 class="text-warning mt-5 text-center" >Save Travels</h1>
	   
	    <table class="table mt-3 table-dark table-striped text-warning rounded">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><c:out value="${expense.name}"/></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>$<c:out value="${expense.amount}"/></td>
				</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
    
    
    
    <div class="container row p-3 mx-auto bg-dark text-warning rounded">
    	<h2 class="text-warning text-warning text-center">ADD EXPENSE</h2>
    	<div class="col-6 mx-auto">
			<form:form action="/expenses" method="post" modelAttribute="expense">
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
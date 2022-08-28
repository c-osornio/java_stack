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
	   
	    <table class="table mt-3 table-dark text-warning rounded">
			<thead>
				<tr>
					<th scope="col">Expense</th>
					<th scope="col">Vendor</th>
					<th scope="col">Amount</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><a href="expenses/<c:out value="${expense.id}"/>"><c:out value="${expense.name}"/></a></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>$<c:out value="${expense.amount}"/></td>
					<td class="d-flex gap-3">
						<a href="/expenses/<c:out value="${expense.id}"/>/edit">edit</a>
						<form action="/expenses/<c:out value="${expense.id}"/>/delete" method="post">
				    		<input type="hidden" name="_method" value="delete">
				    		<button class="mt-2 btn btn-danger">Delete</button>
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
	    </table>
    </div>
    
    
    
    <div class="container row p-3 mx-auto bg-dark text-primary rounded">
    	<h2 class="text-center">ADD EXPENSE</h2>
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
		    <button class="mt-2 btn btn-primary">Submit</button>
			</form:form>    
    	</div>

    	
    </div>
    
</body>
</html>
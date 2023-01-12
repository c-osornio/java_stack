<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Listing</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&display=swap" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
		<div>
			<h1 class="fw-bold text-white title">Add a new Listing!</h1>
		</div>
		<div class="d-flex justify-content-end">
	            <a href="/dashboard">Back to Dashboard</a>
		</div>

	</div>
	<div class="container row">
        <div class="col-6 mx-auto">
            <form:form action="/listings/new" method="post" modelAttribute="listing">
                <div class="form-group mt-1 row ">
                        <form:label class="col col-form-label text-start fs-3 text-white ps-3" path="address">Address: </form:label>
                        <form:errors class="text-danger fs-6" path="address" />
                        <div class="ps-3">
	                        <form:input class="form-control" path="address" />
                        </div>
                </div>
                <div class="form-group mt-1 row">
            	    <form:label class="col col-form-label fs-3 text-white" path="price">Price: </form:label>
	                <form:errors class="text-danger fs-6" path="price" />
	                <div class="input-group mb-2">
      					<div class="input-group-prepend">
        					<div class="input-group-text">$</div>
      					</div>
                      	<form:input class="form-control" path="price" type="number" min="1"/>
                	</div>
                </div>
                <div>
                	<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd" var="formattedDate"/>
                	<form:input type="hidden" path="listingDate" value="${formattedDate}"/>
                </div>
				<div class="d-flex justify-content-end gap-4">
	                <button class="mt-2 btn btn-primary">Submit</button>
				</div>
	        </form:form>
        </div>
    </div>
	
</body>
</html>
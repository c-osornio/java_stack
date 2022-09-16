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
    <title>Edit Listing</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
		<div>
			<h1 class="fw-bold text-white">Edit Listing!</h1>
		</div>
		<div class="d-flex justify-content-end">
	            <a href="/dashboard">dashboard</a>
		</div>

	</div>
	<div class="container row text-white">
        <div class="col-6 mx-auto">
            <form:form action="/listings/${listing.id}/edit" method="post" modelAttribute="listing">
            	<input type="hidden" name="_method" value="put">
                <div class="form-group mt-1 row">
                        <form:label class="col col-form-label" path="address"><h4 class="ps-1">Address: </h4></form:label>
                        <form:errors class="text-danger fs-6" path="address" />
                        <div class="ps-3">
	                        <form:input class="form-control" path="address" />
                        </div>
                </div>
                <div class="form-group mt-1 row input-group">
                        <form:label class="col col-form-label" path="price"><h4>Price: </h4></form:label>
                        <form:errors class="text-danger fs-6" path="price" />
                        <div class="input-group mb-2">
        					<div class="input-group-prepend">
          						<div class="input-group-text">$</div>
        					</div>
                        	<form:input class="form-control" path="price" type="number" min="1"/>
                        </div>
                </div>
                <div>
                        <form:label class="col col-form-label" path="listingDate"><h4>Listing Date: </h4></form:label>
                        <form:errors class="text-danger fs-6" path="listingDate" />
                        <form:input class="form-control" path="listingDate" type="date" pattern="yyyy-mm-dd"/>
                </div>
                
                
				<div class="d-flex justify-content-end gap-4">
	                <button class="mt-3 btn btn-primary">Submit</button>
	                <a href="/listings/${listing.id}/delete"><button class="mt-3 btn btn-danger">delete</button></a>
				</div>
	     	</form:form>

		</div>
	</div>

</body>
</html>
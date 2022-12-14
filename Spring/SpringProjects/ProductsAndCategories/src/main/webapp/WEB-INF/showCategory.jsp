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
    <title>Category Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 class="mt-5 text-center"><c:out value="${category.name}"/></h1>
	</div>
	
	<div class="container">
		<a href="/">Home</a>
		<hr>
	</div>
	
	<div class="container width=1000">
		<h2>Products: </h2>
			<ul>
				<c:forEach var="product" items="${assignedProducts}">
					<li>
						<c:out value="${product.name}"/>
					</li>
				</c:forEach>
			</ul>
		<hr>
	</div>

	<div class="container">
		<form action="/categories/${id}" method="post">
		<h2>Add Product:</h2>
		<select name="productId" class="mt-2 form-control">
			<c:forEach var="product" items="${unassignedProducts}">
				<option value="${product.id}">${product.name}</option>
			</c:forEach>
		</select>
		<button class="btn btn-success btn-lg btn-block w-100 mt-3">Add</button>
		</form>
	</div>

</body>
</html>
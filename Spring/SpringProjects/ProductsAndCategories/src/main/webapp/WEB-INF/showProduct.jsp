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
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 class="mt-5 text-center"><c:out value="${product.name}"/></h1>
	</div>
	
	<div class="container">
		<a href="/">Home</a>
		<hr>
	</div>
	
	<div class="container width=1000">
		<h2>Categories: </h2>
			<ul>
				<c:forEach var="category" items="${categorized}">
					<li>
						<c:out value="${category.name}"/>
					</li>
				</c:forEach>
			</ul>
		<hr>
	</div>

	<div class="container">
		<form action="/products/${id}" method="post">
		<h2>Add Category:</h2>
		<select name="categoryId" id="categoryId" class="mt-2 input form-control">
			<c:forEach var="category" items="${uncategorized}">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
		<button class="btn btn-success btn-lg btn-block w-100 mt-3">Add</button>
		</form>
	</div>

</body>
</html>
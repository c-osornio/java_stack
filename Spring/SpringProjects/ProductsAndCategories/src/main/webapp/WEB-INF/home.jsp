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
    <title>Products and Categories</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 class="mt-5 text-center">Home Page</h1>
	</div>
	
	<div class="container">
		<a href="products/new" target="_blank">New Product</a>
		<br>
		<a href="categories/new" target="_blank">New Category</a>
		<hr>
	</div>
	
	<div class="container">
		<table class="table table-bordered border-dark">
  			<thead>
    			<tr>
			   		<th class="text-center fs-3" scope="col">Products</th>
				  	<th class="text-center fs-3" scope="col">Categories</th>
			    </tr>
		  	</thead>
  			<tbody>
				<tr> 
					<td>
						<ul>
							<c:forEach var="product" items="${products}">
								<li class="fs-4">
									<a target="_blank" href="/products/<c:out  value="${product.id}"/>"><c:out  value="${product.name}"/></a>
								</li>
							</c:forEach>
						</ul>
					</td>
					<td> 
						<ul>
							<c:forEach var="category" items="${categories}">
								<li class="fs-4">
									<a target="_blank" href="/categories/<c:out  value="${category.id}"/>"><c:out  value="${category.name}"/></a>
								</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
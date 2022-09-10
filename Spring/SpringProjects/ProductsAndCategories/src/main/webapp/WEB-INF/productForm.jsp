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
    <title>New Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 class="mt-5 text-center">New Product</h1>
	</div>
	
	<div class="container">
		<a href="/">Home</a>
		<hr>
	</div>
	
	<div class="container width=1000">
		<form:form action="/products/new" method="post" modelAttribute="product">
			<table class="table table-bordered border-dark rounded">
				<thead>
					<tr>
						<td>
							<form:label class="col col-form-label fs-3" path="name">Name: </form:label>
						</td>
						<td class="align-middle">
							<form:errors class="text-danger fs-6" path="name" />
	                    	<form:input class="form-control" path="name" />	
						</td>
					</tr>
					<tr>
						<td>
							<form:label class="col col-form-label fs-3" path="description">Description: </form:label>
						</td>
						<td class="align-middle">
							<form:errors class="text-danger fs-6" path="description" />
	                    	<form:input class="form-control" path="description" />	
						</td>
					</tr>
					<tr>
						<td>
							<form:label class="col col-form-label fs-3" path="price">Price: </form:label>
						</td>
						<td class="form-group align-middle">
							<div class="input-group">
	   							<span class="input-group-text">$</span>
		                    	<form:errors class="text-danger fs-6" path="price" />
		                    	<form:input class="form-control" path="price" type="number" min="0.00" step=".01" value="0.00" />
							</div>
						</td>
					</tr>
					<tr class="align-middle">
						<td colspan="2">
							<button class="btn btn-success btn-lg btn-block w-100">Submit</button>
						</td>
					</tr>
				</thead>
			</table>
		</form:form>
	</div>

</body>
</html>

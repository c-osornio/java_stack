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
    <title>New Category</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1 class="mt-5 text-center">New Category</h1>
	</div>
	
	<div class="container">
		<a href="/">Home</a>
		<hr>
	</div>
	
	<div class="container width=1000">
		<form:form action="/categories/new" method="post" modelAttribute="category">
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
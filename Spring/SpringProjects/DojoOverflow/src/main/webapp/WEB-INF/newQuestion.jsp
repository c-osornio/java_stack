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
    <title>New Question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5 fs-1">
		<h1>What is your question?</h1>
	</div>
	<div class="container">
		<form:form action="/questions/new" method="post" modelAttribute="question">
			<div class="form-group mt-1 row">
				<form:label class="col col-form-label fs-4" path="text">Question: </form:label>
				<h2 class="text-danger fs-6"><c:out value="${questionErrors}"/></h2>
				<form:errors path="text" class="fs-6 text-danger"/>
				<form:textarea class="form-control ms-3" path="text" rows="4"/>
			</div>

				<label class="fs-4">Tags: </label>
				<h2 class="text-danger fs-6"><c:out value="${tagErrors}"/></h2>
				<input class="form-control" name="ListOfTags" id="ListOfTags" value="${modelTags}">
			</div> 
			<div class="container d-flex justify-content-end">
				<button class="btn btn-success mt-3">Submit</button>
			</div>
		 </form:form>
	</div>

</body>
</html>
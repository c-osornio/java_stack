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
    <title><c:out value="${book.title}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between mt-5">
		<div>
			<h1 class="fw-bold fst-italic">"<c:out value="${book.title}"/>"</h1>
		</div>
		<div>
			<a class="fs-6" href="/books">Back to the shelves</a>
		</div>
	</div>
	<div class="container">
		<div>
			<h2 class="mb-5 fs-2">
				<span class="text-danger"><c:out value="${book.user.username}"/></span> read <span class="welcome"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span>
			</h2>
			<h2>Here are <c:out value="${book.user.username}"/>'s thoughts</h2>
		</div>
		<div>
			<hr>
			<p><c:out value="${book.thoughts}"/></p>
			<hr>
		</div>
		<div class="d-flex gap-2">
			<c:if test="${book.user.id == user.id}">
				<a href="/books/${book.id}/edit"><button class="btn-warning text-white">edit</button></a>
				<form action="/books/${book.id}/delete" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<button class="btn-danger">delete</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>
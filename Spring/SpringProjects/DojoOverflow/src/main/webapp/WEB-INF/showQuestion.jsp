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
    <title>Question Profile</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5 fs-1">
		<h1><c:out value="${question.text}"/></h1>
	</div>
	<div class="container">
		<h2 class="fs-3 mt-4">Tags: 
			<c:forEach var="tag" items="${question.tags}">
				<span class="border ps-2 pe-2 border-dark box ms-3"><c:out value="${tag.subject}"/></span>
			</c:forEach>
		</h2>
	</div>
	<div class="container mt-4">
		<div class="container row">
			<div class="col">
				<table class="table table-border border-dark mt-4">
					<thead class="table-active">
						<tr>
							<th scope="col">Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="answer" items="${question.answers}">
						<tr>
							<td><c:out value="${answer.text}"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<h3>Add your answer:</h3>
				<form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
					<table>
						<thead>
							<tr>
								<td class="fs-4 mt-4">Answer: </td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<form:errors class="fs-6 text-danger" path="text"/>
									<form:textarea class="form-control" path="text" rows="4" cols="50"/>
								</td>
							</tr>
							<tr>
								<td>
									<div class="d-flex justify-content-end mt-2">
										<button class="btn btn-success">Answer it!</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
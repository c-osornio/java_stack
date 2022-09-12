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
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">Questions Dashboard</h1>
		
		<table class="table table-bordered border-dark mt-3">
			<thead class="thead-dark">
				<tr class="text-center">
					<th scope="col">Question</th>
					<th scope="col">Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="question" items="${questions}">
					<tr>
						<td>
							<a href="/questions/<c:out value="${question.id}"/>">
								<c:out value="${question.text}"/>
							</a>
						</td>
						<td>
							<c:forEach var="tag" items="${question.tags}">
								<c:out value="${tag.subject}"/>							
								<c:if test="${question.tags.indexOf(tag) < question.tags.size() -1 }">
									, 
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container d-flex justify-content-end">
		<a href="/questions/new">New Question</a>
	</div>

</body>
</html>
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
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between  mt-5">
		<div>
			<h1 class="welcome fw-bold">Welcome, <c:out value="${user.username}"/>!</h1>
			<h2 class="mb-5 fs-6">Books from everyone's shelves:</h2>
		</div>
		<div>
			<a class="fs-6" href="/logout">logout</a>
			<br>
			<a class="fs-6" href="/books/new">+Add Book to shelf!</a>
			<br>
			<a class="fs-6" href="/books/bookmarket">Check out the Book Market!</a>
		</div>
	</div>
	<div class="container">
		<table class="table mt-3 table-striped-columns">
            <thead class="table-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                    	<td>
                            <c:out value="${book.id}" />
                        </td>
                        <td><a  class="text-warning" href="books/<c:out value="${book.id}"/>">
                            <c:out value="${book.title}" /></a>
                        </td>
                        <td>
                            <c:out value="${book.author}" />
                        </td>
                        <td>
                            <c:out value="${book.user.username}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		
	</div>
</body>
</html>
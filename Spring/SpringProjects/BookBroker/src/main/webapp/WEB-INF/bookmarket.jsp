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
    <title>Book Market</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between  mt-5">
		<div>
			<h1 class="fw-bold fs-5">Hello, <c:out value="${user.username}"/>! Welcome to..</h1>
			<h2 class="mb-5 fs-1 welcome">The Book Broker!</h2>
		</div>
		
		<div>
			<a class="fs-6" href="/logout">logout</a>
			<br>
			<a class="fs-6" href="/books/new">+Add Book to shelf!</a>
			<br>
			<a class="fs-6" href="/books">Back to the shelves</a>
		</div>
	</div>
	<div class="container">
		<div>
			<h3 class="fs-5">Available Books to Borrow</h3>
			<table class="table mt-3 table-striped-columns">
	            <thead class="table-dark">
	                <tr>
	                    <th scope="col">ID</th>
	                    <th scope="col">Title</th>
	                    <th scope="col">Author Name</th>
	                    <th scope="col">Owner</th>
	                    <th scope="col">Actions</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="availableBook" items="${availableBooks}">
	                    <tr>
	                    	<td>
	                            <c:out value="${availableBook.id}" />
	                        </td>
	                        <td><a  class="text-warning" href="/books/<c:out value="${availableBook.id}"/>">
	                            <c:out value="${availableBook.title}" /></a>
	                        </td>
	                        <td>
	                            <c:out value="${availableBook.author}" />
	                        </td>
	                        <td>
	                            <c:out value="${availableBook.user.username}" />
	                        </td>
	                        <td class="d-flex gap-2">
	                        	<c:if test="${availableBook.user.id == user.id}">
									<a href="/books/${availableBook.id}/edit">
										<button class="btn btn-warning text-white">edit</button>
									</a>
									<form action="/books/${availableBook.id}/delete" method="post">
    									<input type="hidden" name="_method" value="delete">
    									<button class="btn btn-danger">delete</button>
									</form>
								</c:if>
								<c:if test="${availableBook.user.id != user.id}">
									<a href="/books/bookmarket/${availableBook.id}/borrow">
										<button class="btn btn-success text-white">borrow</button>
									</a>
								</c:if>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
		</div>
		
		<div>
			<h3 class="fs-5">Books I'm Borrowing..</h3>
			<table class="table mt-3 table-striped-columns">
	            <thead class="table-dark">
	                <tr>
	                    <th scope="col">ID</th>
	                    <th scope="col">Title</th>
	                    <th scope="col">Author Name</th>
	                    <th scope="col">Owner</th>
	                    <th scope="col">Actions</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach var="book" items="${borrowedBooks}">
	                    <tr>
	                    	<td>
	                            <c:out value="${book.id}" />
	                        </td>
	                        <td><a  class="text-warning" href="/books/<c:out value="${book.id}"/>">
	                            <c:out value="${book.title}" /></a>
	                        </td>
	                        <td>
	                            <c:out value="${book.author}" />
	                        </td>
	                        <td>
	                            <c:out value="${book.user.username}" />
	                        </td>
	                        <td>
	                        	<a href="/books/bookmarket/${book.id}/return">	
	                            	<button class="btn btn-info text-white">return</button>
	                            </a>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
		</div>
		
	</div>
</body>
</html>
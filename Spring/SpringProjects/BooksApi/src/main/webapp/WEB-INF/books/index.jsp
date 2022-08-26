<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books API</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  
	<h1>All Books</h1>
	<table class="table">
	    <thead>
	        <tr>
	            <th scope="col">ID</th>
	            <th scope="col">Title</th>
	            <th scope="col">Language</th>
	            <th scope="col">Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="book" items="${books}">
	    	<tr>
	        	<th scope="row"><c:out value="${book.id}"/></th>
	        	<td><a href="/books/<c:out value="${book.id}"/>"><c:out value="${book.title}"/></a></td>
	        	<td><c:out value="${book.language}"/></td>
	        	<td><c:out value="${book.numberOfPages}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
   
</body>
</html>
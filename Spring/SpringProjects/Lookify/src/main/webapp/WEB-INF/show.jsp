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
    <title>Show ${song.title} Song!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:lime;">

	
	
	<nav class="d-flex justify-content-around bg-dark">
        <h1 class="text-primary">Lookify</h1>

        <div class="d-flex justify-content-around gap-4">
	        <a href="/dashboard" class="mt-2 ps-3">Dashboard</a>
        </div>
    </nav> 
	
	<div class="container row p-3 mx-auto bg-dark text-info rounded mt-5">
		<table class="text-warning table mt-3 table-dark rounded">
			<tr>
				<th>Title:</th>
				<td class="text-info"><c:out value="${song.title}"/></td>
			</tr>
			<tr>
				<th>Artist:</th>
				<td class="text-info"><c:out value="${song.artist}"/></td>
			</tr>
			<tr>
				<th>Rating (1-10):</th>
				<td class="text-info"><c:out value="${song.rating}"/></td>
			</tr>
		</table>
		<form action="/songs/<c:out value=" ${song.id}" />/delete" method="post">
	        <input type="hidden" name="_method" value="delete">
	        <button class="mt-2 btn btn-danger">Delete</button>
        </form>
	</div>
   
</body>
</html>
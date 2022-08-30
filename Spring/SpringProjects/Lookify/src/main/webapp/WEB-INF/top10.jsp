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
    <title>Top 10 Songs!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">     
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:lime;">

	
	
	<nav class="d-flex justify-content-around bg-dark">
        <h1 class="text-primary">Lookify - TOP 10 Songs:</h1>

        <div class="d-flex justify-content-around gap-4">
	        <a href="/dashboard" class="mt-2 ps-3">Dashboard</a>
        </div>
    </nav> 
	
	<div class="container row p-3 mx-auto bg-dark text-info rounded mt-5">
		<table class="table mt-3 table-dark text-warning rounded">
            <thead>
                <tr>
                    <th scope="col">Rating</th>
                    <th scope="col">Title</th>
                    <th scope="col">Artist</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${songs}">
                    <tr>
                        <td>
                            <c:out value="${song.rating}" />
                        </td>
                        <td><a  class="text-warning" href="songs/<c:out value="${song.id}" />">
                            <c:out value="${song.title}" /></a>
                        </td>
                        <td class="d-flex gap-3">
                            <c:out value="${song.artist}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
   
</body>
</html>
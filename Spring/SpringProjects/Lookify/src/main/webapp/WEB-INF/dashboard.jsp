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
    <title>Song Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:lime;">
	<nav class="d-flex justify-content-around bg-dark">
        <h1 class="text-primary">Lookify</h1>

        <div class="d-flex justify-content-between gap-4">
	        <a href="/songs/new" class="mt-2 ps-3">Add New</a>
			<a href="/search/topTen" class="mt-2 ps-3">Top Songs</a>
            <form action="/dashboard" method="post">
            	<input type="text" id="artist" name="artist" class="mt-2 ps-3 rounded">
            	<button class="btn btn-success">Search Artists</button>
            </form>
        </div>
    </nav>
    
	<div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5 ">
    	<div>	
        	<h1 class="text-warning mt-1 text-center">Songs</h1>
        </div> 

        <table class="table mt-3 table-dark text-warning rounded">
            <thead>
                <tr>
                    <th scope="col">Title</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${songs}">
                    <tr>
                        <td><a  class="text-warning" href="songs/<c:out value="${song.id}" />">
                            <c:out value="${song.title}" /></a>
                        </td>
                        <td>
                            <c:out value="${song.rating}" />
                        </td>
                        <td class="d-flex gap-3">
                            <form action="/songs/<c:out value=" ${song.id}" />/delete"
                            method="post">
                            <input type="hidden" name="_method" value="delete">
                            <button class="mt-2 btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	

</body>
</html>
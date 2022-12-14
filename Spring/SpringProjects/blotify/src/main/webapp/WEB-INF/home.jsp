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
    <title>Blotify</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1>Welcome <c:out value="${user.username}"/>!</h1>
		
		<h2 class="fs-5">My Playlists: </h2>
		<ul>
			<c:forEach var="playlist" items="${user.playlists}">
				<li>
					<c:out value="${playlist.name}"/>
				</li>
			</c:forEach>
		</ul>
		
		<a href="/playlist/create"><button class="btn btn-success">New Playlist</button></a>
		<a href="/logout"><button class="btn btn-danger">Logout</button></a>
	</div>
</body>
</html>

</body>
</html>
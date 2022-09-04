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
    <title>Muffins</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <h1>All Muffins</h1>
    <a href="/muffin/new">Add a new muffin!</a>
    <ul>
        <c:forEach var="muffin" items="${muffins}">
            <li>
                <a href="/muffin/${muffin.id}/edit"><c:out value="${muffin.name}"/> by <c:out value="${muffin.chef.name}"/></a>
                <form action="/muffin/${muffin.id}/delete" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <button>Delete</button>
				</form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
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
    <title><c:out value="${dojo.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1><c:out value ="${dojo.name}"/> Location Ninjas</h1>
	<table class="table mt-3 table-dark text-warning rounded">
	    <thead>
	        <tr>
	            <th scope="col">First Name</th>
	            <th scope="col">Last Name</th>
	            <th scope="col">Age</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="ninja" items="${dojo.ninjas}">
	            <tr>
	                <td>
	                    <c:out value="${ninja.first_name}" />
	                </td>
	                <td>
	                    <c:out value="${ninja.last_name}" />
	                </td>
	                <td>
	                    <c:out value="${ninja.age}" />
	                </td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>

</body>
</html>

</body>
</html>
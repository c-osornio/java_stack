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
    <title>All Classes</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-primary">
    <div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5">
    	<div>	
        	<h1 class="text-warning mt-1 text-center">All Classes</h1>
        </div> 
        
        <div>
        	<a href="/dorms">Dashboard</a>
        </div>

        <table class="table mt-3 table-dark text-warning rounded text-center">
            <thead>
                <tr>
                    <th scope="col">Class</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${classes}">
                    <tr>
                        <td>
                            <a href="/classes/<c:out value="${subject.id}" />"><c:out value="${subject.name}"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>
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
    <title>Dorms</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-primary">
    <div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5">
    	<div>	
        	<h1 class="text-warning mt-1 text-center">Dorms</h1>
        </div> 
        
        <div>
        	<a href="/dorms/new">Add a new Dorm!</a>
        	<br>
        	<a href="/students/new">Add a new Student!</a>
        	<br>
        	<a href="/classes/new">Add a new class!</a>
        	<br>
        	<a href="/classes">View all classes!</a>
        </div>

        <table class="table mt-3 table-dark text-warning rounded">
            <thead>
                <tr>
                    <th scope="col">Dorm Name</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dorm" items="${dorms}">
                    <tr>
                        <td>
                            <c:out value="${dorm.name}" />
                        </td>
                        <td class="d-flex gap-3">
                            <a href="/dorms/<c:out value=" ${dorm.id}" />">See Students</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>
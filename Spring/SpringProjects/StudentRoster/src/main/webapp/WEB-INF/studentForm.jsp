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
    <title>New Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-primary">
    <div class="container row p-3 mx-auto bg-dark text-info rounded mt-5">
        <h2 class="text-center">New Student</h2>
        
        <div>
        	<a href="/dorms/">Dashboard</a>
        </div>
        
        <div class="col-6 mx-auto">
            <form:form action="/students/new" method="post" modelAttribute="student">
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="name">Name:
                        </form:label>
                        <form:errors class="text-danger fs-6" path="name" />
                        <form:input class="form-control" path="name" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                	<h4>
                		<form:label class="col col-form-label text-start" path="dorm">Dorm:
                        </form:label>
                        <form:select path="dorm">
                        	<c:forEach var="dorm" items="${dorms}">
                        		<option value="${dorm.id}"><c:out value="${dorm.name}"/></option> 
                        	</c:forEach>
                        </form:select>
                	</h4>
                </div>
                <button class="mt-2 btn btn-info">Add</button>
            </form:form>
        </div>
	</div>

</body>
</html>
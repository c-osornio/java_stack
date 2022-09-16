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
    <title>Project Details</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
			<h1 class="fw-bold welcome">Project Details</h1>
			<a href="/dashboard">Back to Dashboard</a>
	</div>
	<div class="container">
        <table class="table mt-3 text-white">
        	<tbody>
        		<tr>
        			<td> Project:
        			</td>
        			<td><c:out value="${project.title}"/>
        			</td>
        		</tr>
        		<tr>
        			<td> Description:
        			</td>
        			<td><c:out value="${project.description}"/>
        			</td>
        		</tr>
        		<tr>
        			<td> Due Date:
        			</td>
        			<td>
        				<fmt:formatDate type="date" value="${project.dueDate}" pattern="MM/dd/yyyy" var="formattedDueDate"/>
        				<c:out value="${formattedDueDate}"/>
        			</td>
        		</tr>
        	</tbody>
        </table>
    </div>
    <div class="container d-flex justify-content-center">
		<a href="/projects/<c:out value="${project.id}"/>/tasks">See tasks!</a>
    </div>
    <div class="container d-flex justify-content-end">
    	<form action="/projects/${project.id}/delete" method="post">
   				<input type="hidden" name="_method" value="delete">
   				<button class="mt-3 btn btn-danger">DELETE PROJECT</button>
		</form>
    </div>
	
</body>
</html>
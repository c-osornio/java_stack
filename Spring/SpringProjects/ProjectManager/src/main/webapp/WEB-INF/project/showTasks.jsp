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
    <title>Project Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
			<h1 class="fw-bold welcome">Project: <c:out value="${project.title}"/></h1>
			<a href="/dashboard">Back to Dashboard</a>
	</div>
	<div class="container">
		<h2 class="fs-5">Project Lead: <c:out value="${project.teamLead}"/></h2>
        
     	<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
     		<div>
     			<h3 class="fs-3 mt-4">Add a task ticket for this team:</h3>
     		</div>
     		<div class="form-group">
     			<form:errors class="text-danger fs-6" path="ticket"/>
     			<form:textarea  class="form-control" path="ticket" rows="4"/>
     		</div>
			<div class="form-group d-flex justify-content-end">
 				<button class="mt-2 btn btn-primary">Submit</button>
			</div>
     	</form:form>
        
    </div>
    <div class="container mt-4">
		<c:forEach var="task" items="${tasks}">
			<h4 class="fs-5 mt-3">Added by <c:out value="${task.creator}"/> at <fmt:formatDate value="${task.createdAt}" pattern="h:mm a MMMM dd"/>:</h4>
			<p><c:out value="${task.ticket}"/></p>

			<form action="/projects/${project.id}/${task.id}/delete" method="post">
   				<input type="hidden" name="_method" value="delete">
   				<button class="btn btn-success">Clear Task</button>
			</form>

		</c:forEach>
    </div>

	
</body>
</html>
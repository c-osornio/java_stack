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
    <title>Edit Project</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
		<div>
			<h1 class="fw-bold welcome">Edit Project!</h1>
		</div>

	</div>
	<div class="container row">
        <div class="col-6 mx-auto">
            <form:form action="/projects/${project.id}/edit" method="post" modelAttribute="project">
            	<input type="hidden" name="_method" value="put"/>
            
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="title">Project Title: </form:label>
                        <form:errors class="text-danger fs-6" path="title" />
                        <form:input class="form-control" path="title" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="description">Project Description: </form:label>
                        <form:errors class="text-danger fs-6" path="description" />
                        <form:textarea class="form-control" path="description" rows = "5" cols = "30"/>
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="dueDate">Due Date: </form:label>
                        <form:errors class="text-danger fs-6" path="dueDate" />
                        <form:input class="form-control" path="dueDate" type="date" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
					<form:input type="hidden" path="teamLead" value="${project.teamLead}"/>
				</div>

				<div class="d-flex justify-content-end gap-4">
	                <button class="mt-2 btn btn-primary">Submit</button>
				</div>
            </form:form>
            <div class="d-flex justify-content-end gap-4">
	            <a href="/dashboard"><button class="mt-2 btn btn-warning">Cancel</button></a>
			</div>
            
            
            
        </div>
    </div>
	
</body>
</html>
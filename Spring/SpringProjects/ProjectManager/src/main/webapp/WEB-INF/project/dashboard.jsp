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
    <title>Project Manager Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
<div class="container d-flex justify-content-start gap-5 mt-5">
	<h1 class="fw-bold fs-2 text-white">Welcome, <c:out value="${user.firstName}"/>!</h1>
</div>
<div class="container d-flex justify-content-end">
	<a href="/logout">log out</a>
</div>
<div class="container d-flex justify-content-between mt-5">
	<h2 class="fs-5">All Projects</h2>
	<a href="/projects/new">+ new project</a>
</div>
<div class="container">
	<div>
		<table class="table mt-3">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Project</th>
                    <th scope="col">Team Lead</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="availableProject" items="${availableProjects}">
                    <tr>
                        <td><a  class="text-warning" href="/projects/<c:out value="${availableProject.id}"/>">
                            <c:out value="${availableProject.title}" /></a>
                        </td>
                        <td>
                            <c:out value="${availableProject.teamLead}" />
                        </td>
                        <td>
                        	<fmt:formatDate type="date" value="${availableProject.dueDate}" pattern="MMM dd" var="formattedDueDate"/>
                            <c:out value="${formattedDueDate}"/>
                        </td>
                        <td>
                        	<a href="/projects/${availableProject.id}/join">	
                            	<button class="btn btn-danger text-white">Join Team</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
	
	<div>
		<h3 class="fs-5">Your Projects</h3>
		<table class="table mt-3">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Project</th>
                    <th scope="col">Team Lead</th>
                    <th scope="col">Due Date</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="project" items="${myProjects}">
                    <tr>
                        <td><a  class="text-warning" href="/projects/<c:out value="${project.id}"/>">
                            <c:out value="${project.title}" /></a>
                        </td>
                        <td>
                            <c:out value="${project.teamLead}" />
                        </td>
                        <td>
                        	<fmt:formatDate type="date" value="${project.dueDate}" pattern="MMM dd" var="formattedProjectDueDate"/>
                            <c:out value="${formattedProjectDueDate}" />
                        </td>
                        <td>
                        	<c:if test="${project.teamLead == user.firstName}">
								<a href="/projects/${project.id}/edit">
									<button class="btn btn-warning text-white">edit</button>
								</a>
							</c:if>
							<c:if test="${project.teamLead != user.firstName}">
								<a href="/projects/${project.id}/leave">
									<button class="btn btn-success text-white">Leave Team</button>
								</a>
							</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
</div>
</body>
</html>
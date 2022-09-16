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
    <title>House Hunter</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container">
		<h1 class="mt-5 fw-bold text-center text-primary">Welcome, House Hunter!</h1>
		<h2 class="mb-5 fs-6 text-center">Java Belt Exam.</h2>
	</div>
	<div class="container row mx-auto gap-5 ">
		<div class="col">
			<form:form action="/register" method="post" modelAttribute="newUser">
				<h2 class="fw-bold">Register</h2>
				<div class="form-group">
					<form:label path="username">Username: </form:label>
					<form:input class="form-control" path="username"/>
					<form:errors class="text-danger" path="username"/>
				</div>
				<div class="form-group">
					<form:label path="email">Email: </form:label>
					<form:input class="form-control" path="email"/>
					<form:errors class="text-danger" path="email"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:input class="form-control" path="password" type="password"/>
					<form:errors class="text-danger" path="password"/>
				</div>
				<div class="form-group">
					<form:label path="confirmPW">Confirm Password: </form:label>
					<form:input class="form-control" path="confirmPW" type="password"/>
					<form:errors class="text-danger" path="confirmPW"/>
				</div>
				<div class="form-group">
                    <form:label path="terms" class="mt-2">Accept Terms & Conditions</form:label>
                    <form:checkbox path="terms" required="true"/>
                    <form:errors class="text-danger" path="terms"/>
                </div>
				<div class="d-flex justify-content-end">
					<button class="btn btn-success mt-2">Submit</button>
				</div>
			</form:form>
		</div>
		<div class="col">
			<form:form action="/login" method="post" modelAttribute="newLogin" class="ms-5">
				<h2 class="fw-bold text-center">Log In</h2>
				<div class="form-group">
					<form:label path="email">Email: </form:label>
					<form:input class="form-control" path="email"/>
					<form:errors class="text-danger" path="email"/>
				</div>
				<div class="form-group">
					<form:label path="password">Password: </form:label>
					<form:input class="form-control" path="password" type="password"/>
					<form:errors class="text-danger" path="password"/>
				</div>
				<div class="d-flex justify-content-end">
					<button class="btn btn-primary mt-2">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
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
    <title>Login & Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="welcome mt-5 fw-bold">Welcome!</h1>
		<h2 class="mb-5 fs-6">Join our growing community.</h2>
		<div class="row gap-5">
			<form:form action="/register" method="post" modelAttribute="newUser" class="col-4">
				<h2 class="fw-bold">Register</h2>
				<div>
					<form:label path="username">User Name: </form:label>
					<form:input class="form-control" path="username"/>
					<form:errors class="text-danger" path="username"/>
				</div>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input class="form-control" path="email"/>
					<form:errors class="text-danger" path="email"/>
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input class="form-control" path="password" />
					<form:errors class="text-danger" path="password"/>
				</div>
				<div>
					<form:label path="confirmPW">Confirm Password: </form:label>
					<form:input class="form-control" path="confirmPW"/>
					<form:errors class="text-danger" path="confirmPW"/>
				</div>
				<div>
                    <form:label path="terms" class="mt-2">Accept Terms & Conditions</form:label>
                    <form:checkbox path="terms" required="true"/>
                    <form:errors class="text-danger" path="terms"/>
                </div>
				
				<button class="btn btn-success mt-2">Submit</button>
			</form:form>
			<form:form action="/login" method="post" modelAttribute="newLogin" class="col-3 ms-5">
				<h2 class="fw-bold">Log In</h2>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input class="form-control" path="email"/>
					<form:errors class="text-danger" path="email"/>
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input class="form-control" path="password" type="password"/>
					<form:errors class="text-danger" path="password"/>
				</div>
				<button class="btn btn-success mt-2">Submit</button>
			</form:form>
		</div> 
	</div>
</body>
</html>
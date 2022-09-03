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
    <title>Blotify</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Welcome to Blotify!</h1>
		<div class="row">
			<form:form action="/register" method="post" modelAttribute="newUser" class="col-sm">
				<h2>Register Here!</h2>
				<div>
					<form:label path="username">Username: </form:label>
					<form:input path="username"/>
					<form:errors path="username"/>
				</div>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input path="email"/>
					<form:errors path="email"/>
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password"/>
					<form:errors path="password"/>
				</div>
				<div>
					<form:label path="confirmPW">Confirm Password: </form:label>
					<form:input path="confirmPW" type="password"/>
					<form:errors path="confirmPW"/>
				</div>
				<button>Register!</button>
			</form:form>
			<form:form action="/login" method="post" modelAttribute="loginUser" class="col-sm">
				<h2>Log In here!</h2>
				<div>
					<form:label path="email">Email: </form:label>
					<form:input path="email"/>
					<form:errors path="email"/>
				</div>
				<div>
					<form:label path="password">Password: </form:label>
					<form:input path="password" type="password"/>
					<form:errors path="password"/>
				</div>
				<button>Log In</button>
			</form:form>
		</div> 
	</div>

</body>
</html>
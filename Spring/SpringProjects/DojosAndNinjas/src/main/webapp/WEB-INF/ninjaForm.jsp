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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja" class="col-sm">
			<h1>NEW NINJA</h1>
			<div>
				<form:label path="dojo">Dojo: </form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<option value="${dojo.id}"><c:out value="${dojo.name}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label path="first_name">First Name: </form:label>
				<form:input path="first_name"/>
			</div>
			<div>
				<form:label path="last_name">Last Name: </form:label>
				<form:input path="last_name"/>
			</div>
			<div>
				<form:label path="age">Age: </form:label>
				<form:input path="age" type="number"/>
			</div>
			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>

</body>
</html>
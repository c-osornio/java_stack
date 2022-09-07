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
    <title>Edit <c:out value="${book.title}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-between mt-5">
		<div>
			<h1 class="fw-bold welcome">Change your Entry!</h1>
		</div>
		<div>
			<a class="fs-6" href="/books">Back to the shelves</a>
		</div>
	</div>
	<div class="container row">
        <div class="col-6 mx-auto">
            <form:form action="/books/${book.id}" method="post" modelAttribute="book">
                <input type="hidden" name="_method" value="put"/>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="title">Title: </form:label>
                        <form:errors class="text-danger fs-6" path="title" />
                        <form:input class="form-control" path="title" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="author">Author: </form:label>
                        <form:errors class="text-danger fs-6" path="author" />
                        <form:input class="form-control" path="author" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="thoughts">My thoughts: </form:label>
                        <form:errors class="text-danger fs-6" path="thoughts" />
                        <form:textarea class="form-control" path="thoughts" rows = "5" cols = "30"/>
                    </h4>
                </div>
                <div class="form-group mt-1 row">
					<form:errors path="user" class="error"/>
					<form:input type="hidden" path="user" value="${user.id}"/>
				</div>
                <button class="mt-2 btn btn-primary">Submit</button>
            </form:form>
           	<form action="/books/${book.id}/delete" method="post">
   				<input type="hidden" name="_method" value="delete">
   				<button class="mt-3 btn btn-danger">DELETE BOOK</button>
			</form>
        </div>
    </div>
	
</body>
</html>
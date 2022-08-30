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
    <title>Add Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-color:lime;">
	
	<nav class="d-flex justify-content-around bg-dark">
        <h1 class="text-primary">Lookify</h1>

        <div class="d-flex justify-content-around gap-4">
	        <a href="/dashboard" class="mt-2 ps-3">Dashboard</a>
        </div>
    </nav>


    <div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5">
        <h2 class="text-center">ADD SONG</h2>
        <div class="col-6 mx-auto">
            <form:form action="/songs/new" method="post" modelAttribute="song">
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="title">Title:
                        </form:label>
                        <form:errors class="text-danger fs-6" path="title" />
                        <form:input class="form-control" type="text" path="title" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="artist">Artist:</form:label>
                        <form:errors class="text-danger fs-6" path="artist" />
                        <form:input class="form-control" type="text" path="artist" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="rating">Rating (1-10): </form:label>
                        <form:errors class="text-danger fs-6" path="rating" />
                        <form:input class="form-control" type="number" min="1" max="10" path="rating" />
                    </h4>
                </div>
                <button class="mt-2 btn btn-primary">Add Song</button>
            </form:form>
        </div>
   	 </div>

</body>
</html>
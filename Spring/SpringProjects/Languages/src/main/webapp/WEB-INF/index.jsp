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
    <title>Languages</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-primary">
    <div class="container row p-3 mx-auto bg-dark text-primary rounded mt-5">
    	<div>	
        	<h1 class="text-warning mt-1 text-center">Languages</h1>
        </div> 

        <table class="table mt-3 table-dark text-warning rounded">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Creator</th>
                    <th scope="col">Version</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="language" items="${languages}">
                    <tr>
                        <td><a  class="text-warning" href="languages/<c:out value=" ${language.id}" />">
                            <c:out value="${language.name}" /></a>
                        </td>
                        <td>
                            <c:out value="${language.creator}" />
                        </td>
                        <td>
                            <c:out value="${language.currentVersion}" />
                        </td>
                        <td class="d-flex gap-3">
                            <a href="/languages/<c:out value=" ${language.id}" />/edit">edit</a>
                            <form action="/languages/<c:out value=" ${language.id}" />/delete"
                            method="post">
                            <input type="hidden" name="_method" value="delete">
                            <button class="mt-2 btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="container row p-3 mx-auto bg-dark text-primary rounded">
        <h2 class="text-center">ADD LANGUAGE</h2>
        <div class="col-6 mx-auto">
            <form:form action="/languages" method="post" modelAttribute="language">
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label text-start" path="name">Name:
                        </form:label>
                        <form:errors class="text-danger fs-6" path="name" />
                        <form:input class="form-control" type="text" path="name" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="creator">Creator:</form:label>
                        <form:errors class="text-danger fs-6" path="creator" />
                        <form:input class="form-control" type="text" path="creator" />
                    </h4>
                </div>
                <div class="form-group mt-1 row">
                    <h4>
                        <form:label class="col col-form-label" path="currentVersion">Version: </form:label>
                        <form:errors class="text-danger fs-6" path="currentVersion" />
                        <form:input class="form-control" type="text" path="currentVersion" />
                    </h4>
                </div>
                <button class="mt-2 btn btn-primary">Submit</button>
            </form:form>
        </div>


    </div>

</body>
</html>
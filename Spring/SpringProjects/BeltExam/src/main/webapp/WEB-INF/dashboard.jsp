d<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title>House Hunter Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&display=swap" rel="stylesheet">
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-start gap-5 mt-5">
		<h1 class="fw-bold fs-2 text-white title">Welcome, <c:out value="${user.username}"/>!</h1>
	</div>
	<div class="container d-flex justify-content-end">
		<a href="/logout" class="btn btn-danger">Logout</a>
	</div>
	<div class="container d-flex justify-content-between mt-5">
		<h2 class="fs-5 text-white">All Listings: </h2>
	</div>
	<div class="container">
		<table class="table mt-3">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Address</th>
                    <th scope="col">Listed On</th>
                    <th scope="col">Added By</th>
                    <th scope="col">Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listing" items="${listings}">
                    <tr>
                        <td><a  class="text-warning" href="/listings/<c:out value="${listing.id}"/>">
                            <c:out value="${listing.address}" /></a>
                        </td>
                        <td>
                        	<fmt:formatDate type="date" value="${listing.listingDate}" pattern="MM/dd/yy" var="formattedDate"/>
                            <c:out value="${formattedDate}"/>
                        </td>
                        <td>
                            <c:out value="${listing.user.username}"/>
                        </td>
                        <td>
                        	<fmt:formatNumber type="number" value="${listing.price}" pattern=",000" var="formattedPrice"/>
                            $<c:out value="${formattedPrice}"/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
	</div>
	<div class="container">
		<a href="/listings/new"><button class="btn btn-primary btn-lg btn-block w-100">+ Add New Listing</button></a>
	</div>
	
</body>
</html>
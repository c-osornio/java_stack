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
    <title>View Listing</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&display=swap" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style= "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(59,186,176,1) 35%, rgba(0,212,255,1) 100%);">
	<div class="container d-flex justify-content-between mt-5">
			<h1 class="fw-bold text-white title"><c:out value="${listing.address}"/></h1>
			<a href="/dashboard">Back to Dashboard</a>
	</div>
	<div class="container">
        <table class="table mt-3 text-white">
        	<tbody>
        		<tr>
        			<td> Address:
        			</td>
        			<td><c:out value="${listing.address}"/>
        			</td>
        		</tr>
        		<tr>
        			<td> Listing Date:
        			</td>
        			<td>
        				<fmt:formatDate type="date" value="${listing.createdAt}" pattern="MM/dd/yy" var="formattedDate"/>
                        <c:out value="${formattedDate}"/>
        			</td>
        		</tr>
        		<tr>
        			<td> Price:
        			</td>
        			<td>
        				<fmt:formatNumber type="number" value="${listing.price}" pattern="0,000" var="formattedPrice"/>
                        $<c:out value="${formattedPrice}"/>
        			</td>
        		</tr>
        	</tbody>
        </table>
    </div>
    
    <div class="container mt-4">
    	<h2 class="text-white">Notes: </h2>
    </div>
    <div class="container log text-white">
		<c:forEach var="note" items="${notes}">
			<h4 class="fs-5 mt-3">Added by <c:out value="${note.user.username}"/></h4>
			<p>- <c:out value="${note.text}"/></p>
			
			<form action="/listings/${listing.id}/${note.id}/delete" method="post">
   				<input type="hidden" name="_method" value="delete">
   				<button class="btn btn-success">Clear Note</button>
			</form>
			<hr>
		</c:forEach>
    </div>
    
    <div class="container">
     	<form:form action="/listings/${listing.id}/notes" method="post" modelAttribute="note">
     		<div>
     			<h3 class="fs-3 mt-4 text-white">Add Note:</h3>
     		</div>
     		<div class="form-group">
     			<form:errors class="text-danger fs-6" path="text"/>
     			<form:input  class="form-control" path="text"/>
     		</div>
			<div class="form-group d-flex justify-content-end">
 				<button class="mt-2 btn btn-primary btn-lg btn-block w-100">Add Note</button>
			</div>
     	</form:form>
    </div>
    
    <div class="container d-flex justify-content-center gap-3 mt-4">
    	<c:if test="${listing.getUser().equals(user)}">
			<a href="/listings/${listing.id}/edit">
				<button class="btn btn-warning text-white">Edit</button>
			</a>
			<form action="/listings/${listing.id}/delete" method="post">
   				<input type="hidden" name="_method" value="delete">
   				<button class="btn btn-danger">Delete</button>
			</form>
		</c:if>
    </div>
	
</body>
</html>
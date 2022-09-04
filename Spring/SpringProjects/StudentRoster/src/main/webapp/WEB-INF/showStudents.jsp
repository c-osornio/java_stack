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
    <title><c:out value="${dorm.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-primary">
    <div class="container row p-3 mx-auto bg-dark text-info rounded mt-5">
        <h2 class="text-center"><c:out value="${dorm.name}"/> Students</h2>
        
        <div>
        	<a href="/dorms/">Dashboard</a>
        </div>
        
        <div class="col-6 mx-auto">
            <form action="/dorms/${dorm.id}" method="post">

			<table class="table mt-3 table-dark text-warning rounded">
	    		<thead>
	        		<tr>
	            		<td>Students:				
							<select name="studentId">
	                    	<c:forEach var="student" items="${allStudents}">
	                    		<c:if test = "${student.dorm==null}">
						       		<option value="${student.id}">${student.name}</option>
						    	</c:if>
	                        	<c:if test = "${student.dorm!=null}">
						       		<option value="${student.id}">${student.name} (${student.dorm.name})</option>
						    	</c:if>
	                    	</c:forEach>
	                		</select>
	            		</td>
	            		<td>
	            			<button class="btn btn-danger">Add</button>
	            		</td>
	        		</tr>
	    		</thead>
			</table>
			</form>
		</div>
		<hr>
		<table class="table mt-3 table-dark text-warning rounded">
			<thead>
        		<tr>
            		<th scope="col">Student</th>
            		<th scope="col">Action</th>
        		</tr>
    		</thead>
    		<tbody>
				<c:forEach var="student" items="${dormStudents}">
					<tr>
						<td><c:out value="${student.name}"></c:out></td>
						<td><a href="/students/remove/${student.id}">Remove</a></td>
					</tr>	
				</c:forEach>
    		</tbody>
		</table>
</body>
</html>
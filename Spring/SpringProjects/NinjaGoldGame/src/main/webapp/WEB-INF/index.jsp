<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="main">
		<div>
			<h1>Your Gold: <c:out value="${gold}"/></h1>
		</div>
	
	<!-- Have 4 separate forms making POST requests> -->	
	    <div class="container">
	        <div class="box">
	            <h2>Farm</h2>
	            <h3>(earns 10 - 20 gold)</h3>
	            <br>
	            <form action="/processMoney" method="post">
	                <input type="hidden" name="Farm" value="Farm">
	                <button type="submit">Find Gold!</button>
	            </form>
	        </div>
	        <div class="box">
	            <h2>Cave</h2>
	            <h3>(earns 5 - 10 gold)</h3>
	            <br>
	            <form action="/processMoney" method="post">
	                <input type="hidden" name="Cave" value="Cave">
	                <button type="submit">Find Gold!</button>
	            </form>    
	        </div>
	        <div class="box">
	            <h2>House</h2>
	            <h3>(earns 2 - 5 gold)</h3>
	            <br>
	            <form action="/processMoney" method="post">
	                <input type="hidden" name="House" value="House">
	                <button type="submit">Find Gold</button>
	            </form>    
	        </div>
	        <div class="box">
	            <h2>Quest</h2>
	            <h3>(earns/takes 0 - 50 gold)</h3>
	            <br>
	            <form action="/processMoney" method="post">
	                <input type="hidden" name="Quest" value="Quest">
	                <button type="submit">Find Gold!</button>
	            </form>
	        </div>
	       	<div class="box">
	            <h2>Spa</h2>
	            <h3>(takes 5 - 20 gold)</h3>
	            <br>
	            <form action="/processMoney" method="post">
	                <input type="hidden" name="Spa" value="Spa">
	                <button type="submit">Find Gold!</button>
	            </form>
	        </div>
	    </div>
	    <h3>Activity Log:</h3>
	    <div class="log">
			<c:forEach var="activity" items="${log}">
				<c:if test = "${activity.contains('earned')}">
	       			<p style="color: green;"><c:out value="${activity}"/></p>
	    		</c:if>
	    		<c:if test = "${activity.contains('lost')}">
	       			<p style="color: red;"><c:out value="${activity}"/></p>
	    		</c:if>
			</c:forEach>
	    </div>
	    <div>
	    	<button><a href="/reset">Reset</a></button>
	    </div>
	</div>
</body>
</html>
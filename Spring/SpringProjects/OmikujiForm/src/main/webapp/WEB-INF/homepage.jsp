<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<h1 class="text-center">Send an Omikuji!</h1>
	<div class="container p-3 rounded text-center">
		<div class="col-5 mx-auto">
	
			<form action="/processForm" method="POST">
				<div class="form-group">
					<label>Pick any number from 5 to 25</label>
					<input type="number" class="form-control" name="number" min="5" max="25">
				</div>
				<div class="form-group">
					<label>Enter the name of any city.</label>
					<input type="text" class="form-control" name="city">
				</div>
				<div class="form-group">
					<label>Enter the name of any real person.</label>
					<input type="text" class="form-control" name="person">
				</div>
				<div class="form-group">
					<label>Enter professional endeavor or hobby.</label>
					<input type="text" class="form-control" name="hobby">
				</div>
				<div class="form-group">
					<label>Enter a type of living thing.</label>
					<input type="text" class="form-control" name="thing">
				</div>
				<div class="form-group">
					<label>Say something nice to someone.</label>
					<textarea class="form-control" name="somethingNice" rows="3"></textarea>
				</div>
				<div class="form-group">
					<p>Send and show a friend!</p>
					<button type="submit" class="btn btn-success mt-2">Send</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Add a book to your shelf!</h1>
	<a href="/books/all">back to the shelves</a>
		<form:form class="form" action="/books/create" method="post" modelAttribute="newBook">
			<%-- <form:hidden path="user" value="${session.userId}"/> --%>
			<div class="form-group row">
				<form:label path="title">Title</form:label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title" class="text-danger"/> 
			</div>
			<div class="form-group row">
				<form:label path="author">Author</form:label>
				<form:input path="author" class="form-control"/>
				<form:errors path="author" class="text-danger"/> 
			</div>
			<div class="form-group row">
				<form:label path="thoughts">My thoughts</form:label>
				<form:input path="thoughts" class="form-control"/>
				<form:errors path="thoughts" class="text-danger"/> 
			</div>
			<button class='btn btn-primary'>Submit</button>
		</form:form>		
</div>
   
</body>
</html>
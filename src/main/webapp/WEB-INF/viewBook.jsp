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
	<div class="header d-flex m-5">
		<div>
			<h1><c:out value="${book.title}"/></h1>
		</div>
		<div class="ms-auto">
			<a href="/books/all" >back to shelves</a>
		</div>
	</div>
	<div class="container col-6 ml-10">
		<p>
			<span>
				<c:choose>
					<c:when test="${user.id == book.user.id}">
						You
					</c:when>
					<c:otherwise>
						<c:out value="${book.user.name}"/>
					</c:otherwise>
				</c:choose>
			</span>
			read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.
		</p>
		<p> 
			Here are 
				<span>
					<c:choose>
						<c:when test="${user.id == book.user.id}">
							Your
						</c:when>
						<c:otherwise>
							<c:out value="${book.user.name}"/>'s
						</c:otherwise>
					</c:choose>
				</span>
			thoughts:
		</p>
	<div>
		<c:out value="${book.thoughts}"/>
	</div>
	<div class="d-flex">
		<div class="ms-auto">
		<c:if test="${user.id == book.user.id}">
			<button class="btn btn-primary">Edit</button>
			<button class="btn btn-danger">Delete</button>
		</c:if>
	   </div>
   </div>
</div>

</body>


</html>
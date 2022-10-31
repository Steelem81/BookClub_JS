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
	<div class="header d-flex">
		<div >
		<h1>Welcome <c:out value="${user.userName}"/></h1>
		<p>Books from everyone's shelves</p>
		</div>
		<div class="d-flex flex-column ms-auto">
			<a href="/logout">logout</a>
			<a href="/books/addBook">+ Add a book to my shelf</a>
		</div>
	</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</thead>
			<tbody>
				<c:forEach var="book" items="${allBooks}">
					<tr>
						<td><c:out value="${book.id}" /></td>
						<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}" /></td>
						<td><c:out value="${book.user.userName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>
   
</body>
</html>
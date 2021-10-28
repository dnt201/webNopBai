<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Murach's Java Servlet and JSP</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css"
	type="text/css" />
</head>
<body>
	<h1>Thanks for joining our email list</h1>

	<p>Here is the information that you enter</p>
	<div>
		<label>Email:</label> <span>${user.email}</span><br>
		<label>First name:</label> <span>${user.firstName}</span><br>
		<label>Last name:</label> <span>${user.lastName}</span><br>
	</div>

	
	<p>This email address was added to our list on ${requestScope.currentDate}</p>

	<p>All email was submitted:</p>
	<c:forEach items="${sessionScope.users}" var="user">
	    <p>${user.email}</p>
	</c:forEach>

    <p>For customer service, contact: nhom10@hcmute.edu.vn</p>    

    <p>To enter another email address, click on the Back 
    button in your browser or the Return button shown 
    below.</p>

	<form action="" method="get">
		<button name ="action" value ="join">Return</button>
		<button name="action" value="homepage">Home page</button>
		<br>
	</form>
</body>
</html>
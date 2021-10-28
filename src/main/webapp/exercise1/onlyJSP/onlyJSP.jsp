<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Murach's Java Servlet and JSP</title>
        <meta charset="UTF-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Many Thanksss</h1>
         <% String val = request.getParameter("UserName"); %>
        
       <h1> Hello: <%=val%></h1>
	    <p>Served with: onlyJSP/webNopBai</p></br>
        <p>To return homepage, please click on the Return button show below </p>
        
        
        <form action="../../index.html" method="get">
            <input type="hidden" name="action" value="homepage">
            <input type="submit" value="Return">
        </form>
    </body>
</html>
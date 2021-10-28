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
        
       <h1> Hello: ${UserName}</h1>
        <p>To return homepage, please click on the Return button show below </p>
        
        
        <form action="" method="get">
            <input type="hidden" name="action" value="homepage">
            <input type="submit" value="Return">
        </form>
    </body>
</html>
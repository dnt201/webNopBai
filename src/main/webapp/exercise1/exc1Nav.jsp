<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/navExc1.css">
    
    <title>Nhóm 10 - Week 4</title>
	<link rel="stylesheet"  href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap">
</head>

<body>
<div class="container full-height">
    <form action="exc1" method="get">
        <button class="only-JSP btn" name="action" value="onlyJSP">Only JSP</button>
        <button class="combine-both btn" name="action" value="combine">Combine</button>
    </form>

    <form class="exc1onlyServlet" action="exc1-login-onlyServlet" method="get">
        <button class="only-Servlet btn" name="action" value="onlyServlet">Only Servlet</button>
    </form>

    <form action="assignment" method="get">

        <button class="btn-return btn"  
        		name="action" 
        		value="homepage"
        >
        	Return
        </button>
    </form>
</div>
</body>

</html>
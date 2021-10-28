<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Checkout EXC4</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exc4.css" type="text/css"/>
</head>
<body>
    <h1>RECEIPT</h1>
    <h4>Total amount: ${requestScope.totalMoney}</h4>
    <p>Thanks you very much and see you later!!</p>
    <form action="" method="post">
		<input type="hidden" name="action" value="shop">
		<input type="submit" value="Shopping Again?">
	</form>
	  <form style="margin-top:16px" action="" method="post">
		<input type="hidden" name="action" value="homepage">
		<input type="submit" value="Home page">
	</form>
</body>
</html>
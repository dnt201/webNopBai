<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/exc1.css">
<title>Document</title>
</head>
<body>
	<div class="login">
		<form action="exc1Login" method="post">
			<h2>User Login</h2>
			<input required type="text" placeholder="  User name" name="UserName"required> <br>
			<input required type="password" placeholder="  Password" name="Password" required> <br>
			<button class="btn" name="action" value="login">Login</button>
			<br>
		</form>
		<a href=""> Forgot Password?</a>
	</div>
</body>
</html>
<!DOCTYPE html>
<html>

<head>
    <title>Week 3</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" type="text/css"/>
</head>

<body>
    <div class="container">
        <h1>Join to our email list</h1>
        <p>To join our email list, enter your name and email address below</p>
        <p><i>${message}</i></p>
        <form action="emailList" method="post">

            <label>Email:</label>
            <input type="email" name="email" value="${user.email}"><br>

            <label>First Name:</label>
            <input type="text" name="firstName" value="${user.firstName}"><br>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="${user.lastName}"><br>
            
            <button name ="action" value ="add">Submit</button>
            <button name ="action" value ="homepage">Home page</button>
        </form>
    </div>
</body>

</html>
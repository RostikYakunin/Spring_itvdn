
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1>Hello users</h1>

${users}

<br>
<h1>Input</h1>
<form action="/repo/add" method="post" modelAttribute="${user}">

    <p>Name : <input type="text" name="name"></p>
    <p>Surname : <input type="text" name="surname"></p>
    <p>Age : <input type="number" name="age"></p>
    <p>Telephone : <input type="number" name="telephone"></p>

    <input type="submit" value="Pass data">
</form>


</body>
</html>
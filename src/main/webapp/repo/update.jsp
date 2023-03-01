
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/repo/update" method="post" modelAttribute="${user}">

    <p>ID : <input type="number" name="id"></p>
    <p>Name : <input type="text" name="name"></p>
    <p>Surname : <input type="text" name="surname"></p>
    <p>Years : <input type="number" name="age"></p>
    <p>Telephone : <input type="number" name="telephone"></p>

    <input type="submit" value="Pass data">
</form>


</body>
</html>
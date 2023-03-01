<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form id="user-form" action="/info-input" method="post" modelAttribute="${user}">
    <p>Name : <input type="text" name="name"></p>
    <p>Surname : <input type="text" name="surname"></p>
    <p>Years : <input type="number" name="age"></p>
    <input type="submit" value="Pass data">
</form>

</body>
</html>
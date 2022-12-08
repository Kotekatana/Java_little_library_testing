
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <title>Sign In</title>
</head>
<body>
<form action="/signUp" method="post">
    <label>
        <input type="text" name="firstName" placeholder="Имя">
    </label>
    <br>
    <label>
        <input type="text" name="lastName" placeholder="Фамилия">
    </label>
    <br>
    <label>
        <input type="email" name="email" placeholder="Email">
    </label>
    <br>
    <label>
        <input type="password" name="password" placeholder="Password">
    </label>
    <br>
    <input type="submit" value="Регистрация">
</form>
</body>
</html>
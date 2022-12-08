<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<table>
    <tr>
        <th>№</th>
        <th>Пользователь</th>
        <th>Книга</th>
        <th>Действия</th>
    </tr>
    <#list orders as order>
        <tr>
            <td>${order.id}</td>
            <td>${order.user.email}</td>
            <td>${order.book.title}</td>
            <td>
                <a href="orders/${order.id}/delete">Удалить</a>
            </td>
        </tr>
    </#list>
</table>
<form action="/orders" method="post">
    <select name="userId">
        <#list users as user>
            <option value=${user.id}>${user.firstName} ${user.lastName}</option>
        </#list>
    </select>
    <br>
    <select name="bookId">
        <#list books as book>
            <option value=${book.id}>${book.title}</option>
        </#list>
    </select>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</body>
</html>
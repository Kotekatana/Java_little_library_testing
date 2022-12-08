<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль</title>
</head>
<body>
<h1>${user.firstName} ${user.lastName}</h1>
<h2>${user.email}</h2>
<table>
    <tr>
        <th>Книга</th>
        <th>Действия</th>
        <th>Статус</th>
    </tr>
    <#list orders as order>
        <tr>
            <td>${order.book.title}</td>
            <td>
                <a href="books/${order.book.id}">Перейти</a>
            </td>
            <#if order.state == "CONFIRMED">
                <td>&#10004;</td>
                <#else>
                <td>&#10006;</td>
            </#if>
        </tr>
    </#list>
</table>
</body>
</html>
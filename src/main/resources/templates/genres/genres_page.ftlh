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
        <td>Название</td>
        <td>Действия</td>
    </tr>
    <#list genres as genre>
        <tr>
            <td>${genre.title}</td>
            <td>
                <a href="/books?genre=${genre.id}">Перейти</a>
                <#if role == 'ADMIN'>
                <a href="/books/${genre.id}/delete">Удалить</a>
                </#if>
            </td>
        </tr>
    </#list>
</table>
<#if role == 'ADMIN'>
<form action="/genres" method="post">
    <label>
        Название
        <input type="text" name="title" placeholder="Введите название">
    </label>
    <br>
    <label>
        Описание
        <textarea  name="lastName" placeholder="Введите описание"></textarea>
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>
</body>
</html>
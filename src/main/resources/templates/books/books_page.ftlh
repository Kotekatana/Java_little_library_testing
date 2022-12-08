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
<a href="/books">Все</a>
<#list genres as genre>
    <a href="/books?genre=${genre.id}">${genre.title}</a>
</#list>
<table>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Автор</th>
        <th>Жанр</th>
        <th>Статус</th>
        <th>Действия</th>
    </tr>
    <#list books as book>
        <tr>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>${(book.author.firstName)!""} ${(book.author.lastName)!""}</td>
            <td>${(book.genre.title)!""}</td>
            <#if book.state == "FREE">
                <td>&#10004;</td>
            <#else>
                <td>&#10006;</td>
            </#if>

            <td>
                <a href="books/${book.id}">Перейти</a>
                <#if role == 'ADMIN'>
                <a href="books/${book.id}/delete">Удалить</a>
                </#if>
            </td>
        </tr>
    </#list>
</table>
<#if role == 'ADMIN'>
<form action="/books" method="post">
    <label>
        Название
        <input type="text" name="title" placeholder="Введите название книги">
    </label>
    <br>
    <label>
        описание
        <textarea type="text" name="description" placeholder="Введите описание"></textarea>
    </label>
    <br>
    <select name="author">
        <#list authors as author>
            <option value=${author.id}>${author.firstName} ${author.lastName}</option>
        </#list>
    </select>
    <br>
    <select name="genre">
        <#list genres as genre>
            <option value=${genre.id}>${genre.title}</option>
        </#list>
    </select>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>
</body>
</html>
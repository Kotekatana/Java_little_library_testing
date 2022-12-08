<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователь</title>
</head>
<body>


<#if role == 'ADMIN'>
<form action="/books/${book.id}/update" method="post">
    <label>
        Название
        <input type="text" name="title" placeholder="Введите название книги" value="${book.title}">
    </label>
    <br>
    <label>
        описание
        <textarea type="text" name="description" placeholder="Введите описание">${book.description}</textarea>
    </label>
    <br>
    <select name="author">
        <#list authors as author>

            <#if book.author.id == author.id>
                <option value=${author.id} selected> ${author.firstName} ${author.lastName}</option>
            <#else>
                <option value=${author.id}>${author.firstName} ${author.lastName}</option>
            </#if>
        </#list>
    </select>
    <br>
    <select name="genre">
        <#list genres as genre>
            <#if book.genre.id == genre.id>
                <option value=${genre.id} selected>${genre.title}</option>
            <#else>
                <option value=${genre.id}>${genre.title} </option>
            </#if>
        </#list>
    </select>
    <br>
    <input autofocus type="submit" value="Изменить"/>
</form>
    <#else >
    <h1>${book.title}</h1>
    <h2>${book.description}</h2>
    <h3>${book.author.firstName} ${book.author.lastName}</h3>
    <h4>${book.genre.title}</h4>
</#if>
</body>
</html>
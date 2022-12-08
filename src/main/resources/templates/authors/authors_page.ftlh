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
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Действия</th>
    </tr>
    <#list authors as author>
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>${author.patronymic}</td>
            <td>
                <#if role == "ADMIN">
                    <a href="/authors/${author.id}/delete">Удалить</a>
                </#if>
                <a href="/authors/${author.id}">Посмотреть</a>
            </td>

        </tr>
    </#list>
</table>
<#if role == "ADMIN">
    <h3>Добавить автора</h3>
    <form action="/authors" method="post">
    <label>
        Имя
        <input type="text" name="firstName" placeholder="Введите имя">
    </label>
    <br>
    <label>
        Фамилия
        <input type="text" name="lastName" placeholder="Введите фамилию">
    </label>
    <br>
    <label>
        Отчество
        <input type="text" name="patronymic" placeholder="Введите Отчество">
    </label>
    <br>
    <label>
        Дата рождения
        <input type="date" pattern="dd/mm/yyyy" placeholder="dd-mm-yyyy" name="dateOfBirth" placeholder="Дата рождения">
    </label>
    <br>
    <label>
        Дата смерти
        <input type="date" pattern="dd/mm/yyyy"  placeholder="dd-mm-yyyy" name="dateOfDeath" placeholder="Дата смерти">
    </label>
    <br>
    <input autofocus type="submit" value="Добавить"/>
</form>
</#if>

</body>
</html>
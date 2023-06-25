<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}<#sep>,</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактировние</a></th>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
<p ><a href="/factories">Главная</a></p>
</body>
</html>
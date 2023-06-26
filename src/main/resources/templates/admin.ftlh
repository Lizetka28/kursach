<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
  <link href="https://fonts.googleapis.com/css2?family=Philosopher&family=Pattaya&display=swap" rel="stylesheet">
  <style>
body {
background-color: #6096A6;
}

input, select, textarea{
    color: #336A72;
         color: #443B50;
     font-size: 20px;
     font-family: "Pattaya", sans-serif;
}
h1{
         color: #443B50;
     font-size: 50px;
     font-family: "Pattaya", sans-serif;
     }

         a{
          color:#8A678A;
          font-size: 20px;
          font-family: "Pattaya", sans-serif;
          padding:10px;
     text-decoration:none;
         }
             th{
              color: #443B50;
              font-size: 20px;
              font-family: "Pattaya", sans-serif;
             }
</style>

<body>
<header align="center">
<h1>Admin's panel</h1>
<table border="1" bordercolor="#73515A" bgcolor=#73515A>
</header>
    <tr>
        <th bgcolor=#F3BEE1>Email</th>
        <th bgcolor=#F3BEE1>Active</th>
        <th bgcolor=#F3BEE1>Roles</th>
        <th bgcolor=#F3BEE1>Ban</th>
        <th bgcolor=#F3BEE1>Edit</th>
    </tr>
    <#list users as user>
        <tr>
            <th bgcolor=#F3BEE1>${user.email}</th>
            <th bgcolor=#F3BEE1><#if user.active>true<#else>false</#if></th>
            <th bgcolor=#F3BEE1><#list user.roles as role>${role}<#sep>,</#list></th>
            <th bgcolor=#F3BEE1>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban">
                </form>
            </th>
            <th bgcolor=#F3BEE1><a href="/admin/user/edit/${user.id}">Edit</a></th>
        </tr>
    <#else>
        <h1>No user</h1>
    </#list>
</table>
<p ><a href="/factories">Main</a></p>
</body>
</html>
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
     label{
              color: #443B50;
     font-size: 20px;
     font-family: "Pattaya", sans-serif;
     }
         a{
          color:#8A678A;
          font-size: 20px;
          font-family: "Pattaya", sans-serif;
          padding:10px;
     text-decoration:none;
     text-align:center;
     display:block;
         }
         form{
             color: #443B50;
              font-size: 20px;
              font-family: "Pattaya", sans-serif;

         }
         button{
             color: #336A72;
                  color: #443B50;
              font-size: 20px;
              font-family: "Pattaya", sans-serif;
         }
</style>
<body>
<header align="center">
<h1>Edit user ${user.name}</h1>
</header>
<form action="/admin/user/edit" method="post">
<#list roles as role>
<div>
<label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
</div>
</#list>
<input type="hidden" value="${user.id}" name="userId">
  <input type="hidden" name="_csrf" value="${_csrf.token}">
  <button type="submit" >Edit</button>
  </form>
  </body>

  </html>
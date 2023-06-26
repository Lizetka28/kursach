<!DOCTYPE html>
<html>
<head>
  <title>Registration</title>
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
 form{
             color: #443B50;
              font-size: 20px;
              font-family: "Pattaya", sans-serif;

         }
</style>
<body>
<header align="center">
<h1>Registration</h1>
</header>
<form action="/registration" method="post">
  Username: <input type="text" name="name"><br><br>
  Email: <input type="email" name="email"><br><br>
  Password: <input type="password" name="password"><br><br>
  <input type="hidden" name="_csrf" value="${_csrf.token}">
  <input type="submit" value="Registration"/>
</form>
  <#if errorMessage??>
        <h2 style="color: red">${errorMessage}</h2>
    </#if>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
  <title>Authorization</title>
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
</style>
<body>
<h1 align="center" >Authorization</h1>
<form action="/login" method="post" align="center">
 Email: <input type="email" name="username"><br><br>
 Password: <input type="password" name="password"><br><br>
  <input type="hidden" name="_csrf" value="${_csrf.token}">
  <input type="submit" value="Enter"/>
</form>
<a  href="/registration">Registration</a>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>

<%@ page import="com.jooby.app.model.User" %>
<%@ page import="com.jooby.app.repository.JdbcUserRepository" %>
<html>

<head>
    <style>
        body {
            background-image: url("background.jpg");
        }

        h2 {
            text-decoration-color: coral;
        }
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Jooby</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" href="index.jsp">LOGIN</a>
    </li>
</ul>
</br>
<br>
<form action="useradd.jsp">
    <div align="CENTER" class="form-outline mb-4">
        <img src="#" height="300" width="600">
        <br>
        <br>
        <br>
        <br>
        <h2 style="color: coral" align="CENTER"><strong>CREATE ACCOUNT</strong></h2>
        <br>
        <br>
        <div class="form-outline mb-4">
            <%--@declare id="inputbook"--%><label style="color:cadetblue" for="inputBook"><strong>USER NAME</strong>
        </label>
            <input type="text" name="user_name" value!="null" onclick="this.value=''" required="true"/><br/>
        </div>
        <br/>
        <div class="form-outline mb-4">
            <label style="color:cadetblue" for="inputBook"> <strong>PASSWORD</strong></label>
            <input type="text" name="password" value!="null" onclick="this.value=''" required="true"/><br/>
        </div>
        <div class="form-outline mb-4">
            <label style="color:cadetblue" for="inputBook"> <strong>USER TYPE</strong></label>
            <input type="text" name="userType" value!="null" onclick="this.value=''" required="true"/><br/>
        </div>
        <br>
        <div  class="form-outline mb-4">
            <input class="btn btn-primary" type="submit" value="Submit">
        </div>

    </div>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 18.11.19
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Med.Care</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>

<body>

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" alt = "wait"></p>

<div id="wrapper">

    <div class="user-icon"></div>
    <div class="pass-icon"></div>

    <form name="login-form" class="login-form" action="" method="post">

        <div class="header">
            <h1>Авторизация</h1>
        </div>

        <div class="content">
            <input name="username" type="text" class="input username" value="Логин" onfocus="this.value=''" required />
            <input name="password" type="password" class="input password" value="Пароль" onfocus="this.value=''" required/>
            <br/><br/>
            <input id="remember_me" type="checkbox" name="remember_me" />
            <label for="remember_me">Remember me</label>
        </div>

        <div class="footer">
            <input type="submit" name="submit" value="ВОЙТИ" class="button" />
            <a href="registration" name="submit" class="register">Регистрация</a>
        </div>

    </form>

</div>

<div class="gradient"></div>

<script type="text/javascript">
    $(document).ready(function() {
        $(".username").focus(function() {
            $(".user-icon").css("left","-48px");
        });
        $(".username").blur(function() {
            $(".user-icon").css("left","0px");
        });

        $(".password").focus(function() {
            $(".pass-icon").css("left","-48px");
        });
        $(".password").blur(function() {
            $(".pass-icon").css("left","0px");
        });
    });
</script>

</body>
</html>
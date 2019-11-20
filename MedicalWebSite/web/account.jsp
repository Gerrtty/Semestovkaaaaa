<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 20.11.19
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Medical.Care.PersonalArea</title>
</head>
<body>

<style>body{
    background: url("photo/background.png"); background-size: 150% 425%;
}</style>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap..">

<p>User photo</p>
<img wight="150" height="150" src="${loginedUser.ava}">

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" alt = "wait"></p>

<h2 style="text-align: center;"><span style="color: #00ccff;">Личный кабинет</span></h2>


Имя: <div name= "firstname" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.firstName}</div><br/><br>

Фамилия: <div name = "lastname" style="border:3px dodgerblue solid; width: 200px;" >${loginedUser.lastName}</div><br/><br/>

Пол:<div name="gender" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.gender}</div><br/><br/>

Номер телефона: <div name = "phone" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.phone}</div><br/><br/>

</body>

</html>

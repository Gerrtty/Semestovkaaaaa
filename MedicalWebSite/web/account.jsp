<%@ page import="ORM.User" %><%--
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

    <script>
        function previewFile() {
            var preview = document.getElementById('ava');
            var file    = document.querySelector('input[type=file]').files[0];
            var reader  = new FileReader();

            reader.onloadend = function () {
                preview.src = reader.result;
            };

            if (file) {
                reader.readAsDataURL(file);
            } else {
                preview.src = "";
            }
        }
    </script>

</head>
<body>

<style>body{
    background: url("photo/background.png"); background-size: 150% 425%;
}</style>

<form>
    <input type="button" value="Main page" onClick='location.href="mainPage"'>
</form>
<br/>

<form method="post" action="logout">
    <button type="submit">Logout</button>
</form>


<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" alt = "wait"></p>

<h2 style="text-align: center;"><span style="color: #00ccff;">Личный кабинет</span></h2>

<p> Фото</p>
<img id="ava" width="200" height="150" src="${loginedUser.path}" alt="wait">


<form method="post" action="edith" enctype="multipart/form-data">
    <input type="file" id="file" name="photo" multiple accept="image/*,image/jpeg" onchange="previewFile()"> <br/> <br/>
    <input type="submit" value="Save photo">
</form>

<br/>

Имя: <div name= "firstname" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.firstName}</div><br/><br>

Фамилия: <div name = "lastname" style="border:3px dodgerblue solid; width: 200px;" >${loginedUser.lastName}</div><br/><br/>

<%--Пол:<div name="gender" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.gender}</div><br/><br/>--%>

Номер телефона: <div name = "phone" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.phone}</div><br/><br/>

<%--Дата рождения: <div name = "birth_date" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.birthDate}</div><br/><br/>--%>

<%--О себе: <div name = "about_user" style="border:3px dodgerblue solid; width: 200px;">${loginedUser.about_user}</div>--%>

</body>

</html>

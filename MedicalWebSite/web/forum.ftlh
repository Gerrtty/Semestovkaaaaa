<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 18.11.19
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>Forum</title>
</head>

<body>
<br>

<style>
    a.button7 {
        font-weight: 700;
        color: white;
        text-decoration: none;
        padding: .8em 1em calc(.8em + 3px);
        border-radius: 3px;
        background: rgb(64,199,129);
        box-shadow: 0 -3px rgb(53,167,110) inset;
        transition: 0.2s;
    }
    a.button7:hover { background: rgb(53, 167, 110); }
    a.button7:active {
        background: rgb(33,147,90);
        box-shadow: 0 3px rgb(33,147,90) inset;
    }
</style>

<style>body{
    background: url("photo/background.png"); background-size: 100% 220%;
}</style>

<style>
    .outline {
        border: 2px solid black;
        padding: 0 10px;
    }
</style>

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" , alt = "wait"></p>
<h4 style="text-align: right;">Личный кабинет:</h4>
<p style="text-align: right;"><strong><a href="" class="button7">Зарегестрироваться</style></a></strong> / <strong><a href="" class="button7">Вход</a></strong></p><br/>
<h2 style="text-align: center;"><span style="color: #00ccff;">ФОРУМ</span></h2>

<h3>Что вы думаете?</h3>
<div class="outline" style="width: 800px">
    <table>
        <tr>
            <td style="width: 200px">
                <div class="user_name" id="user_name">
                    <h3 style="color: blue">${Name}</h3>
                </div>
                <div class="date" id="date">
                    <h4>${Date}</h4>
            </td>
            <td>
                <div class="text_comment" id="text_comment">
                    <p>${your_comment}</p>
                    <a href="">Ответить</a>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 18.11.19
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>clinic</title>
</head>

<body>

<style>

    .rating {
        float:left;
    }

    /* Конструкция :not(:checked) работает как фильтр, чтобы браузеры, которые не поддерживают псевдокласс :checked не применяли эти свойства. Все браузеры, поддерживающие псевдокласс :checked, поддерживают и псевдокласс :not(), так что фильтр должен отработать правильно. */
    .rating:not(:checked) > input {
        position:absolute;
        top:-9999px;
        clip:rect(0,0,0,0);
    }

    .rating:not(:checked) > label {
        float:right;
        width:1em;
        padding:0 .1em;
        overflow:hidden;
        white-space:nowrap;
        cursor:pointer;
        font-size:200%;
        line-height:1.2;
        color:#ddd;
        text-shadow:1px 1px #bbb, 2px 2px #666, .1em .1em .2em rgba(0,0,0,.5);
    }

    .rating:not(:checked) > label:before {
        content: '★ ';
    }

    .rating > input:checked ~ label {
        color: #f70;
        text-shadow:1px 1px #c60, 2px 2px #940, .1em .1em .2em rgba(0,0,0,.5);
    }

    .rating:not(:checked) > label:hover,
    .rating:not(:checked) > label:hover ~ label {
        color: gold;
        text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
    }

    .rating > input:checked + label:hover,
    .rating > input:checked + label:hover ~ label,
    .rating > input:checked ~ label:hover,
    .rating > input:checked ~ label:hover ~ label,
    .rating > label:hover ~ input:checked ~ label {
        color: #ea0;
        text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
    }
    .rating > label:active {
        position:relative;
        top:2px;
        left:2px;
    }

</style>

<script type="text/javascript">

    window.onload = function(){
        document.getElementById('add').onclick = startKomm;
    };

    function startKomm(){
        var text = document.getElementById('txt').value;
        var komm = document.createElement('p');
        var newText = document.createTextNode(text);
        komm.appendChild(newText);
        document.getElementById('komments').appendChild(komm);
        return true;
    }

</script>

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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap..">
<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" , alt = "wait"></p>
<h4 style="text-align: right;">Личный кабинет:</h4>
<p style="text-align: right; font-weight: bold"><a href="" class="button7">Зарегестрироваться</a>
    / <a href="" class="button7">Вход</a></p><br/>
<p style="text-align: right"><a href="main" class="button7">Главная страница</a></p></br>
<p style="text-align: right"><a href="listOfClinics" class="button7">Вернуться к списку клиник</a></p></br>


        <h1 id="name_of_clinic"><strong>Name of clinic</strong></h1>
            <p id="address">address</p>
            <img width="500" height="300" src="photo/clinic/be%20healfy.jpg">
<h3 style="text-align: left"><a href="services">Просмотреть услуги и их цены</a> </h3>
<form>
    <label>Оставьте отзыв:</label><br />
    <textarea rows="5" cols="50" id="txt"></textarea><br />
    <input type="button" value="Добавить отзыв" id="add" />
</form>


<h4>${date}</h4>

<p>${comment}</p>

<fieldset class="rating" style="background-color: white">

    <legend><h2 id="name">${name}</h2></legend>

    <table style="width: 800px" height="30px">

        <div>
            <td style="width: 200px">
                <div class="date">
                    <img wight="80" height="80" src="photo/userPhoto.png">
                    <h4 id="date">${dat}</h4>
                </div>
            </td>
        </div>

        <td>
            <div class="text_comment">
                <p id="text_comment">${text_comment}</p>
                <p id="score">Оценка: ${score}</p>
            </div>
        </td>

    </table>
</fieldset>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 27.11.19
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service</title>
</head>
<body>

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

<header>

    <p style="text-align: right"><a href="mainPage" class="button7">Main page</a></p></br>
    <p style="text-align: right"><a href="services" class="button7">Back</a></p>

    <h1 style="text-align: center">${building.name}</h1><br/><br/>

    <h2 style="text-align: center">${service.description}</h2>

</header>

</body>
</html>

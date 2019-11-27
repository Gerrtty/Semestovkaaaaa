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

<header>
    <p style="text-align: right"><a href="mainPage" class="button7">Main page</a></p></br>
    <p style="text-align: right"><a href="services" class="button7">Back</a></p>

    <h1 style="text-align: center">${building.name}</h1><br/><br/>

    <h2 style="text-align: center">${service.description}</h2>

</header>


</body>
</html>

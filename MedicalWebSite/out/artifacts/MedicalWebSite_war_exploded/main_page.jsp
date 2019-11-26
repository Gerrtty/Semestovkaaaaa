<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 17.11.19
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Medical.Care.MainPage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap..">

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

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" , alt = "wait"></p>

<%
    if(request.getSession().getAttribute("loginedUser") == null) { %>
        <%@include file="includes/head_not_logined.jsp" %>

<%  }
    else { %>
        <%@include file="includes/head_logined.jsp" %>
<%    }
    %>

<p style="text-align: right;"><a href="about" class="button7">О сайте</a></p></br>
<p style="text-align: right;"><a href="phone" class="button7">Контактные телефоны</a></p></br>
<p style="text-align: right"><a href="forum" class="button7">Форум</a></p></br></br></br></br>
<h1 style="text-align: center; color: darkblue ; background: #00BFFF; " ></br>Клиники и больницы в городе Казань</h1></br></br></br>
<h2 style="text-align: center;"><a href="listOfClinics" class="button7">Список клиник</a></h2></br>

</body>
</html>

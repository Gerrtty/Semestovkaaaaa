<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>clinic</title>
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

<p style="text-align: right"><a href="mainPage" class="button7">Главная страница</a></p></br>
<p style="text-align: right"><a href="listOfClinics" class="button7">Вернуться к списку клиник</a></p></br>


<h1 id="name_of_clinic"><strong>${building.name}</strong></h1>

<p id="address">Town: ${building.address.town} district: ${building.address.district}
    st. ${building.address.street} № ${building.address.number}</p>
<img width="500" height="300" src="${building.path}">

<h3 style="text-align: left"><a href="services">Просмотреть услуги и их цены</a> </h3>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 18.11.19
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" , alt = "wait"></p>
<h4 style="text-align: right;">Личный кабинет:</h4>
<p style="text-align: right;"><strong><a href="style.css" class="button7">Зарегестрироваться</style></a></strong> / <strong><a href="" class="button7">Вход</a></strong></p><br/>

<form style="text-align: center">
    <input type="search">
    <input type="submit" value="Найти">
</form>
<table style="height: 260px;" width="834">
    <br>
    <tr>
        <td style="width: 409px;"><h2><strong>Список клиник:</strong></h2></td>
        <td style="width: 409px;"><h2><strong>Список услуг:</strong></h2></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>1)Будь здоров</p><img width="200" height="120" src="photo/clinic/be%20healfy.jpg"> <p>Медцентр ул.Нариманова,65</p></td>
        <td style="width: 409px;">
            Медецинский массаж
            <p>Консультация врача</p>
            <p>Вакцинация против гриппа</p>
            <a href="">Узнать цены</a>
        </td>
    </tr>
    </br>
    <tr>
        <td style="width: 409px;"><p>2)Скандинавия</p><img width="200" height="120" src="photo/clinic/Скандинавия.jpg"><p>Клиника, косметология Профсоюзная ул.19/15</p></td>
        <td style="width: 409px;">Прием детского врача
            <p>Бактериологический анализ</p>
            <p>Анализ крови</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>3)Медел</p><img width="200" height="120" src="photo/clinic/Medel.jpg"><p>Клиника, клиника Сибирский тракт,34</p></td>
        <td style="width: 409px;">Кардиолог
            <p>Бактериологический анализ</p>
            <p>Консультация врача</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>4)Корд</p><img width="200" height="120" src="photo/clinic/Корд.jpg"><p>Клиника, корекция зрения ул.Аделя Кутуя,82</p></td>
        <td style="width: 409px;">Диагностика зрения
            <p>Лечение глаз</p>
            <p>Анализ крови</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>5)Казанский</p><img width="200" height="120" src="photo/clinic/Казанский.jpg"><p>Клиника, мед.лаборатория ул.Николая Ершова, 16</p></td>
        <td style="width: 409px;">Анализ крови
            <p>Бактериологический анализ</p>
            <p>Прием врача терапевта</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>6)Клиника здоровья</p><img width="200" height="120" src="photo/clinic/КлиникаЗдоровья.jpg"><p>Клиника, медцентр ул.Вишневского,49Б</p></td>
        <td style="width: 409px;">Консультация врача
            <p>УЗИ органов</p>
            <p>Анализ крови на сахар</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>7)Лотос Мед</p><img width="200" height="120" src="photo/clinic/ЛотосМед.jpg"><p>Клиника ул.Аделя Кутуя</p></td>
        <td style="width: 409px;">Кардиолог
            <p>Психотерапия</p>
            <p>ПРием хирурга</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>8)Барс Мед</p><img width="200" height="120" src="photo/clinic/БарсМед.jpg"><p>Клиника, диагностический центр ул.Хусаина Мавлютова,2</p></td>
        <td style="width: 409px;">МРТ
            <p>Прием детского врача</p>
            <p>Ортопедия</p>
            <a href="">Узнать цены</a></td>
    </tr>
    <tr>
        <td style="width: 409px;"><p>9)Наран</p><img width="200" height="120" src="photo/clinic/Наран.jpg"><p>Клиника, медцентр Площадь Габдуллы Тукая</p></td>
        <td style="width: 409px;">Прием детского врача
            <p>Дерматология</p>
            <p>Анализ крови</p>
            <a href="">Узнать цены</a></td>
    </tr>
</table>
</body>
</html>
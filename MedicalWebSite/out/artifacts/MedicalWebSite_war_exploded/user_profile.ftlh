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

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG" alt = "wait"></p>

<h2 style="text-align: center;"><span style="color: #00ccff;">Личный кабинет</span></h2>

<form action="personal" method="post">

    Имя: <input type="text" name="firstname" required/><br/><br/>
    Фамилия: <input type="text" name="lastname" required/><br/><br/>
    Пол:
    <input type="radio" name="sex" value="male"/>Мужской
    <input type="radio" name="sex" value="female"/>Женский<br/><br/>
    <label for="date">Дата рождения: </label><input type="date" id="date" name="date"/></br></br>
    Номер телефона: <input type="number" name="number"/><br/><br/>
    Город: <input type="text" name="town"><br/><br/>
    О себе: <textarea type="text" class="text" name="aboutyourself"></textarea>

    <br/><br/>

    <div class="formname">
        <input type="submit" name="submit" id="submit" value="Изменить" />
    </div>

</form>

</body>
</html>
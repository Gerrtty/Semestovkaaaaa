<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>Forum</title>
</head>

<body>
<br>

<style>body{
    background: url("photo/background.png"); background-size: 100% 220%;
}</style>

<style>
    .outline {
        border: 2px solid black;
        padding: 0 10px;
    }
</style>

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG"  alt = "wait"></p>
<h4 style="text-align: right;">
    <a href="profile">Profile</a>
</h4>
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

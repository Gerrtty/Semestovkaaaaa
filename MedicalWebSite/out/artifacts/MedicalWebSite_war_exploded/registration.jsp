<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 17.11.19
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Med.Care.Registration</title>

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

<%--    <script>--%>

<%--        $.get("registration", function(responseText) {--%>
<%--            $("#correct_email").text("Random number = 34");--%>
<%--        });--%>


<%--    </script>--%>

</head>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<body>

<style>body{
    background: url("photo/background.png");
    background-size: 100% 220%;
}</style>

<p style="text-align: center;"><img width = "450" height = "70" src="photo/siteName.PNG", alt = "wait"></p>

<h2 style="text-align: center;"><span style="color: #00ccff;">РЕГИСТРАЦИЯ</span></h2>

<div style="font-family:Comfortaa;font-size: 120%; margin: 20px 0px 0px 30px"><br/>

    <form enctype="multipart/form-data" method="post">

        <p style="font-size: small">Загрузите вашу фотографию</p>
        <p style=""><input type="file" name="photo" multiple accept="image/*,image/jpeg"><br/><br/>
        </p>

    </form>

    <form action="registration" method="post">

        <img wight="150" height="150" src="photo/userPhoto.png">


                Имя: <input type="text" name="firstName" id="firstName" required/><br/><br/>
                Фамилия: <input type="text" name="lastName" id="lastName" required/><br/><br/>

                <style>
                    .block_for_input {
                        width: 200px;
                    }
                    .block_for_input input {
                        width: 100%;
                    }
                    #block_check {
                        height: 5px;
                        margin-top: 5px;
                        transition: 1s;
                    }
                </style>

                Пол:
                <input type="radio" name="sex" value="male"/>Мужской
                <input type="radio" name="sex" value="female"/>Женский<br/><br/>

                Логин(почта): <input type="text" name="email" required/><br/>
                <div id="correct_email"></div>

            <div class="block_for_input">

                Пароль: <input type="password" id="input_test" name="pass" required onkeyup='passcorr()'/>

                <script>
                    function passcorr() {
                        var pass = document.getElementById("input_test").value;
                        var button = document.getElementById("submit");
                        var p = /^[a-zA-Z0-9]+$/;
                        if (p.test(pass))
                        {
                            err = ""; // ничего не пишем так как вывести нужно только одно Успешно
                            // button.disabled = false;
                        } else {
                            // button.disabled = true;
                            err = "<p color=\'red\'> Введены недопустимые символы! Разрешены только латинские буквы и цифры!</p>";
                            document.getElementById("err").innerHTML=err;
                            exit; // прерываем так как есть ошибка
                        }
                        if (pass.length>=6&&pass.length<=20){
                            // button.disabled = false;
                            err = "<p color=\'green\'>Успешно!</p>";
                        } else {
                            // button.disabled = true;
                            err = "<p color=\'red\'>Пароль неверной длины. Пароль должен быть не менее 6 и не более 20 символов!</p>";
                            document.getElementById("err").innerHTML=err;
                            exit;
                        }
                        document.getElementById("err").innerHTML=err;
                    }
                </script>
                <div id="block_check"></div>
            </div>

            Повторите пароль: <input type = "password" id="2pass" name="confirm_pass" required></br></br>

            <script>
                var s_letters = "qwertyuiopasdfghjklzxcvbnm"; // Буквы в нижнем регистре
                var b_letters = "QWERTYUIOPLKJHGFDSAZXCVBNM"; // Буквы в верхнем регистре
                var digits = "0123456789"; // Цифры
                var specials = "!@#$%^&*()_-+=\|/.,:;[]{}"; // Спецсимволы
                var input_test = document.getElementById('input_test');//получаем поле
                var block_check = document.getElementById('block_check');//получаем блок с индикатором
                input_test.addEventListener('keyup', function(evt){
                    var input_test_val = input_test.value;//получаем значение из поля
                    var is_s = false; // Есть ли в пароле буквы в нижнем регистре
                    var is_b = false; // Есть ли в пароле буквы в верхнем регистре
                    var is_d = false; // Есть ли в пароле цифры
                    var is_sp = false; // Есть ли в пароле спецсимволы
                    for (var i = 0; i < input_test_val.length; i++) {
                        /* Проверяем каждый символ пароля на принадлежность к тому или иному типу */
                        if (!is_s && s_letters.indexOf(input_test_val[i]) != -1) {
                            is_s = true;
                        }
                        else if (!is_b && b_letters.indexOf(input_test_val[i]) != -1) {
                            is_b = true;
                        }
                        else if (!is_d && digits.indexOf(input_test_val[i]) != -1) {
                            is_d = true;
                        }
                        else if (!is_sp && specials.indexOf(input_test_val[i]) != -1) {
                            is_sp = true;
                        }
                    }
                    var rating = 0;
                    if (is_s) rating++; // Если в пароле есть символы в нижнем регистре, то увеличиваем рейтинг сложности
                    if (is_b) rating++; // Если в пароле есть символы в верхнем регистре, то увеличиваем рейтинг сложности
                    if (is_d) rating++; // Если в пароле есть цифры, то увеличиваем рейтинг сложности
                    if (is_sp) rating++; // Если в пароле есть спецсимволы, то увеличиваем рейтинг сложности
                    /* Далее идёт анализ длины пароля и полученного рейтинга, и на основании этого готовится текстовое описание сложности пароля */
                    if (input_test_val.length < 6 && rating < 3) {
                        block_check.style.width = "10%";
                        block_check.style.backgroundColor = '#e7140d';
                    }
                    else if (input_test_val.length < 6 && rating >= 3) {
                        block_check.style.width = "50%";
                        block_check.style.backgroundColor = '#ffdb00';
                    }
                    else if (input_test_val.length >= 8 && rating < 3) {
                        block_check.style.width = "50%";
                        block_check.style.backgroundColor = '#ffdb00';
                    }
                    else if (input_test_val.length >= 8 && rating >= 3) {
                        block_check.style.width = "100%";
                        block_check.style.backgroundColor = '#61ac27';
                    }
                    else if (input_test_val.length >= 6 && rating == 1) {
                        block_check.style.width = "10%";
                        block_check.style.backgroundColor = '#e7140d';
                    }
                    else if (input_test_val.length >= 6 && rating > 1 && rating < 4) {
                        block_check.style.width = "50%";
                        block_check.style.backgroundColor = '#ffdb00';
                    }
                    else if (input_test_val.length >= 6 && rating == 4) {
                        block_check.style.width = "100%";
                        block_check.style.backgroundColor = '#61ac27';
                    }
                });

            </script>

        <div class="formname">

            <input id="checkbox" type="checkbox" name="checkbox" onchange="document.getElementById('submit').disabled = !this.checked;" />

            <label for="checkbox">Настоящим подтверждаю, что я согласен на обработку персональных данных</label><br/>

            <input type="submit" disabled="disabled" name="submit" id="submit" value="Зарегестрироваться" />

        </div>

        </form>
</div>

</body>
</html>
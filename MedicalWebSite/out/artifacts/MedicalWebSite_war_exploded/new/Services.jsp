<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>clinic</title>
</head>
<br>
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
    }
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




<p style="text-align: right"><a href="main" class="button7">Главная страница</a></p></br>
<p style="text-align: right"><a href="1clinic" class="button7">Вернуться к клинике</a></p></br>


<h1 id="name_of_clinic"><strong>${name_of_clinic}</strong></h1>
<p id="address">${address}</p>
<img width="500" height="300" src="photo/clinic/be%20healfy.jpg">

<table>
    <tr>
        <td>
            <h3 id="name_of_service_1">${service}</h3>
            <h3 id="name_of_service_2">${service}</h3>
            <h3 id="name_of_service_3">${service}</h3>
        </td>
        <td>
            <h3 id="price1">${price}</h3>
            <h3 id="price2">${price}</h3>
            <h3 id="price3">${price}</h3>
        </td>
    </tr>
</table>

</div>
</body>
</html>
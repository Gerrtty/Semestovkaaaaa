<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of clinics</title>
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

<h2 style="text-align: center">List of clinics</h2>

<p style="text-align: right"><a href="mainPage" class="button7">Main page</a></p></br>

<form style="text-align: center" method="post" action="search">
    <input type="search" name="search">
    <input type="submit" value="Search" placeholder="Input service name">
    <p>Where price: </p>
    <input style="width: 10%" type="text" name="price">
</form>

<ul>
    <#list buildings as building>
        <li>
            <a href="/clinic?id=${building.id}">${building.name}</a><br/>
            <img width="200" height="120" src="${building.path}">
            <p>Town ${building.address.town} st. ${building.address.street} number ${building.address.number}</p>
        </li>
    </#list>

</ul>
</body>
</html>
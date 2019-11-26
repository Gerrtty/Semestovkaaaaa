<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of clinics</title>
</head>
<body>

<h2 style="text-align: center">List of clinics</h2>

<form style="text-align: center" method="post" action="search">
    <input type="search" name="search">
    <input type="submit" value="Search" placeholder="Input service name">
    <p>Where price: </p>
    <input style="width: 10%" type="text" name="price">
</form>

<ul>
    <#list buildings as building>
        <li>
            <p>${building.name}</p>
            <img width="200" height="120" src="${building.path}">
            <p>Town ${building.address.town} st. ${building.address.street} number ${building.address.number}</p>
        </li>
    </#list>

</ul>
</body>
</html>
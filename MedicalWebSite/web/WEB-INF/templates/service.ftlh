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

<style>
    div{
        border-width:1;
        border-color: rgb(190,190,190);
        border-style: solid;
    }
</style>

<header>
    <p style="text-align: right"><a href="mainPage" class="button7">Main page</a></p></br>
    <p style="text-align: right"><a href="services" class="button7">Back</a></p>

    <h1 style="text-align: center">${building.name}</h1><br/>

    <h2 style="text-align: center">${serviceBuilding.description}</h2>

    <h3 style="text-align: center">Price: ${serviceBuilding.price}</h3>

    <ul>
        <h3>Reviews: </h3>
    </ul>

    <ul>
        <#list reviews as review>
            <li>
                <div>
                    <div>
                        <p style="font-weight: bold">Name: ${review.user_name} Date: ${review.text.date}</p>
                    </div>
                    <div>
                        <p>${review.text.text}</p>
                    </div>
                </div>
            </li>
        </#list>
    </ul>

    <ul>
        <form method="post" action="addComment">
            <input type="submit" value="Add review">
        </form>
    </ul>

</header>

</body>
</html>
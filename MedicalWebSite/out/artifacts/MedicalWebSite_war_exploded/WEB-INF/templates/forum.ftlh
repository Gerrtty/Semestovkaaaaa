<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of themes</title>
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
        background: #c8eeeb;
    }</style>


<style>
    div{
        border-width:1;
        border-color: rgb(190,190,190);
        border-style: solid;
    }
</style>

<h2 style="text-align: center">Forum</h2>

<p style="text-align: right"><a href="mainPage" class="button7">Main page</a></p></br>

<ul>
    <#list themes as theme>
        <li>
            <div>
                <div>
                    <p style="font-weight: bold">Name: ${theme.user_name}</p>
                </div>
                <div>
                    <p>
                        <a href="/theme?theme_id=${theme.id}">${theme.title}</a>
                    </p>
                </div>
            </div>
        </li>
    </#list>

</ul>

<ul>
    <form style="text-align: center" method="get" action="addTheme">
        <input type="submit" class="button7" value="Add theme">
    </form>
</ul>

</body>
</html>
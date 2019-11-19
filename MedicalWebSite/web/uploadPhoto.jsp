<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 19.11.19
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="setPhoto" method="post" enctype="multipart/form-data">
    <input name="description" type="text"><br>
    <input name="data" type="file"><br>
    <input type="submit"><br>
</form>
</body>
</html>
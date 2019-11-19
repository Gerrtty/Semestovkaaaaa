<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 19.11.19
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>

<body>

<center>


    <form method="post" action="uploadServlet" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="firstName" size="50"/></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="lastName" size="50"/></td>
            </tr>
            <tr>
                <td>Portrait Photo: </td>
                <td><input type="file" name="photo" size="50"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>

    </form>
</center>
</body>
</html>
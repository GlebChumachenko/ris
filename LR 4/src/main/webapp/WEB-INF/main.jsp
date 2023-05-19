<%--
  Created by IntelliJ IDEA.
  User: misha
  Date: 02.04.2023
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<form action="/RIS4/main" method="post">
    <label for="textMessage">Text of message:</label>
    <input type="text" id="textMessage" name="textMessage" pattern="[0-9]*" required><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

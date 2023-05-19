<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All developers</title>
    <style><%@include file="/WEB-INF/css/developers.css" %></style>
</head>
<body>
<table>
    <tr>
        <th>Category</th>
        <th>Model</th>
        <th>Price</th>
        <th>Is in stock</th>
    </tr>
    <c:forEach var="developer" items="${developers}">
        <tr>
            <td>${developer.fullName}</td>
            <td>${developer.position}</td>
            <td>${developer.workExperience}</td>
            <td>${developer.coreTechnology}</td>
            <td>${developer.salary}</td>
        </tr>
    </c:forEach>
</table>
<hr />
<h2>Filter developers by price</h2>
<form action="developers" method="get">
    <p>Position:</p>
    <input type="text" name="position">
    <input type="submit" value="Filter">
</form>
<hr />
<h2>Find highest paid developer</h2>
<form action="highestPaidDeveloper" method="get">
    <input type="submit" value="Find">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/19/2023
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Caculator</h3>

<form action="/caculator" method="post">
    <input type="number" name="first" required>
    <input type="number" name="second" required>

    <button value='+' name="calculate">Addition</button>
    <button value='-' name="calculate">Subtraction</button>
    <button value='*' name="calculate">Multiplication</button>
    <button value='/' name="calculate">Division</button>
</form>
    <p>${mess}</p>
    <p>${result}</p>



</body>
</html>

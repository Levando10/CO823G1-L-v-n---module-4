
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/caculator" method="get">
    <fieldset>
        <legend>Exchange Money</legend>
        <label for="rate">Rate : <input id="rate" type="number" placeholder="Enter Rate" name="rate"></label> <br>
        <label for="us">USD : <input id="us" type="number" placeholder="Enter USD" name="usd"></label>

        <button type="submit">Exchange</button> </br>
        VND : ${vnd} Đ
    </fieldset>
</form>

</body>
</html>

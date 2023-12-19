<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/18/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/dictionary" method="get">
    <fieldset>
        <legend>Từ điển tiếng anh</legend>
       <label for="eng">Nhập từ cần dịch <input id="eng" type="text" name="eng"> </label>

        <button type="submit">Dịch</button> </br>
        Kết quả : ${result}
    </fieldset>
</form>

</body>
</html>

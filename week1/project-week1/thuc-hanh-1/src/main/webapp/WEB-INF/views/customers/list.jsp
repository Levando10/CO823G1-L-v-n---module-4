<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/18/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>

<h1>
    List Customer
</h1>
There are ${requestScope.list.size()} customer(s) in list.

<table class="table table-hover">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>description</th>
    </tr>

    <c:forEach items="${list}" var="items">
        <tr>
            <td><c:out value="${items.id}"/></td>
            <td><c:out value="${items.name}"/></td>
            <td><c:out value="${items.description}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


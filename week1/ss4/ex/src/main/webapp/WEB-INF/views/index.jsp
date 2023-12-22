<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/22/2023
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bold {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Settings</h1>
<c:if test="${mess != null}">
   <h3> ${mess}</h3>
</c:if>
<table border="1" cellspacing="5" cellpadding="5">
    <form:form  action="/update" method="post" modelAttribute="email">
        <tr>
            <td >Languages</td>
            <td><form:select path="language" items="${languages}"/></td>
        </tr>
        <tr>
            <td >Page Size: Show</td>
            <td><form:select path="page" items="${sizes}"/> emails per page</td>
        </tr>
        <tr>
            <td >Spams filter:</td>
            <td><form:checkbox path="spam" value="true"/> Enable spams filter</td>
        </tr>
        <tr>
            <td >Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
                <form:button>Update</form:button>
            </td>
            <td>
                <form:button type="button">Close</form:button>
            </td>
        </tr>
    </form:form>
</table>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/22
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${arr}" var="item">
    快递号:${item.getE_id()}&nbsp;&nbsp;&nbsp;状态:${item.getStatus()}<br>
</c:forEach>



</body>
</html>

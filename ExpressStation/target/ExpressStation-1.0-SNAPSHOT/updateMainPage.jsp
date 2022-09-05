<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/28
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: slategray;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: black 1px solid;
            padding:1px;

        }
    </style>

    <script>
        function update(v){
            window.location.href = "toUpdateSelfExpress?eId="+v+"&admId=${user.getU_id()}";
        }
    </script>

</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getName()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>快递编号</td>
            <td>电话号码</td>
            <td>地址</td>
            <td>取件码</td>
            <td>状态</td>
            <td>修改</td>
        </tr>

        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getE_id()}</td>
                <td>${item.getU_phone()}</td>
                <td>${item.getAddress()}</td>
                <td>${item.getCode()}</td>
                <td>${item.getStatus()}</td>
                <td><button style="color: chocolate" onclick="update(${item.getE_id()})">修改</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

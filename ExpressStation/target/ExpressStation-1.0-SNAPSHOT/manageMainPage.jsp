<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/21
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>管理员用户主界面</title>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: #FBAB7E;
            background-image: linear-gradient(62deg, #FBAB7E 0%, #F7CE68 100%);

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
            background-color: #85FFBD;
            background-image: linear-gradient(45deg, #85FFBD 0%, #FFFB7D 100%);
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
        function userToExpress(){
            window.location.href = "userToExpress?admId=${user.getU_id()}";
        }

        function expressToUser(){
            window.location.href = "expressToUser?admId=${user.getU_id()}";
        }

        function search(){
            let v = document.getElementById("fileId").value;
            window.location.href = "userSearchServlet?v="+v+"&id=${user.getU_id()}";
        }

        function del(v){
            let isdel = confirm("是否删除"+v+ "用户?");
            if(isdel){
                window.location.href = "delUserServlet?v="+v+"&id=${user.getU_id()}";
            }
            else return;
        }

        function update(v){
            window.location.href = "toUpdateUser?userId="+v+"&admId=${user.getU_id()}";
        }
    </script>


</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: red">${user.getName()}</span><br>
        编号:<span style="color: red">${user.getU_id()}</span><br>
        <a href="login.jsp" ><font color="black">退出登录</font></a>

    </div>
    <tr bgcolor="black">
        <td width="100%">
            <a href="#"><font color="white" onclick="userToExpress()">快递管理</font></a>
            <a href="#"><font color="white" onclick="expressToUser()">用户管理</font></a>
        </td>
    </tr>

</div>


<div id="search">
    <div id="inner_s">

        <input type="text" style="font-size: 20px; height: 26px;width: 190px" id="fileId" placeholder="输入用户ID">
        <button  style="font-size: 18px; height: 28px;" onclick="search()">查询</button>
    </div>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>用户id</td>
            <td>用户名字</td>
            <td>用户电话</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getU_id()}</td>
                <td>${item.getName()}</td>
                <td>${item.getPhone()}</td>
                <td><button style="color: chocolate" onclick="update(${item.getU_id()})">修改</button></td>
                <td><button style="color: chocolate"onclick="del(${item.getU_id()})">删除</button></td>

            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

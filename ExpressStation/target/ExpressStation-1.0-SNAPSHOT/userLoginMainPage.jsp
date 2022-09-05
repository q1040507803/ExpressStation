<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/28
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>用户登录主界面</title>
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
        function search(){
            window.location.href = "selfExpressSearchServlet?id=${user.getU_id()}";
        }

        function add(){
            window.location.href = "toUpAddSelfExpress?admId=${user.getU_id()}";
        }

        function update(){
            window.location.href = "toUpdateMainPage?admId=${user.getU_id()}";
        }

        function del(v){
            let isdel = confirm("是否删除"+v+ "快递?");
            if(isdel){
                window.location.href = "delSelfExpress?v="+v+"&id=${user.getU_id()}";
            }
            else return;
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
</div>


<div id="search">
    <div id="inner_s">
        <button  style="font-size: 18px; height: 28px;" onclick="search()">查询</button>
        <button  style="font-size: 18px; height: 28px;" onclick="add()">添加</button>
        <button  style="font-size: 18px; height: 28px;" onclick="update()">修改</button>

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
            <td>删除</td>
        </tr>

        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getE_id()}</td>
                <td>${item.getU_phone()}</td>
                <td>${item.getAddress()}</td>
                <td>${item.getCode()}</td>
                <td>${item.getStatus()}</td>
                <td><button style="color: chocolate" onclick="del(${item.getE_id()})">删除</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/23
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #a{
        width: 70%;
        height: 600px;
        background-color: lemonchiffon;
        margin-left: 240px;
        margin-top: 50px;
        position: absolute;
    }
    #b{
        margin-left: 300px;
        margin-top: 100px;
    }
    input{
        margin-top: 15px;
        margin-left: 70px;
        font-size: 30px;
        color: red;
        font-family: 华文新魏;
    }
    button{
        background-color: azure;
        width: 100px;
        height: 25px;
        font-size: 20px;
        font-family: 华文新魏;
        margin-left: 110px;
    }
    span{
        margin-left: 100px;
        color: red;
    }

</style>
<script>
    function goMainPage(){
        window.location.href = "goMainPage?=${admId}";
    }
    function sureUp(){
        let a=document.getElementById("a1").value;
        let b=document.getElementById("a2").value;
        let c=document.getElementById("a3").value;
        let d=document.getElementById("a4").value;
        window.location.href = "upStu?admId=${admId}&userId=${userId}&a="+a+"&b="+b+"&c="+c+"&d="+d;
    }
</script>

<body>
<div id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">成绩修改界面</div>
    <span>学生：&nbsp;${userId}</span><br>
    <span>管理员：&nbsp;${admId}</span>

    <div id = "b">
        母猪产后护理：&nbsp;&nbsp;<input type="text" id="a1"><br>
        <br>
        母猪养殖学：&nbsp;&nbsp;<input type="text" id="a2"><br>
        <br>
        母猪接生原理：&nbsp;&nbsp;<input type="text" id="a3"><br>
        <br>
        公猪配种学：&nbsp;&nbsp;<input type="text" id="a4"><br>
        <br>
        <button onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;
        <button onclick="sureUp()">确认修改</button>
    </div>
</div>

</body>
</html>

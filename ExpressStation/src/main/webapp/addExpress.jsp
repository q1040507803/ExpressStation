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
        background-color: #8BC6EC;
        background-image: linear-gradient(135deg, #8BC6EC 0%, #9599E2 100%);
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
        color: black;
    }
    button{
        background-color: azure;
        width: 100px;
        height: 25px;
        font-size: 20px;
        margin-left: 110px;
    }
    span{
        margin-left: 100px;
        color: black;
    }

</style>
<script>
    function goMainPage(){
        window.location.href = "goMainPage?=${admId}";
    }
    function sureUp(){
        if(${shelves.getNum()}=0){
            confirm("货架已满");
        }
        else{
            let a=document.getElementById("a1").value;
            let b=document.getElementById("a2").value;
            let c=document.getElementById("a3").value;
            let d=document.getElementById("a4").value;
            let e=document.getElementById("a5").value;
            window.location.href = "addExpressServlet?admId=${admId}&userId=${userId}&a="+a+"&b="+b+"&c="+c+"&d="+d+"&e="+e;
        }
    }
</script>

<body>
<div id="a">
    <div style="font-size: 40px;margin-top: 40px;margin-left: 70px">快递入库</div>
    <span>管理员：&nbsp;${admId}</span>

    <div id = "b">
        <input type="text" id="a1" placeholder="快递编号"><br>
        <br>
        <input type="text" id="a2" placeholder="用户名"><br>
        <br>
        <input type="text" id="a3" placeholder="电话号码"><br>
        <br>
        <input type="text" id="a4" placeholder="地址"><br>
        <br>
        <input type="text" id="a5" placeholder="取件码"><br>
        <br>
        <button onclick="goMainPage()">回主界面</button>&nbsp;&nbsp;
        <button onclick="sureUp()">确认</button>
    </div>
</div>

</body>
</html>

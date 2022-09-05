<%--
  Created by IntelliJ IDEA.
  User: 齐鹏程
  Date: 2021/12/21
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        #frame_{
            width: 70%;
            height: 600px;
            background-color: #8BC6EC;
            background-image: linear-gradient(135deg, #8BC6EC 0%, #9599E2 100%);
            margin-left: 240px;
            margin-top: 50px;
            position: absolute;
        }
        #inner_{
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
</head>
<body>
<div id="frame_">
    <div id="inner_">
        <input type="text" id="u_id" placeholder="用户id"><br>
        <input type="password" id="u_pwd" placeholder="密码"><br>
        <button id="btn01">重置</button>
        <button id="btn02">登录</button>
        <span id="error" style="color: red">${error}</span>
        <script>
            let btn001 = document.getElementById("btn02");
            btn001.onclick=function (){
                //1.获取id查看是否为空
                let id_str = document.getElementById("u_id").value;
                if(id_str==null || id_str==""){
                    document.getElementById("error").innerHTML="用户不能为空";
                    return;
                }
                //2.获取密码查看是否为空
                let pwd_str = document.getElementById("u_pwd").value;
                if(pwd_str==null || pwd_str==""){
                    document.getElementById("error").innerHTML="密码不能为空";
                    return;
                }
                //开始访问服务器
                window.location.href = "login?u_id="+id_str+"&u_pwd="+pwd_str;
            }
        </script>
    </div>
</div>
</body>
</html>

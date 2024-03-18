<%--
  Created by IntelliJ IDEA.
  User: baiyuhong
  Date: 2018/9/29
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>校园点餐后台登陆</title>

    <style type="text/css">
        *{padding:0px;margin:0px;}
        body{font-family:Arial, Helvetica, sans-serif;background:url(${pageContext.request.contextPath }/images/grass.jpg) no-repeat;font-size:12px; background-size: 100%}
        img{border:0;}
        .lg{width:468px;height:468px;margin:100px auto;background: rgba(0, 0, 0, 0.2) no-repeat; border-radius: 20px;}
        .lg_top{ height:200px;width:468px;     font-size: 40px;
            text-align: center;
            color: #fff;
            line-height: 200px;}
        .lg_main{width:400px;height:160px;margin:0 25px;}
        .lg_m_1{width:310px;height:100px;padding:60px 20px 20px 55px; color: #fff;font-size: 20px}
        .ur{height:37px;line-height:37px;border:0;color:#666;width:236px;margin:4px 2px;background:url(${pageContext.request.contextPath }/images/user.png) no-repeat;padding-left:10px;font-size:12px;font-family:Arial, Helvetica, sans-serif;}
        .pw{height:37px;line-height:37px;border:0;color:#666;width:236px;margin:4px 2px;background:url(${pageContext.request.contextPath }/images/password.png) no-repeat;padding-left:10px;font-size:12px;font-family:Arial, Helvetica, sans-serif;}
        .bn{width:330px;height:72px;background:#00BCD4 no-repeat;border:0;display:block;font-size:18px;color:#FFF;font-family:Arial, Helvetica, sans-serif;font-weight:bolder;cursor:pointer;}
        .lg_foot{height:80px;width:330px;padding: 6px 68px 0 68px;}
    </style>

</head>

<body>

<div class="lg">
    <form action="/login" method="POST">
        <div class="lg_top">校园点餐后台登录</div>
        <div class="lg_main">
            <div class="lg_m_1">
                ${error}
                <div>账号：<input name="name" id="name" placeholder="用户名" value="" class="ur" /></div>
                <div>密码：<input name="password" id="password" placeholder="密码" type="password" value="" class="pw" /></div>
            </div>
        </div>
        <div class="lg_foot">
            <input type="submit" value="登录" class="bn" />
        </div>
    </form>
</div>

</body>
</html>


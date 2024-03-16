<%--
  Created by IntelliJ IDEA.
  User: baiyuhong
  Date: 2018/11/19
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../../foreinclude/foreHander.jsp"%>

<!--=============================================
=            breadcrumb area         =
=============================================-->

<div class="breadcrumb-area pt-15 pb-15">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <!--=======  breadcrumb container  =======-->

                <div class="breadcrumb-container">
                    <nav>
                        <ul>
                            <li class="parent-page"><a href="index.html">Home</a></li>
                            <li>ApplyCourier</li>
                        </ul>
                    </nav>
                </div>

                <!--=======  End of breadcrumb container  =======-->
            </div>
        </div>
    </div>
</div>

<!--=====  End of breadcrumb area  ======-->

<!--=============================================
=            Login Register page content         =
=============================================-->

<div class="page-section mb-50">
    <div class="container">

        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-3 col-xs-12">


            </div>
            <div class="col-sm-12 col-md-12 col-xs-12 col-lg-6 mb-30">
                <!-- Login Form s-->
<%--                <form class="loginForm">--%>

                    <div class="login-form">
                        <div class="loginErrorMessageDiv">
                            <div class="alert alert-danger">
                                <span class="errorMessage">${msg}</span>
                            </div>
                        </div>
                        <h4 class="login-title">申请成为配送员</h4>

                        <div class="row">
                            <div class="col-md-12 col-12 mb-20">
                                <label>姓名</label>
                                <input name="name" id="name" class="mb-0" type="name" placeholder="请输入姓名">
                            </div>
                            <div class="col-md-12 col-12 mb-20">
                                <label>电话</label>
                                <input name="phone" id="phone" class="mb-0" type="number" placeholder="请输入电话">
                            </div>
                            <div class="col-md-12 col-12 mb-20">
                                <label>身份证号码</label>
                                <input name="idnumber" id="idnumber" class="mb-0" type="name" placeholder="请输入身份证号码">
                            </div>
                            <div class="col-md-12 col-12 mb-20">
                                <label>申请理由</label>
                                <textarea name="reason" id="reason" class="mb-0" type="name" placeholder="请输入申请理由"></textarea>
                            </div>

                            <div class="col-md-12">
                                <button class="register-button mt-0">申请</button>
                            </div>

                        </div>
                    </div>

<%--                </form>--%>
            </div>

        </div>
    </div>
</div>

<!--=====  End of Login Register page content  ======-->
<script src="${pageContext.request.contextPath}/js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("div.loginErrorMessageDiv").hide()

        $(".register-button").on("click",function (){
            $.get(
                "foreIsLogin",
                function(result) {
                    if (result=="true"){ //已登录则加入购物车
                        let name = $("#name").val();
                        let phone = $("#phone").val();
                        let idnumber = $("#idnumber").val();
                        let reason = $("#reason").val();
                        if(name == "" || phone == "" || idnumber == "" || reason == ""){
                            $("span.errorMessage").html("请将内容填写完整");
                            $("div.loginErrorMessageDiv").show();
                        }else if(!/^1[34578]\d{9}$/.test(phone)){
                            $("span.errorMessage").html("手机号填写有误");
                            $("div.loginErrorMessageDiv").show();
                        }else if(!/^[1-9]\d{5}(19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[Xx\d]$/.test(idnumber)){
                            $("span.errorMessage").html("身份证号码填写有误");
                            $("div.loginErrorMessageDiv").show();
                        }else{
                            $.get(
                                "/customer/saveApplicationDocuments",
                                {
                                    name:name,
                                    phone: phone,
                                    idnumber:idnumber,
                                    reason: reason
                                },
                                function(data){
                                    if(data=="success"){
                                        alert("提交申请成功");
                                    }else{
                                        alert("提交申请失败");
                                    }
                                }
                            );
                        }
                    } else {  //未登录
                        $("span.errorMessage").html("请先登录");
                    }
                }
            );//登陆结束
        })
    })
</script>

<%@ include file="../../foreinclude/foreFooter.jsp"%>

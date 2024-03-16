<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baiyuhong
  Date: 2018/10/4
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../../include/publicMeta.jsp"%>
<%@include file="../../include/publicHeader.jsp"%>
<%@include file="../../include/publicMenu.jsp"%>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
        <span class="c-gray en">&gt;</span>
        配送管理
        <span class="c-gray en">&gt;</span>
        配送员申请列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a> </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="r">共有数据：<strong>${totals}</strong> 条</span>
            </div>
            <table class="table table-border table-bordered table-bg" id="mytable">
                <thead>
                <tr>
                    <th scope="col" colspan="10">配送员申请列表</th>
                </tr>
                <tr class="text-c">
                    <th width="">ID</th>
                    <th>姓名</th>
                    <th>联系方式</th>
                    <th>身份证号码</th>
                    <th>申请理由</th>
                    <th>状态</th>
                    <th width="150">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="order">
                <tr class="text-c">
                    <td>${order.id}</td>
                    <td>${order.name}</td>
                    <td>${order.phone}</td>
                    <td>${order.idnumber}</td>
                    <td>${order.reason}</td>
                    <td>
                        <c:if test="${order.status==0}">
                            申请中
                        </c:if>
                        <c:if test="${order.status==1}">
                            已同意
                        </c:if>
                        <c:if test="${order.status==2}">
                            已拒绝
                        </c:if>
                    </td>
                    <td>
<%--                        <a title="查看" href="javascript:;"--%>
<%--                           onclick="orderIetm_list('订单详情','seeOrderItem?oid=${order.id}','1','500','310')"--%>
<%--                           class="ml-5" style="text-decoration:none">--%>
<%--                            <span class="label label-success radius">查看详情</span>--%>
<%--                        </a>--%>
                        <c:if test="${order.status==0}">
                            <a class="operate-btn agree ml-5" data-id="${order.id}" style="text-decoration:none">
                                <span class="label label-success radius">同意</span>
                            </a>
                            <a class="operate-btn reject ml-5" data-id="${order.id}" style="text-decoration:none">
                                <span class="label radius">拒绝</span>
                            </a>
                        </c:if>
<%--                        <c:if test="${order.status==1}">--%>
<%--                            <a class="operate-btn agreeCancel ml-5" data-id="${order.id}" style="text-decoration:none">--%>
<%--                                <span class="label radius">取消同意</span>--%>
<%--                            </a>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${order.status==2}">--%>
<%--                            <a class="operate-btn rejectCancel ml-5" data-id="${order.id}" style="text-decoration:none">--%>
<%--                                <span class="label radius">取消拒绝</span>--%>
<%--                            </a>--%>
<%--                        </c:if>--%>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </article>
        <article class="cl pd-20">
            <%@include file="../adminPage.jsp"%>
        </article>
    </div>
</section>

<%@include file="../../include/publicFooter.jsp"%>

<script type="text/javascript">
    /*
        参数解释：
        title	标题
        url		请求的url
        id		需要操作的数据id
        w		弹出层宽度（缺省调默认值）
        h		弹出层高度（缺省调默认值）
    */
    /*管理员-编辑*/
    function orderIetm_list(title,url,id,w,h){
        layer_show(title,url,w,h);
    }

    $(function (){
        $(".operate-btn").on("click",function (){
            var ele = $(this)
            var status = 0
            var id = ele.attr("data-id")
            if(ele.hasClass("agree")){
                status = 1
            }else if (ele.hasClass("reject")){
                status = 2
            }else if(ele.hasClass("agreeCancel") || ele.hasClass("rejectCancel")){
                status = 0
            }
            $.ajax({
                url:"aApproved",
                data: {
                    id: id,
                    status:status
                },
                type:"get",
                success:function(data){
                    if(data=="success"){
                        alert("操作成功");
                        location.replace(location.href);
                    }else{
                        alert("操作失败");
                    }
                }
            });
        })
    })


</script>

</body>
</html>

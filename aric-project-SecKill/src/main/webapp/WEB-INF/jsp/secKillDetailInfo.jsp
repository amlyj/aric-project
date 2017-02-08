<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--标签库--%>
<%@include file="../template/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%--静态引用--%>
    <%@include file="../template/header.jsp" %>
    <title>秒杀详情</title>
    <script type="application/javascript" src="/static/lib/jquery/jquery.cookie.min.js"></script>
    <script type="application/javascript" src="/static/lib/jquery/jquery.countdown.min.js"></script>
</head>
<body>
<%--内容显示--%>
<div class="container">
    <div class="panel panel-default">
        <div class="panel panel-heading text-center">
            <h2>秒杀详情</h2>
        </div>
        <div class="panel panel-body">
            <h2 class="text-danger">
                <%--显示时间图标--%>
                <span class="glyphicon glyphicon-time"></span>
                    <span class="glyphicon" id="secKill-box">

                    </span>
            </h2>
        </div>
    </div>
</div>

<%--支付弹出层--%>
<div id="secKillPayModel" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input id="payNumber" type="text" name="payNumber" class="form-control"
                               placeholder="请输入金额"/>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <span id="payNumberVal" class="glyphicon"></span>
                <button type="button" id="payNumberBtn" class="btn btn-info">
                    <span class="glyphicon glyphicon-phone"></span>Submit
                </button>
            </div>
        </div>

    </div>


</div>
</body>
<script type="application/javascript" src="/static/js/secKill.js">
    $(function () {
        SecKill.detail.init({
            stockId=${secKillDetail.stock.stockId},
                startTime=${secKillDetail.stock.endTime.time},
            endTime=${secKillDetail.stock.endTime.time},//.time 把Date转换为Long 类型

        })
    })
</script>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--标签库--%>
<%@include file="../template/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <%--静态引用--%>
  <%@include file="../template/header.jsp" %>
  <title>秒杀详情</title>
    <%--cookie 插件--%>
  <script type="application/javascript" src="/static/lib/jquery/jquery.cookie.min.js"></script>
   <%--倒计时插件--%>
  <script type="application/javascript" src="/static/lib/jquery/jquery.countdown.min.js"></script>
    <script type="application/javascript" src="/static/js/secKill.js"></script>
</head>
<body>
${stock}
<%--内容显示--%>
<div class="container">
  <div class="panel panel-default">
    <div class="panel panel-heading text-center">
      <h2>${stock.name}</h2>
    </div>
    <div class="panel panel-body">
      <h2 class="text-danger text-center">
        <%--显示时间图标--%>
        <span id="glyphicon-time" class="glyphicon glyphicon-time"></span>
          <span class="glyphicon" id="secKill-box"></span>
      </h2>
    </div>
  </div>
</div>

<%--支付弹出层--%>
<div id="secKillValModel" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title text-center">
          <span class="glyphicon glyphicon-user"></span>
        </h3>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-xs-8 col-xs-offset-2">
            <input id="username-rep" type="text" name="username-rep" class="form-control"
                   placeholder="用户确认，请输入用户名"/>
          </div>
        </div>

      </div>
      <div class="modal-footer">
        <span id="username-rep-Val" class="glyphicon"></span>
        <button type="button" id="username-rep-Btn" class="btn btn-info">
          <span class="glyphicon glyphicon-user"></span>Submit
        </button>
      </div>
    </div>

  </div>


</div>
</body>


<script type="application/javascript">
  $(function () {
    //.time 把Date转换为Long 类型
    SecKill.detail.init({
            stockId:${stock.stockId},
            startTime:${stock.startTime.time},
            endTime:${stock.endTime.time},
            username:'${currentUser.username}'
            })
  })
</script>
</html>

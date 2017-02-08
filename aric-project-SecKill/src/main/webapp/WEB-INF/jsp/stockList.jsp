<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--标签库--%>
<%@include file="../template/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%--静态引用--%>
    <%@include file="../template/header.jsp" %>

    <title>秒杀列表</title>
</head>
<body>
<%--页面显示--%>
<div class="container text-center">
    <div class="panel panel-default">
        <div class="panel panel-heading ">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel panel-body">
            <table class="table table-bordered">
                <thead style="background-color: #9acfea">
                <tr>
                    <th >ID</th>
                    <th>名称</th>
                    <th>库存数量</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>描述</th>
                    <th>详情</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="stock" items="${stocks}">
                    <tr>

                        <td>${stock.stockId}</td>
                        <td>${stock.name}</td>
                        <td>${stock.number}</td>
                        <td><fmt:formatDate value="${stock.startTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                        <td><fmt:formatDate value="${stock.endTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                        <td>${stock.describe}</td>
                        <td>
                            <a class="btn btn-info" href="/${stock.stockId}/stock" target="_blank">详情</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</div>

</body>
</html>

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
<c:choose>
    <c:when test="${fun:length(secKillDetails) > 0}">
        <div class="container">
            <div class="panel panel-default">
                <div class="panel panel-heading text-center">
                    <h2>秒杀详情</h2>
                </div>
                <div class="panel panel-body">
                    <table class="table text-center">
                        <thead>
                        <tr>
                            <th>
                            <td>商品名称</td>
                            <td>秒杀状态</td>
                            <td>购买者</td>
                            <td>秒杀时间</td>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="secKillDetail" items="${secKillDetails}">
                            <tr>
                                <th>
                                <td>${secKillDetail.stock.name}</td>
                                <td>
                                <c:choose>
                                    <c:when test="${secKillDetail.state==0}">成功！</c:when>
                                    <c:when test="${secKillDetail.state==1}">发货！</c:when>
                                    <c:when test="${secKillDetail.state==2}">签收！</c:when>
                                </c:choose>

                                </td>
                                <td>${secKillDetail.account.username}</td>
                                <td><fmt:formatDate value="${secKillDetail.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                                </th>

                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div>

        </div>
    </c:when>
    <c:otherwise>
        <h2 style="text-align: center">没有秒杀记录</h2>
    </c:otherwise>
</c:choose>


</body>
</html>

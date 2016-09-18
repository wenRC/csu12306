<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>计划管理</h1>
    </div>
    <div>
        <form action="plan?function=query" method="post">
            按&nbsp&nbsp&nbsp<input type="radio" name="id" value="plan">计划代码
            <input type="radio" name="id" value="train">车次代码&nbsp&nbsp&nbsp进行查询：
            <input type="text" name="queryId">
            <input type="submit" name="planQuery" value="查询"/>
        </form>
    </div>
    <br/>
    <div>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>计划代码</th>
                <th>车次代码</th>
                <th>车厢号</th>
                <th>比较</th>
                <th>车站</th>
                <th colspan="3">操作</th>
            </tr>
            <%--<c:if test="${sessionScope.planList[0]!=null}">--%>
                <c:forEach items="${sessionScope.planList}" var="plan">
                    <tr>
                        <td>${plan.planid}</td>
                        <td>${plan.trainid}</td>
                        <td>${plan.chexiang}</td>
                        <td>${plan.compare}</td>
                        <td>${plan.stationname}</td>
                        <td><a href="plan?function=modify&planid=${plan.planid}">修改</a></td>
                        <td><a href="plan?function=delete&planid=${plan.planid}">删除</a></td>
                        <td><a href="to?function=diaodu&planid=${plan.planid}">执行</a></td>
                    </tr>
                </c:forEach>
            <%--</c:if>--%>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<h1 align="center">列车修改</h1>
</br></br></br>
<form action="trainModify" class="form-horizontal" role="form" method="get">
<table class="table table-hover">
  <thead>
  <tr>
    <th>车次代码</th>
    <th>始发站</th>
    <th>终点站</th>
    <th>出发时间</th>
    <th>到达时间</th>
    <th>历时</th>
    <th>里程</th>
    <th>无座票数量</th>
    <th>列车类型</th>
    <th>&nbsp&nbsp</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td><input type="text" name="trainId" value="${sessionScope.train.trainId}" readonly="readonly"></td>
    <td><input type="text" name="from" value="${sessionScope.train.from}"></td>
    <td><input type="text" name="to" value="${sessionScope.train.to}"></td>
    <td><input type="text" name="fromTime" value="${sessionScope.train.fromTime}"></td>
    <td><input type="text" name="toTime" value="${sessionScope.train.toTime}"></td>
    <td><input type="text" name="last" value="${sessionScope.train.last}"></td>
    <td><input type="text" name="distance" value="${sessionScope.train.distance}"></td>
    <td><input type="text" name="noseatnumber" value="${sessionScope.train.noseatnumber}"></td>
    <td><input type="text" name="type" value="${sessionScope.train.type}"></td>
    <td><button type="submit" class="btn btn-primary">确认修改</button></td>
  </tr>
  </tbody>
</table>
</form>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
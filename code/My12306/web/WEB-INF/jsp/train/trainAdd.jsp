<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<h1 align="center">列车添加</h1>
</br></br></br>
<form action="trainAdd" class="form-horizontal" role="form" method="get">
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
      <td><input name="trainId" type="text"></td>
      <td><input name="from" type="text"></td>
      <td><input name="to" type="text"></td>
      <td><input name="fromTime" type="text"></td>
      <td><input name="toTime" type="text"></td>
      <td><input name="last" type="text"></td>
      <td><input name="distance" type="text"></td>
      <td><input name="noseatnumber" type="text"></td>
      <td><input name="type" type="text"></td>
      <td><button type="submit" class="btn btn-primary">添加</button></td>
    </tr>
    </tbody>
  </table>
</form>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
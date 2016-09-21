<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div align="center">
  <h1>列车修改</h1>
  </br>
  <form action="trainModify" class="form-horizontal" role="form" method="get">
  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="trainId" class="col-sm-3 control-label">车次代码</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="trainId" name="trainId" value="${sessionScope.train.trainId}" readonly>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="from" class="col-sm-3 control-label">始发站</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="from" name="from" value="${sessionScope.train.from}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="to" class="col-sm-3 control-label">终点站</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="to" name="to" value="${sessionScope.train.to}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="fromTime" class="col-sm-3 control-label">出发时间</label>
    <div class="col-sm-9">
      <input type="datetime" class="form-control" id="fromTime" name="fromTime" value="${sessionScope.train.fromTime}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="toTime" class="col-sm-3 control-label">到达时间</label>
    <div class="col-sm-9">
      <input type="datetime" class="form-control" id="toTime" name="toTime" value="${sessionScope.train.toTime}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="last" class="col-sm-3 control-label">历时</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="last" name="last" value="${sessionScope.train.last}">
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="distance" class="col-sm-3 control-label">里程</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" id="distance" name="distance" value="${sessionScope.train.distance}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="noseatnumber" class="col-sm-3 control-label">无座票数量</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" id="noseatnumber" name="noseatnumber" value="${sessionScope.train.noseatnumber}" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="type" class="col-sm-3 control-label">列车类型</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="type" name="type" value="${sessionScope.train.type}" required>
    </div>
  </div>
    </br>
  <div class="form-group" style="width: 400px;margin: 10px;">
    <div class="col-sm-offset-1 col-sm-10">
      <button type="submit" class="btn btn-default">提交</button>
    </div>
  </div>
</form>
</div>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
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
</br>
<div align="center">
  <form action="trainAdd" class="form-horizontal" role="form" method="get">
  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="trainId" class="col-sm-3 control-label">车次代码</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" id="trainId" name="trainId" placeholder="请输入车次代码" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="from" class="col-sm-3 control-label">始发站</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="from" name="from" placeholder="请输入始发站" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="to" class="col-sm-3 control-label">终点站</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="to" name="to" placeholder="请输入终点站" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="fromTime" class="col-sm-3 control-label">出发时间</label>
    <div class="col-sm-9">
      <input type="datetime-local" class="form-control" id="fromTime" name="fromTime" placeholder="请输入出发时间" step="0.5" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="toTime" class="col-sm-3 control-label">到达时间</label>
    <div class="col-sm-9">
      <input type="datetime-local" class="form-control" id="toTime" name="toTime" placeholder="请输入到达时间" step="0.5" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="last" class="col-sm-3 control-label">历时</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="last" name="last" placeholder="请输入历时">
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="distance" class="col-sm-3 control-label">里程</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" id="distance" name="distance" placeholder="请输入里程" required>
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="noseatnumber" class="col-sm-3 control-label">无座票数量</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" id="noseatnumber" name="noseatnumber" placeholder="请输入无座票数量">
    </div>
  </div>

  <div class="form-group" style="width: 400px;margin: 10px auto;">
    <label for="distance" class="col-sm-3 control-label">列车类型</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="type" name="type" placeholder="列车类型">
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
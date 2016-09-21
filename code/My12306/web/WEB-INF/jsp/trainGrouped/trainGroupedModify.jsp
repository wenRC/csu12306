<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/20
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div align="center">
  <h1>列车编组修改</h1>
  </br>
  <form action="trainGroupedModify" class="form-horizontal" role="form" method="get">
    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="trainGroupedId" class="col-sm-3 control-label">列车编组编号</label>
      <div class="col-sm-9">
        <input type="number" class="form-control" id="trainGroupedId" name="trainGroupedId" value="${sessionScope.trainGrouped.trainGroupedId}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="trainId" class="col-sm-3 control-label">车次代码</label>
      <div class="col-sm-9">
        <input type="number" class="form-control" id="trainId" name="trainId" value="${sessionScope.trainGrouped.trainId}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="chexiang" class="col-sm-3 control-label">车厢号</label>
      <div class="col-sm-9">
        <input type="number" class="form-control" id="chexiang" name="chexiang" value="${sessionScope.trainGrouped.chexiang}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="seatType" class="col-sm-3 control-label">车厢座席类型</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="seatType" name="seatType" value="${sessionScope.trainGrouped.seatType}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="seatNumber" class="col-sm-3 control-label">车厢座席数量</label>
      <div class="col-sm-9">
        <input type="number" class="form-control" id="seatNumber" name="seatNumber" value="${sessionScope.trainGrouped.seatNumber}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="chexiangType" class="col-sm-3 control-label">车厢类型</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="chexiangType" name="chexiangType" value="${sessionScope.trainGrouped.chexiangType}">
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

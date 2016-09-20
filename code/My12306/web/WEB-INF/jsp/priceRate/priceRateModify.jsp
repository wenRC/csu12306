<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/20
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div align="center">
  <h1>票价率修改</h1>
  </br>
  <form action="priceRateModify" class="form-horizontal" role="form" method="get">
    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="priceRateId" class="col-sm-3 control-label">票价率编号</label>
      <div class="col-sm-9">
        <input type="number" class="form-control" id="priceRateId" name="priceRateId" value="${sessionScope.priceRate.priceRateId}" readonly>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="ticketType" class="col-sm-3 control-label">票种</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="ticketType" name="ticketType" value="${sessionScope.priceRate.ticketType}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="priceRate" class="col-sm-3 control-label">票价率</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="priceRate" name="priceRate" value="${sessionScope.priceRate.priceRate}" required>
      </div>
    </div>

    <div class="form-group" style="width: 400px;margin: 10px;">
      <div class="col-sm-offset-1 col-sm-10">
        <button type="submit" class="btn btn-default">提交</button>
      </div>
    </div>
  </form>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
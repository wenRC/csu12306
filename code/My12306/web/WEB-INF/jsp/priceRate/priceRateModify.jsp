<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/20
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<h1 align="center">票价率修改</h1>
</br></br></br>
<form action="priceRateModify" class="form-horizontal" role="form" method="get">
  <table class="table table-hover">
    <thead>
    <tr>
      <th>票价率编号</th>
      <th>票种</th>
      <th>票价率</th>
      <th>&nbsp&nbsp</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><input type="text" name="priceRateId" value="${sessionScope.priceRate.priceRateId}" readonly="readonly"></td>
      <td><input type="text" name="ticketType" value="${sessionScope.priceRate.ticketType}"></td>
      <td><input type="text" name="priceRate" value="${sessionScope.priceRate.priceRate}"></td>
      <td><button type="submit" class="btn btn-primary">确认修改</button></td>
    </tr>
    </tbody>
  </table>
</form>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
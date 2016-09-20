<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/20
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<h1 align="center">票价率查询</h1>
</br></br></br>
<form action="priceRateQuery" class="form-horizontal" role="form" method="get">
  <div class="form-group">
    <label  class="col-sm-5 control-label">票种:</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="ticketType" placeholder="票种">
    </div>
      <button type="submit" class="btn btn-primary">查询</button>
  </div>
</form>
</br></br>
<c:if test="${sessionScope.priceRates[0]!=null}">
  <c:forEach items="${sessionScope.priceRates}" var="priceRate">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>票价率编号</th>
        <th>票种</th>
        <th>票价率</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>${priceRate.priceRateId}</td>
        <td>${priceRate.ticketType}</td>
        <td>${priceRate.priceRate}</td>
        <td><a href="priceRate?function=modify&ticketType=${priceRate.ticketType}"><button class="btn btn-defalut">修改</button></a></td>
      </tr>
      </tbody>
    </table>
  </c:forEach>
</c:if>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>

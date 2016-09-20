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
<h1 align="center">列车编组查询</h1>
</br></br></br>
<form action="trainGroupedQuery" class="form-horizontal" role="form" method="get">
  <div class="form-group">
    <label  class="col-sm-4 control-label">车次代码:</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="trainId" placeholder="车次代码">
    </div>
    <label  class="col-sm-1 control-label">车厢号:</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="chexiang" placeholder="车厢号">
    </div>
    <div class="col-sm-3">
      <button type="submit" class="btn btn-primary">查询</button>
    </div>
  </div>
</form>
</br></br>
<c:if test="${sessionScope.trainGroupeds[0]!=null}">
  <c:forEach items="${sessionScope.trainGroupeds}" var="trainGrouped">
    <table class="table table-hover">
      <thead>
      <tr>
        <th>列车编组编号</th>
        <th>车次代码</th>
        <th>车厢号</th>
        <th>车厢座席类型</th>
        <th>车厢座席数量</th>
        <th>车厢类型</th>
        <th>操作</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>${trainGrouped.trainGroupedId}</td>
        <td>${trainGrouped.trainId}</td>
        <td>${trainGrouped.chexiang}</td>
        <td>${trainGrouped.seatType}</td>
        <td>${trainGrouped.seatNumber}</td>
        <td>${trainGrouped.chexiangType}</td>
        <td><a href="trainGrouped?function=modify&trainId=${trainGrouped.trainId}&chexiang=${trainGrouped.chexiang}"><button class="btn btn-defalut">修改</button></a></td>
        <td><a href="trainGrouped?function=delete&trainId=${trainGrouped.trainId}&chexiang=${trainGrouped.chexiang}"><button class="btn btn-defalut">删除</button></a></td>
      </tr>
      </tbody>
    </table>
  </c:forEach>
</c:if>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
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
<%
  String message =(String)session.getAttribute("message");
  if(message!=null && !"".equals(message)){
%>
<script type="text/javascript">
  alert("<%=message%>");
</script>
<% session.setAttribute("message","");}%>
<h1 align="center">列车编组查询</h1>
</br></br>
<div align="center">
  <form action="trainGroupedQuery" class="form-horizontal" role="form" method="get" id="form">
    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="trainId" class="col-sm-3 control-label">车次代码</label>
      <div class="col-sm-9">
        <select id="trainId" name="trainId" class="form-control">
          <c:forEach items="${sessionScope.trainGroupeds1}" var="trainGroupeds">
            <option value="${trainGroupeds.trainId}" name="${trainGroupeds.trainId}">
                ${trainGroupeds.trainId}
            </option>
          </c:forEach>
        </select>
        </div>
      </div>
    <div class="form-group" style="width: 400px;margin: 10px auto;">
      <label for="chexiang" class="col-sm-3 control-label">车次代码</label>
      <div class="col-sm-9">
        <select id="chexiang" name="chexiang" class="form-control">
          <c:forEach items="${sessionScope.trainGroupeds1}" var="trainGroupeds">
            <option value="${trainGroupeds.chexiang}" name="${trainGroupeds.chexiang}">
                ${trainGroupeds.chexiang}
            </option>
          </c:forEach>
        </select>
      </div>
    </div>
    </br>
    <div class="col-sm-offset-1 col-sm-10">
      <button type="submit" class="btn btn-default">查询</button>
    </div>
  </form>
</div>
</br></br></br></br></br>
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
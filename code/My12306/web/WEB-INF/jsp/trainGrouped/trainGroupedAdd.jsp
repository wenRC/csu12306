<%--
  Created by IntelliJ IDEA.
  User: war
  Date: 2016/9/20
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<h1 align="center">列车编组添加</h1>
</br></br></br>
<form action="trainGroupedAdd" class="form-horizontal" role="form" method="get">
  <table class="table table-hover">
    <thead>
    <tr>
      <th>列车编组编号</th>
      <th>车次代码</th>
      <th>车厢号</th>
      <th>车厢座席类型</th>
      <th>车厢座席数量</th>
      <th>车厢类型</th>
      <th>&nbsp&nbsp</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><input type="text" name="trainGroupedId"></td>
      <td><input type="text" name="trainId"></td>
      <td><input type="text" name="chexiang"></td>
      <td><input type="text" name="seatType"></td>
      <td><input type="text" name="seatNumber"></td>
      <td><input type="text" name="chexiangType"></td>
      <td><button type="submit" class="btn btn-primary">添加</button></td>
    </tr>
    </tbody>
  </table>
</form>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>

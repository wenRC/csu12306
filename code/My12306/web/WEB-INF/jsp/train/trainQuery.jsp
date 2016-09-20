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
<%--<script type="text/javascript">--%>
  <%--function verify(){--%>
    <%--//获取form标签元素--%>
    <%--var form = document.getElementById("form");--%>
    <%--//获取form下元素下所有input标签--%>
    <%--var input = form.getElementsByTagName("input");--%>
    <%--if(input.value=null||input.value==""){--%>
      <%--alert("车次代码不能为空");--%>
      <%--return false;--%>
    <%--}--%>
    <%--return true;--%>
  <%--}--%>
<%--</script>--%>
     <h1 align="center">列车查询</h1>
</br></br></br>
     <form action="trainQuery" class="form-horizontal" role="form" method="get" id="form">
       <div class="form-group">
         <label  class="col-sm-5 control-label">车次代码</label>
         <div class="col-sm-2">
           <input type="number" class="form-control" name="trainId" placeholder="请输入车次代码" required>
         </div>
         <div class="col-sm-3">
           <button type="submit" class="btn btn-default">查询</button>
         </div>
       </div>
     </form>
</br></br>
<c:if test="${sessionScope.trains[0]!=null}">
  <c:forEach items="${sessionScope.trains}" var="train">
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
         <th>操作</th>
         <th>操作</th>
       </tr>
       </thead>
       <tbody>
         <tr>
           <td>${train.trainId}</td>
           <td>${train.from}</td>
           <td>${train.to}</td>
           <td>${train.fromTime}</td>
           <td>${train.toTime}</td>
           <td>${train.last}</td>
           <td>${train.distance}</td>
           <td>${train.noseatnumber}</td>
           <td>${train.type}</td>
           <td><a href="train?function=modify&trainId=${train.trainId}"><button class="btn btn-defalut">修改</button></a></td>
           <td><a href="train?function=delete&trainId=${train.trainId}"><button class="btn btn-defalut">删除</button></a></td>
         </tr>
       </tbody>
     </table>
  </c:forEach>
</c:if>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>

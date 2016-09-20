<%--
  Created by IntelliJ IDEA.
  User: 温 睿诚
  Date: 2016/9/20/0020
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<div id="content">
    <div id="search">
        <form action="/searchPiao" method="post" role="form" class="form-inline">
            <div class="form-group">
                <input type="text" class="form-control" id="fromplace" name="fromplace" placeholder="${sessionScope.from}" disabled/></div>
            <div class="form-group"><input type="text" class="form-control" id="toplace" name="toplace"
                                           placeholder="${sessionScope.to}" disabled/></div>
            <div class="form-group"><input type="date" class="form-control" id="date" placeholder="出发日"/></div>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </form>
    </div>

</div>
<br/>
<div id="title">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>车次</th>
            <th>出发站</th>
            <th>到达站</th>
            <th>出发时间</th>
            <th>历时</th>
            <th>一等座</th>

            <th>其他</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.yupiaos}" var="yupiao" varStatus="status">
            <tr>
                <td>${yupiao.trainId}</td>
                <td>${yupiao.from}</td>
                <td>${yupiao.to}</td>
                <td>${yupiao.time}</td>
                <td>${yupiao.last}</td>
                <td>${yupiao.seatNo}</td>

                <td>-</td>
                <td><a href="/gai?index=${status.index}"  ><input type="button" value="改签" class="btn btn-default" <c:if test="${yupiao.trainId==sessionScope.trainId}">disabled </c:if>/></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>

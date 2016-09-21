<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
    <%--<link rel="stylesheet" href="../css/management.css" type="text/css">--%>
    <style type="text/css">
        #station{
            padding-right:30px;}
        #result table tr th,td{
            padding:10px 20px 10px 20px;}
    </style>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="addStation.jsp" method="get">
                <div id="station" align="right">
                    您输入的车站是:
                </div>
                <div id="result" align="center">
                    <table class="table table-hover">
                        <tr>
                            <th>线路编号</th>
                            <th>车次代码</th>
                            <th>车站名</th>
                            <th>到站时间</th>
                            <th>停留时间</th>
                            <th>里程</th>
                        </tr>
                        <c:forEach var="line" items="${sessionScope.lines}">
                            <tr>
                                <td><a href="/getLine?lineId=${line.lineId}">${line.lineId}</a></td>
                                <td>${line.trainId}</td>
                                <td>${line.stationName}</td>
                                <td>${line.fromTime}</td>
                                <td>${line.lastTime}</td>
                                <td>${line.distance}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
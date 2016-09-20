<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/management.css" type="text/css">
    <style type="text/css">
        #station{
            padding-right:30px;}
        #result table tr th,td{
            padding:10px 20px 10px 20px;}
    </style>
</head>
<body>
<link rel="stylesheet" type="text/css" href="../css/head.css">
<div id="header" style="background: darkslategrey;color: #BDBDBD;">
    <a href="../station/stationManagement.jsp">车站管理</a>
    |
    <a href="../line/lineManagement.jsp">线路管理</a>
    |
    <a href="../trainsFormat/trainsFormat.jsp">列车编组</a>
    |
    <a href="../quDuan/quDuanQuery.jsp">票价旅程区段管理</a>|
    <a href="../diYuanDiJianLv/rateManagement.jsp">递远递减率管理</a>|
    <a href="../bussinessCount/index.jsp">财务统计</a>|
    <a href="../plan/seatAnnounce.jsp">调度管理</a>|
    <a href="../fareRateManage/fareRateManage.jsp">票价率</a>|
    <a href="../plan/planManage.jsp">计划信息</a>|
    <a href="../trainsManage/trainsManage.jsp">列车管理</a></div>
<div id="content">

    <div id="body">
        <div id="left">
            <ul>
                <li class="function" id="function_first"><a href="/management">全部功能</a></li>
                <li class="function"><a href="/stationManagement">车站管理</a></li>
                <li class="function"><a href="/lineManagement">线路管理</a></li>
                <li class="function"><a href="/diyuandijianManagement">递远递减率管理</a></li>
            </ul>
        </div>
        <div id="right">
            <form action="addStation.jsp" method="get">
                <div id="station" align="right">
                    您输入的车次是:${line.trainId}
                </div>
                <div id="result" align="center">
                    <table>
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
</body>
</html>
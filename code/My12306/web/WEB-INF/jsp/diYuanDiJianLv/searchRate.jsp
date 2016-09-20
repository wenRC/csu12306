<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:40
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
<div id="content">
    <div id="top"><img src="../img/head.png"></div>
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
                <div id="result" align="center">
                    <table>
                        <tr>
                            <th>递远递减率编号</th>
                            <th>里程区段From</th>
                            <th>里程区段To</th>
                            <th>递减率</th>
                            <th>票价率</th>
                        </tr>
                        <c:forEach var="rate" items="${sessionScope.diYuanDiJianLvs}">
                        <tr>
                            <td><a href="/dYDJ?dYDJId=${rate.dYDJId}">${rate.dYDJId}</a></td>
                            <td>${rate.dYDJFrom}</td>
                            <td>${rate.dYDJTo}</td>
                            <td>${rate.dYDJRate}</td>
                            <td>${rate.priceRate}</td>
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

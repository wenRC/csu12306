<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/19
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>席位信息</h1>
    </div>
    <div>
        <form action="diaodu?function=query" method="post">
            <table cellpadding="10">
                <tr>
                    <td>车次：</td>
                    <td><input type="text" name="trainid"></td>
                    <td>车厢：</td>
                    <td><input type="text" name="chexiang"></td>
                    <td><input type="submit" value="查询"></td>
                </tr>
            </table>
        </form>
    </div>
    <br/>
    <a href="diaodu?function=queryAll">显示所有计划</a>
    <br/>
    <div>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>席位代码</th>
                <th>车次</th>
                <th>日期</th>
                <th>车厢号</th>
                <th>座位号</th>
                <th>乘车区间起始站</th>
                <th>乘车区间终到站</th>
                <th>售票状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.seatList}" var="seat">
                <tr>
                    <td>${seat.seatid}</td>
                    <td>${seat.trainid}</td>
                    <td>${seat.date}</td>
                    <td>${seat.chexiang}</td>
                    <td>${seat.seatno}</td>
                    <td>${seat.from}</td>
                    <td>${seat.to}</td>
                    <td>${seat.status}</td>
                    <td><a href="diaodu?function=modify">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <div>
        <form action="diaodu?function=seatCount" method="post">
            <table cellpadding="10">
                <tr>
                    <td><input type="radio" name="seatNumber">已售席位</td>
                    <td><input type="radio" name="seatNumber">未售席位</td>
                    <td><input type="radio" name="seatNumber">总席位</td>
                    <td><input type="submit" value="查询"></td>
                    <td>数量：<input type="text" name="seatCount"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


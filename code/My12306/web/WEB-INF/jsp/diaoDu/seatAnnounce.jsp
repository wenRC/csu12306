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
        <form action="diaodu?function=query" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="checi" class="col-sm-3 control-label">车次</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="checi" name="trainid" min="1" max="100"
                           placeholder="请输入车次" required>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="chexiang" class="col-sm-3 control-label">车厢</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="chexiang" name="chexiang" min="1" max="100"
                           placeholder="请输入车厢" required>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px;">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
            </div>
        </form>
    </div>
    <br>
    <div>
        <form action="diaodu?function=seatCount" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="keyun" class="col-sm-3 control-label">客运统计</label>
                <div class="col-sm-9">
                    <select id="keyun" name="seatCountMethod" class="form-control">
                        <option value="yishou">已售席位</option>
                        <option value="weishou">未售席位</option>
                        <option value="zong">总席位</option>
                    </select>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="seatNumber" class="col-sm-3 control-label">席位数量</label>
                <div class="col-sm-9">
                    <input id="seatNumber" type="text" class="form-control" name="seatCount"
                           value="${sessionScope.seatCount}" readonly>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px;">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-default">统计</button>
                </div>
            </div>
        </form>
    </div>
    <br/>
    <div>
        <c:if test="${requestScope.success!=null}">
            <div class="alert alert-success" role="alert" style="margin: 50px">
                <strong>${requestScope.success}</strong>
            </div>
        </c:if>
        <c:if test="${requestScope.fail!=null}">
            <div class="alert alert-warning" role="alert" style="margin: 50px">
                <strong>${requestScope.fail}</strong>
            </div>
        </c:if>
    </div>
    <br/>
    <div>
        <table class="table table-hover" style="width: 90%;margin: auto">
            <thead>
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
            </thead>
            <tbody>
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
                    <td><a href="diaodu?function=modify&seatid=${seat.seatid}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


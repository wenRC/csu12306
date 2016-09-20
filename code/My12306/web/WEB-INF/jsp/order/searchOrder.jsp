<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<div id="content">
    <div class="alert alert-success" role="alert" style="margin-left: 50px;margin-right: 50px">
        <strong>${sessionScope.infomsg}</strong>
    </div>
    <form role="form" class="form-inline" action="/searchOrderByTime" method="post">
        <div class="form-group">

            <select class="form-control" id="select" name="select">
                <option value="1">按订票日期</option>
                <option value="2">按出行日期</option>
            </select>
            <input type="date" class="form-control" name="date" id="date" placeholder="日期"/>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </div>
    </form>

    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>订单号</th>
                <th> 车次
                </th>
                <th> 席位
                </th>
                <th> 出发站
                </th>
                <th> 到达站
                </th>
                <th>出发时间</th>
                <th> 历时
                </th>
                <th> 票种
                </th>
                <th> 价格
                </th>
                <th>乘车人</th>
                <th>订票日期</th>
                <th>订单状态</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${sessionScope.piaowus}" var="pw" varStatus="status">
                <tr>
                    <td >${pw.orderId}</td>
                    <td >${pw.trainId}</td>
                    <td >${pw.cheXiang}车${pw.seatNo}</td>
                    <td >${pw.from}</td>
                    <td >${pw.to}</td>
                    <td >${pw.date}</td>
                    <td >${pw.last}</td>
                    <td >${pw.ticketType}</td>
                    <td >${pw.price}元</td>
                    <td >${user.username}</td>
                    <td >${pw.orderTime}</td>
                    <td >${pw.orderStatus}</td>
                    <td >

                        <a href="/tuipiao?index=${status.index}"> <input type="button" value="退票" class="btn btn-default"<c:if test="${pw.orderStatus.equals('已退票')}">disabled</c:if>/></a>
                        <a href="/forward?to=qupiao" ><input type="button" value="取票" class="btn btn-default" <c:if test="${pw.orderStatus.equals('已退票')}">disabled</c:if>/></a>
                        <a href="/gaiqian?index=${status.index}"> <input type="button" value="改签" class="btn btn-default"<c:if test="${pw.orderStatus.equals('已退票')}">disabled</c:if>/></a>
                        <a href="/pay?index=${status.index}" <c:if test="${!pw.orderStatus.equals('未支付')}">hidden</c:if>> <input type="button" value="支付" class="btn btn-default"/></a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>

    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
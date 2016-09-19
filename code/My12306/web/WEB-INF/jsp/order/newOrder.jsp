<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
		<div id="title">
				<table  class="table table-hover">
					<thead>
					<tr>
					<td>订单号</td>
					<td>车次</td>
					<td>席位</td>
					<td>出发站</td>
					<td>到达站</td>
					<td>出发时间</td>
					<td>历时</td>
					<td>票种</td>
					<td>价格</td>
					<td>乘车人</td>
					</tr>
					</thead>
				<tbody>
					<tr>
					<td>${sessionScope.order.orderId}</td>
					<td>${sessionScope.seat.trainid}</td>
					<td>${sessionScope.seat.chexiang}车${sessionScope.seat.seatno}</td>
					<td>${sessionScope.seat.from}</td>
					<td>${sessionScope.seat.to}</td>
					<td>${sessionScope.seat.date}</td>
					<td>${sessionScope.piao.last}</td>
					
					<td>${sessionScope.ticket.ticketType}</td>
					<td>${sessionScope.ticket.price}元</td>
					<td>${sessionScope.user.username}</td></tr>
				</tbody>
			</table>
			</div>
<div class="alert alert-info" role="alert">
	<strong>下单成功，请尽快支付。</strong>
</div>
			<a href="/payNow"> <button type="button" class="btn btn-default">支付</button></a>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
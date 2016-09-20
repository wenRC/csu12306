<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
		<div id="title">
				<table class="table table-hover">
					<thead>
	<tr>
					<td >车次</td>
	
					<td >出发站</td>
					<td >到达站</td>
					<td >出发时间</td>
					<td >历时</td>
					<td >票种</td>
					<td >价格</td>
					<td >乘车人</td>
	</tr>
		</thead>
					<tbody>
					<tr>
					<td>${sessionScope.piao.trainId}</td>
					
					<td>${sessionScope.piao.from}</td>
					<td>${sessionScope.piao.to}</td>
					<td>${sessionScope.piao.date}&nbsp;${sessionScope.piao.time}</td>
					<td>${sessionScope.piao.last}</td>
					
					<td>一等座</td>
					<td class="label-primary">${sessionScope.piao.price}元</td>
					<td>${sessionScope.user.username}</td>
					</tr>
					</tbody>
			</table>
			</div>
					
			<a href="/forward?to=searchPiao" class="col-lg-offset-5"><button type="button" class="btn btn-default" >上一步</button></a>
			<a href="/newOrder" ><button type="button" class="btn btn-default">提交订单</button></a>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
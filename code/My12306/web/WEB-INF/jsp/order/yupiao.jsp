<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp"%>
<div id="content">
			<div id="search">
				<form action="/searchOrder" method="post" role="form" class="form-inline">
					<div class="form-group">
					<input type="text" class="form-control" id="fromplace" placeholder="出发地" />
					<input type="text" class="form-control" id="toplace" placeholder="目的地"/>
					<input type="date" class="form-control" id="date" placeholder="出发日"/>
					<input type="button" class="btn btn-primary" value="查询"  />
					</div>
				</form>
			</div>
			<br />
			<div id="title">
				<table  class="table table-hover">
					<thead>
						<tr>
						<th >车次</th>
						<th >出发站</th>
						<th >到达站</th>
						<th >出发时间</th>
						<th >历时</th>
						<th >一等座</th>
						<th >二等座</th>
						<th >其他</th>
						<th >备注</th>
						</tr>
					</thead>
					<tbody>
					<tr>
					<td >G6160</td>
					<td >广州南</td>
					<td >广州北</td>
					<td >17:17</td>
					<td >00:17</td>
					<td >2</td>
					<td >无</td>
					<td >-</td>
					<td ><a href="newOrder.html"><input type="button" value="预定" class="btn btn-default"/></a></td></tr>
					<tr>
					<td>G638</td>
					<td>广州南</td>
					<td>广州北</td>
					<td>17:01</td>
					<td>00:17</td>
					<td>无</td>
					<td>无</td>
					<td>-</td>
					<td><input type="button" value="预定" class="btn btn-default" disabled/></td></tr>
					</tbody>
				</table>
			</div>

		</div>
</div> <%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
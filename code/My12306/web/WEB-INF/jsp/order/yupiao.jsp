<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<div id="content">
    <div id="search">
        <form action="/searchPiao" method="post" role="form" class="form-inline">
            <div class="form-group">
                <input type="text" class="form-control" id="fromplace" name="fromplace" placeholder="出发地"/></div>
            <div class="form-group"><input type="text" class="form-control" id="toplace" name="toplace"
                                           placeholder="目的地"/></div>
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
        <c:forEach items="${sessionScope.yupiaos}" var="yupiao">
            <tr>
                <td>${yupiao.trainId}</td>
                <td>${yupiao.from}</td>
                <td>${yupiao.to}</td>
                <td>${yupiao.time}</td>
                <td>${yupiao.last}</td>
                <td>${yupiao.seatNo}</td>

                <td>-</td>
                <td><a href="newOrder.html"><input type="button" value="预定" class="btn btn-default"/></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
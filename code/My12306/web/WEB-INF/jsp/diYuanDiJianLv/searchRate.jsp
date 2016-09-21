<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="addStation.jsp" method="get">
                <div id="result" align="center">
                    <table class="table table-hover">
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
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
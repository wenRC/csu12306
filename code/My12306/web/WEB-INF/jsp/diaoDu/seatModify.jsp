<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/19
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>席位修改</h1>
    </div>
    <div>
        <form action="diaodu?function=submitModify" method="post">
            <table cellpadding="5">
                <tr>
                    <td>席位代码</td>
                    <td><input type="text" name="seatid" value="${sessionScope.seat.seatid}"></td>
                </tr>
                <tr>
                    <td>车次</td>
                    <td>
                        <select id="trainid" name="trainid">
                            <c:forEach items="${sessionScope.trainList}" var="train">
                                <option value="${train.trainId}" name="${train.trainId}"
                                        <c:if test="${sessionScope.seat.trainid==train.trainId}"><c:out
                                                value="selected"/></c:if>>
                                        ${train.trainId}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>日期</td>
                    <td><input type="text" name="date" value="${sessionScope.seat.date}"></td>
                </tr>
                <tr>
                    <td>车厢号</td>
                    <td><input type="text" name="chexiang" value="${sessionScope.seat.chexiang}"></td>
                </tr>
                <tr>
                    <td>座位号</td>
                    <td><input type="text" name="seatno" value="${sessionScope.seat.seatno}"></td>
                </tr>
                <tr>
                    <td>乘车区间起始站</td>
                    <td><input type="text" name="from" value="${sessionScope.seat.from}"></td>
                </tr>
                <tr>
                    <td>乘车区间终到站</td>
                    <td><input type="text" name="to" value="${sessionScope.seat.to}"></td>
                </tr>
                <tr>
                    <td>售票状态</td>
                    <td>
                        <select name="status">
                            <option value="未售" <c:if test="${sessionScope.seat.status.equals('未售')}">
                                <c:out value="selected"/>
                            </c:if>>未售
                            </option>
                            <option value="已售" <c:if test="${sessionScope.plan.compare.equals('已售')}">
                                <c:out value="selected"/>
                            </c:if>>已售
                            </option>
                            <option value="不可售" <c:if test="${sessionScope.plan.compare.equals('不可售')}">
                                <c:out value="selected"/>
                            </c:if>>不可售
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="seatModifySubmit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


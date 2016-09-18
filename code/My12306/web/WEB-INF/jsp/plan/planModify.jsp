<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>计划修改</h1>
    </div>
    <div>
        <form action="plan?function=submitModify&planid=${sessionScope.plan.planid}" method="post">
            <table cellpadding="5">
                <tr>
                    <td>计划代码</td>
                    <td><input type="text" name="planid" value="${sessionScope.plan.planid}" readonly></td>
                </tr>
                <tr>
                    <td>车次代码</td>
                    <td>
                        <select id="trainid" name="trainid">
                            <c:forEach items="${sessionScope.trainList}" var="train">
                                <option value="${train.trainId}" name="${train.trainId}"
                                        <c:if test="${sessionScope.plan.trainid==train.trainId}"><c:out
                                                value="selected"/></c:if>>
                                        ${train.trainId}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>车厢号</td>
                    <td><input type="text" name="chexiang" value="${sessionScope.plan.chexiang}"></td>
                </tr>
                <tr>
                    <td>比较</td>
                    <td>
                        <select id="compare" name="compare">
                            <option value="=" name="" <c:if test="${sessionScope.plan.compare.equals('=')}">
                                <c:out value="selected"/>
                            </c:if>>=
                            </option>
                            <option value=">=" name="" <c:if test="${sessionScope.plan.compare.equals('>=')}">
                                <c:out value="selected"/>
                            </c:if>>&gt;=
                            </option>
                            <option value="<=" name="" <c:if test="${sessionScope.plan.compare.equals('<=')}">
                                <c:out value="selected"/>
                            </c:if>>&lt;=
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>车站</td>
                    <td>
                        <select id="stationName" name="stationName">
                            <c:forEach items="${sessionScope.stationList}" var="station">
                                <option value="${station.stationName}" name="${station.stationName}"
                                        <c:if test="${sessionScope.plan.stationname.equals(station.stationName)}"><c:out
                                                value="selected"/></c:if>>
                                        ${station.stationName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="planModifySubmit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>

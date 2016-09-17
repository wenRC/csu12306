<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/17
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>旅程区段修改</h1>
    </div>
    <div>
        <form action="quDuan?function=submitModify" method="post">
            <table cellpadding="5">
                <tr>
                    <td>旅程区段编号</td>
                    <td><input type="text" name="quDuanId" value="${sessionScope.quDuan.quDuanId}" readonly></td>
                </tr>
                <tr>
                    <td>里程区段From</td>
                    <td><input type="text" name="from" value="${sessionScope.quDuan.from}"></td>
                </tr>
                <tr>
                    <td>里程区段To</td>
                    <td><input type="text" name="to" value="${sessionScope.quDuan.to}"></td>
                </tr>
                <tr>
                    <td>每区段里程</td>
                    <td><input type="text" name="distancePerQD" value="${sessionScope.quDuan.distancePerQD}"></td>
                </tr>
                <tr>
                    <td>区段数</td>
                    <td><input type="text" name="qdNumber" value="${sessionScope.quDuan.qdNumber}"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="quDuanModifySubmit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
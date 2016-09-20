<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<html>
<body>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="/updateDYDJ?dYDJId=${sessionScope.dYDJ.dYDJId}" method="post">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>递远递减率编号</td>
                            <td><input value="${sessionScope.dYDJ.dYDJId}" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td>里程区段From</td>
                            <td><input name="dYDJFrom" value="${sessionScope.dYDJ.dYDJFrom}"/></td>
                        </tr>
                        <tr>
                            <td>里程区段To</td>
                            <td><input name="dYDJTo" value="${sessionScope.dYDJ.dYDJTo}"/></td>
                        </tr>
                        <tr>
                            <td>递减率</td>
                            <td><input name="dYDJRate" value="${sessionScope.dYDJ.dYDJRate}"/></td>
                        </tr>
                        <tr>
                            <td>票价率</td>
                            <td><input name="priceRate" value="${sessionScope.dYDJ.priceRate}"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button type="submit">修改</button></td>
                                        <td><button type="button" onclick="cancel()">取消</button></td>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>

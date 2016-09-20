<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="/updateLine?lineId=${sessionScope.line.LineId}" method="post">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>线路编号</td>
                            <td><input value="${sessionScope.line.LineId}" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td>车次代码</td>
                            <td><input name="trainId" value="${sessionScope.line.trainId}"/></td>
                        </tr>
                        <tr>
                            <td>车站名</td>
                            <td><input name="stationName" value="${sessionScope.line.stationName}"/></td>
                        </tr>
                        <tr>
                            <td>到站时间</td>
                            <td><input name="fromTime" value="${sessionScope.line.fromTime}"/></td>
                        </tr>
                        <tr>
                            <td>停留时间</td>
                            <td><input name="lastTime" value="${sessionScope.line.lastTime}"/></td>
                        </tr>
                        <tr>
                            <td>里程</td>
                            <td><input name="distance" value="${sessionScope.line.distance}"/></td>
                        </tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button type="submit">修改</button></td>
                                        <td><button type="reset">删除此线路</button></td>
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
<script>
    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="body">
        <div id="right">
            <form name="dbForm" method="post" action="/updateStation?stationId=${sessionScope.station.stationId}">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>车站编号</td>
                            <td><input value="${sessionScope.station.stationId}" disabled="true"/></td>
                        </tr>
                        <tr>
                            <td>车站名</td>
                            <td><input value="${sessionScope.station.stationName}" name="stationName" /></td>
                        </tr>
                        <tr>
                            <td>拼音码</td>
                            <td><input value="${sessionScope.station.pinYin}" name="pinYin" /></td>
                        </tr>
                        <tr>
                            <td>所属铁路局</td>
                            <td><input value="${sessionScope.station.ju}" name="ju" /></td>
                        </tr>
                        <tr>
                            <td>车站等级</td>
                            <td>
                                <select name="level">
                                    <option value="">请选择</option>
                                    <option value="0" <c:if test="${sessionScope.station.level eq 0}">selected="selected"</c:if>>特等站</option>
                                    <option value="1" <c:if test="${sessionScope.station.level eq 1}">selected="selected"</c:if>>一等站</option>
                                    <option value="2" <c:if test="${sessionScope.station.level eq 2}">selected="selected"</c:if>>二等站</option>
                                    <option value="3" <c:if test="${sessionScope.station.level eq 3}">selected="selected"</c:if>>三等站</option>
                                    <option value="4" <c:if test="${sessionScope.station.level eq 4}">selected="selected"</c:if>>四等站</option>
                                    <option value="5" <c:if test="${sessionScope.station.level eq 5}">selected="selected"</c:if>>五等站</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>所属行政区域</td>
                            <td><input value="${sessionScope.station.location}" name="location" /></td>
                        </tr>
                        <tr>
                            <td>联系电话</td>
                            <td><input value="${sessionScope.station.phone}" name="phone" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button type="submit">修改</button></td>
                                        <td><button type="submit" onclick="btn_delete()">删除此车站</button></td>
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
    function btn_delete(){
        document.dbForm.action = "/delStation?stationId=${sessionScope.station.stationId}";
    }
    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
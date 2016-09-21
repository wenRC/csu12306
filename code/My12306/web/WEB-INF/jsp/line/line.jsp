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
            <form name="dbForm" action="/updateLine?lineId=${sessionScope.line.lineId}" method="post">
                <div id="addPart" align="center">
                    <table id="add" class="table table-hover">
                        <tr>
                            <td>线路编号</td>
                            <td><input value="${sessionScope.line.lineId}" disabled="true" /></td>
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
                                        <td><button class="btn btn-default" type="button" onclick="formSubmit()">修改</button></td>
                                        <td><button class="btn btn-default" type="button" onclick="btn_delete()">删除此线路</button></td>
                                        <td><button class="btn btn-default" type="button" onclick="cancel()">取消</button></td>
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
        if(confirm("确认删除此线路?")){
            document.dbForm.action = "/delLine?lineId=${sessionScope.line.lineId}";
            document.dbForm.submit();
        }
    }
    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
    function formSubmit(){
        if(confirm("确认修改信息无误?")){
            document.dbForm.submit();
        }
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
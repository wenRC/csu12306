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
            <form action="/newLine" method="post" name="dbForm">
                <div id="addPart" align="center">
                    <table class="table table-hover" id="add">
                        <tr>
                            <td>车次代码</td>
                            <td><input name="trainId" class="input" /></td>
                        </tr>
                        <tr>
                            <td>车站名</td>
                            <td><input name="stationName" class="input" /></td>
                        </tr>
                        <tr>
                            <td>到站时间</td>
                            <td><input name="fromTime" class="input" /></td>
                        </tr>
                        <tr>
                            <td>里程</td>
                            <td><input name="distance" class="input" /></td>
                        </tr>
                        <tr>
                            <td>停留时间</td>
                            <td><input name="lastTime" class="input" /></td>
                        </tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button class="btn btn-default" type="button" onclick="formSubmit()">提交</button></td>
                                        <td><button class="btn btn-default" type="reset">重置</button></td>
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
    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
    function formSubmit(){
        if(confirm("确认新增线路？")){
            document.dbForm.submit();
        }
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
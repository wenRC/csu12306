<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="/getByStationName" method="post">
                <div id="addPart" align="center">
                    <table class="table table-hover" id="add">
                        <tr>
                            <td>请输入车站名</td>
                            <td>
                                <input name="stationName"/>
                            </td>
                        </tr>
                        <tr>
                            <td><button class="btn btn-default" type="submit">查询</button></td>
                            <td><button class="btn btn-default" type="button" onclick="cancel()">取消</button></td>
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
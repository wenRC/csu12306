<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/20
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <%--<div id="top"><img src="../img/head.png"></div>--%>
    <div id="body">
        <div id="right">
            <form action="" name="dbForm" method="get">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>请选择查询方式</td>
                            <td>
                                <select id="method">
                                    <option value="byTrianNum">按车次查询</option>
                                    <option value="byStation">按车站查询</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><button onclick="chooseMethod()" type="submit">选择</button></td>
                            <td><button type="button" onclick="cancel()">取消</button></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function chooseMethod(){
        if(document.getElementById("method").value == "byTrianNum")
        {
            document.dbForm.action = "/searchByTrainId";
        }else{
            document.dbForm.action = "/searchByStationName";
        }
    }

    function cancel(){
        window.location.href="/to?function=toHouTai";
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
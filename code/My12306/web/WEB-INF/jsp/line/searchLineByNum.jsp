<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/management.css" type="text/css">
    <link rel="stylesheet" href="../css/add.css" type="text/css">
</head>
<body>
<div id="content">
    <div id="top"><img src="../img/head.png"></div>
    <div id="body">
        <div id="left">
            <ul>
                <li class="function" id="function_first"><a href="/management">全部功能</a></li>
                <li class="function"><a href="/stationManagement">车站管理</a></li>
                <li class="function"><a href="/lineManagement">线路管理</a></li>
                <li class="function"><a href="/diyuandijianManagement">递远递减率管理</a></li>
            </ul>
        </div>
        <div id="right">
            <form action="/getByTrainId" method="get">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>请输入车次</td>
                            <td>
                                <input name="trainId"/>
                            </td>
                        </tr>
                        <tr>
                            <td><button type="submit">查询</button></td>
                            <td><button type="button" onclick="cancel()">取消</button></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function cancel(){
        window.location.href="/management";
    }
</script>
</body>
</html>
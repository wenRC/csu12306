<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:41
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
            <form action="/newLine" method="post">
                <div id="addPart" align="center">
                    <table id="add">
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
                                        <td><button type="submit">提交</button></td>
                                        <td><button type="reset">重置</button></td>
                                        <td><button type="button">取消</button></td>
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
        window.location.href="/management";;}
</script>
</body>
</html>
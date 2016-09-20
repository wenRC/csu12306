<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/19
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="body">
        <div id="right">
            <form action="/newDYDJ" method="post">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>里程区段From</td>
                            <td><input name="from"/></td>
                        </tr>
                        <tr>
                            <td>里程区段To</td>
                            <td><input name="to"/></td>
                        </tr>
                        <tr>
                            <td>递减率</td>
                            <td><input name="rate"/></td>
                        </tr>
                        <tr>
                            <td>票价率</td>
                            <td><input name="priceRate"/></td>
                        </tr>
                        <tr>
                            <td>各区段全程票价</td>
                            <td><input /></td>
                        </tr>
                        <tr>
                            <td>区段累计票价</td>
                            <td><input /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button type="submit">提交</button></td>
                                        <td><button type="reset">重置</button></td>
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
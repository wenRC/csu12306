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
            <form method="post" action="/newStation">
                <div id="addPart" align="center">
                    <table id="add">
                        <tr>
                            <td>车站名</td>
                            <td><input name="stationName" class="input" name="stationName" /></td>
                        </tr>
                        <tr>
                            <td>拼音码</td>
                            <td><input name="pinYin" class="input" name="pinYin" /></td>
                        </tr>
                        <tr>
                            <td>所属铁路局</td>
                            <td><input class="input" name="tieLuJu" /></td>
                        </tr>
                        <tr>
                            <td>车站等级</td>
                            <td id="select">
                                <select  class="input" name="level">
                                    <option value="请选择">请选择</option>
                                    <option value="特等站">特等站</option>
                                    <option value="一等站">一等站</option>
                                    <option value="二等站">二等站</option>
                                    <option value="三等站">三等站</option>
                                    <option value="四等站">四等站</option>
                                    <option value="五等站">五等站</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>所属行政区域</td>
                            <td><input name="location" class="input" name="xingZhengQu" /></td>
                        </tr>
                        <tr>
                            <td>联系地址</td>
                            <td><input class="input" name="address" /></td>
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
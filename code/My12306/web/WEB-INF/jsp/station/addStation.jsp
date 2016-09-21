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
            <form name="dbForm" method="post" action="/newStation">
                <div id="addPart" align="center">
                    <table class="table table-hover" id="add">
                        <tr>
                            <td>车站名</td>
                            <td><input name="stationName" class="input" /></td>
                        </tr>
                        <tr>
                            <td>拼音码</td>
                            <td><input name="pinYin" class="input" /></td>
                        </tr>
                        <tr>
                            <td>所属铁路局</td>
                            <td><input class="input" name="ju" /></td>
                        </tr>
                        <tr>
                            <td>车站等级</td>
                            <td id="select">
                                <select  class="input" name="level">
                                    <option value="">请选择</option>
                                    <option value="0">特等站</option>
                                    <option value="1">一等站</option>
                                    <option value="2">二等站</option>
                                    <option value="3">三等站</option>
                                    <option value="4">四等站</option>
                                    <option value="5">五等站</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>所属行政区域</td>
                            <td><input name="location" class="input" /></td>
                        </tr>
                        <tr>
                            <td>联系电话</td>
                            <td><input class="input" name="phone" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button class="btn btn-default" type="submit">提交</button></td>
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
    function submitForm(){
        if(confirm("确认新增车站?")){
            document.dbForm.submit();
        }
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
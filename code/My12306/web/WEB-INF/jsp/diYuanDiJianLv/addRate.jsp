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
            <form id="dbForm" name="dbForm" action="/newDYDJ" method="post">
                <div id="addPart" align="center">
                    <table id="add" class="table table-hover">
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
                            <td colspan="2">
                                <table>
                                    <tr>
                                        <td><button type="button" class="btn btn-default" onclick="formSubmit()" >提交</button></td>
                                        <td><button type="reset" class="btn btn-default" >重置</button></td>
                                        <td><button type="button" class="btn btn-default" onclick="cancel()">取消</button></td>
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
        if(confirm("是否确认新增信息无误？")){
            document.getElementById("dbForm").submit();
        }
    }
</script>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/17
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>旅程区段修改</h1>
    </div>
    <div>
        <form action="quDuan?function=submitModify" method="post" role="form"
              class="form-horizontal">

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="quDuanId" class="col-sm-3 control-label">区段编号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="quDuanId" name="quDuanId"
                           value="${sessionScope.quDuan.quDuanId}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="from" class="col-sm-3 control-label">区段From</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="from" name="from"
                           value="${sessionScope.quDuan.from}">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="to" class="col-sm-3 control-label">区段To</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="to" name="to"
                           value="${sessionScope.quDuan.to}">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="distancePerQD" class="col-sm-3 control-label">每区段里程</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="distancePerQD" name="distancePerQD"
                           value="${sessionScope.quDuan.distancePerQD}">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="qdNumber" class="col-sm-3 control-label">区段数</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="qdNumber" name="qdNumber"
                           value="${sessionScope.quDuan.qdNumber}">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px;">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
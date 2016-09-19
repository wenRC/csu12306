<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>添加计划</h1>
    </div>
    <div>
        <form action="plan?function=submitAdd" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="planid" class="col-sm-3 control-label">计划代码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="planid" name="planid" placeholder="请输入计划代码">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="trainid" class="col-sm-3 control-label">车次代码</label>
                <div class="col-sm-9">
                    <select id="trainid" name="trainid" class="form-control">
                        <c:forEach items="${sessionScope.trainList}" var="train">
                            <option value="${train.trainId}" name="${train.trainId}">
                                    ${train.trainId}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="chexiang" class="col-sm-3 control-label">车厢号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="chexiang" name="chexiang" placeholder="请输入车厢号">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="compare" class="col-sm-3 control-label">比较</label>
                <div class="col-sm-9">
                    <select id="compare" name="compare" class="form-control">
                        <option value="=">=</option>
                        <option value=">=">&gt;=</option>
                        <option value="<=">&lt;=</option>
                    </select>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="stationName" class="col-sm-3 control-label">车站</label>
                <div class="col-sm-9">
                    <select id="stationName" name="stationName" class="form-control">
                        <c:forEach items="${sessionScope.stationList}" var="station">
                            <option value="${station.stationName}" name="${station.stationName}">
                                    ${station.stationName}
                            </option>
                        </c:forEach>
                    </select>
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


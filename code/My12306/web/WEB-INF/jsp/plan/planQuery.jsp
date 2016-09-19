<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>计划管理</h1>
    </div>
    <div>
        <form action="plan?function=query" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="queryMethod" class="col-sm-3 control-label">按</label>
                <div class="col-sm-9">
                    <select id="queryMethod" name="queryMethod" class="form-control">
                        <option value="plan">计划代码</option>
                        <option value="train">车次代码</option>
                    </select>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="queryId" class="col-sm-3 control-label">代码</label>
                <div class="col-sm-9">
                    <input id="queryId" type="number" class="form-control" name="queryId" min="1" max="100"
                           placeholder="请输入代码" required>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px;">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
            </div>
        </form>
    </div>

    <div>
        <a href="plan?function=queryAll">显示所有计划</a>
    </div>

    <div>
        <c:if test="${requestScope.success!=null}">
            <div class="alert alert-success" role="alert" style="margin: 50px">
                <strong>${requestScope.success}</strong>
            </div>
        </c:if>
        <c:if test="${requestScope.fail!=null}">
            <div class="alert alert-warning" role="alert" style="margin: 50px">
                <strong>${requestScope.fail}</strong>
            </div>
        </c:if>
    </div>

    <div>
        <table class="table table-hover" style="width: 90%;margin: auto">
            <thead>
            <tr>
                <th>计划代码</th>
                <th>车次代码</th>
                <th>车厢号</th>
                <th>比较</th>
                <th>车站</th>
                <th>操作</th>
                <th>操作</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${sessionScope.planList[0]!=null}">
                <c:forEach items="${sessionScope.planList}" var="plan">
                    <tr>
                        <td>${plan.planid}</td>
                        <td>${plan.trainid}</td>
                        <td>${plan.chexiang}</td>
                        <td>${plan.compare}</td>
                        <td>${plan.stationname}</td>
                        <td><a href="plan?function=modify&planid=${plan.planid}">修改</a></td>
                        <td><a href="plan?function=delete&planid=${plan.planid}">删除</a></td>
                        <td><a href="to?function=announceSeat&planid=${plan.planid}">执行</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


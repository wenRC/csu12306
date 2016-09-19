<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>

<div id="content" align="center">
    <div>
        <h1>旅程区段查询</h1>
    </div>
    <div>
        <form action="quDuan?function=queryById" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="quDuanId" class="col-sm-3 control-label">区段编号</label>
                <div class="col-sm-9">
                    <input id="quDuanId" type="number" class="form-control" name="quDuanId"
                           min="1" max="100000" placeholder="请输入区段编号" required>
                </div>
            </div>
            <div class="form-group" style="width: 400px;margin: 10px;">
                <div class="col-sm-offset-1 col-sm-10">
                    <button type="submit" class="btn btn-default">查询</button>
                </div>
            </div>
        </form>
        <a href="quDuan?function=queryAll">显示所有区段</a>
    </div>
    <br/>
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
                <th>旅程区段编号</th>
                <th>里程区段From</th>
                <th>里程区段To</th>
                <th>每区段里程</th>
                <th>区段数</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${sessionScope.quDuanList[0]!=null}">
                <c:forEach items="${sessionScope.quDuanList}" var="quDuan">
                    <tr>
                        <td>${quDuan.quDuanId}</td>
                        <td>${quDuan.from}</td>
                        <td>${quDuan.to}</td>
                        <td>${quDuan.distancePerQD}</td>
                        <td>${quDuan.qdNumber}</td>
                        <td><a href="quDuan?function=toModify&id=${quDuan.quDuanId}">修改</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
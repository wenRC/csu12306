<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>

<div id="content" align="center">
    <div>
        <h1>旅程区段查询</h1>
    </div>
    <div>
        <form action="quDuan?function=queryById" method="post">
            旅程区段编号：<input type="text" name="quDuanId"/>
            <input type="submit" name="quDuanQuery" value="查询"/>
        </form>
        <a href="quDuan?function=queryAll">显示所有区段</a>
    </div>
    <br/>
    <div>
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>旅程区段编号</th>
                <th>里程区段From</th>
                <th>里程区段To</th>
                <th>每区段里程</th>
                <th>区段数</th>
                <th>操作</th>
            </tr>
            <%--<c:if test="${fn:length(sessionScope.quDuanList)!=0}">--%>
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
        </table>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
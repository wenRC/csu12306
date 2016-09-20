<%--
  Created by IntelliJ IDEA.
  User: Asus_
  Date: 2016/9/20
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content">
    <div id="top"><img src="../img/head.png"></div>
    <div id="body">
        <div id="right">
            <ul>
                <li class="management"><a href="/addStation">新建车站</a></li>
                <li class="management"><a href="/searchStation">查询/修改/删除车站</a></li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
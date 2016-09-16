<%--
  Created by IntelliJ IDEA.
  User: 温 睿诚
  Date: 2016/9/15/0015
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp"%>
<form class="form-horizontal" role="form" action="/login" method="get">
    <div class="form-group">
        <label for="Email" class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-3">
            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
</form>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
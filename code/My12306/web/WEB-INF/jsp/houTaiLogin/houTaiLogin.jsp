<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/19
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<div id="content" align="center">
    <form class="form-horizontal" role="form" action="houtailogin" method="post">
        <div><h1>管理员登录</h1></div>
        <div class="form-group" style="width: 500px;margin: 10px auto">
            <label for="adminName" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" minlength="1" maxlength="6" id="adminName" name="adminName" placeholder="请输入管理员账号">
            </div>
        </div>
        <div class="form-group" style="width: 500px;margin: 10px auto">
            <label for="adminPassword" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" minlength="1" maxlength="6" id="adminPassword" name="adminPassword" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group" style="width: 400px;margin: 10px auto">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>
    </form>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


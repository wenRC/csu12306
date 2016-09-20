<%--
  Created by IntelliJ IDEA.
  User: 温 睿诚
  Date: 2016/9/18/0018
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp"%>
<form class="form-horizontal" role="form" action="/changePassword" method="post">
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="password" name="password" placeholder="密码" required>
        </div>
    </div>
    <div class="form-group">
        <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
        <div class="col-sm-3">
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="确认密码" required>
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">修改</button>
        </div>
    </div>

</form>
<div class="alert alert-success" role="alert" style="margin: 50px">
    <strong>${sessionScope.cupmsg}</strong>
</div>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>

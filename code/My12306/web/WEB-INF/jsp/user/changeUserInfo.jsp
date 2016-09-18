<%--
  Created by IntelliJ IDEA.
  User: 温 睿诚
  Date: 2016/9/15/0015
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp"%>
<form class="form-horizontal" role="form" action="/updateUser" method="post">
    <div class="form-group">
        <label for="Email" class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-3">
            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" value="${sessionScope.user.email}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-2">
        <label class="radio-inline"  >
            <input type="radio" name="sex" id="inlineRadio1" value="1" <c:if test="${sessionScope.user.sex.equals('男')}"> checked</c:if> >男
        </label></div><div class="col-sm-2">
        <label class="radio-inline">
            <input type="radio" name="sex" id="inlineRadio2" value="2"<c:if test="${sessionScope.user.sex.equals('女')}"> checked</c:if> > 女
        </label></div>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="username" name="username" value="${sessionScope.user.username}">
        </div>
    </div>
    <div class="form-group">
        <label for="id" class="col-sm-2 control-label">身份证</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}">
        </div>
    </div>
    <div class="form-group">
        <label for="phone" class="col-sm-2 control-label">联系方式</label>
        <div class="col-sm-3">
            <input type="phone" class="form-control" id="phone" name="phone" value="${sessionScope.user.phone}">
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">修改</button>
        </div>
    </div>

</form>
<div class="alert alert-success" role="alert" style="margin: 50px">
    <strong>${sessionScope.cumsg}</strong>
</div>

<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp"%>
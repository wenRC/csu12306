<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<script>
    function submit() {
        alert("车票将会在3个工作日内送到！");
        window.location.href = "/forward?to=searchOrder"
    }
</script>
<div class="alert alert-info" role="alert">
    <strong>成人票可凭身份证直接进站乘车，亦可到站打票或选择邮寄服务。</strong>
</div>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <label class="col-sm-2 control-label" for="address">邮寄地址</label>
        <div class="col-sm-8">
        <input type="text" class="form-control" id="address" placeholder="邮寄地址" ></div></div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="call">联系方式</label>
            <div class="col-sm-8">
            <input type="text" class="form-control" id="call" placeholder="联系方式" ></div></div>
</form>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-primary" onclick="submit()">提交</button> </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>

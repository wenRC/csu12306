<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/19
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>席位修改</h1>
    </div>
    <div>
        <form action="diaodu?function=submitModify" method="post" role="form" class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="seatid" class="col-sm-3 control-label">席位代码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="seatid" name="seatid"
                           value="${sessionScope.seat.seatid}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="trainid" class="col-sm-3 control-label">车次</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="trainid" name="trainid"
                           value="${sessionScope.seat.trainid}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="date" class="col-sm-3 control-label">日期</label>
                <div class="col-sm-9">
                    <input type="datetime" class="form-control" id="date" name="date" value="${sessionScope.seat.date}">
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="chexiang" class="col-sm-3 control-label">车厢号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="chexiang" name="chexiang"
                           value="${sessionScope.seat.chexiang}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="seatno" class="col-sm-3 control-label">座位号</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="seatno" name="seatno"
                           value="${sessionScope.seat.seatno}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="from" class="col-sm-3 control-label">乘车区间起始站</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="from" name="from" value="${sessionScope.seat.from}"
                           readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="to" class="col-sm-3 control-label">乘车区间终到站</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="to" name="to" value="${sessionScope.seat.to}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="status" class="col-sm-3 control-label">售票状态</label>
                <div class="col-sm-9">
                    <select id="status" name="status" class="form-control">
                        <option value="未售" <c:if test="${sessionScope.seat.status.equals('未售')}">
                            <c:out value="selected"/>
                        </c:if>>未售
                        </option>
                        <option value="已售" <c:if test="${sessionScope.plan.compare.equals('已售')}">
                            <c:out value="selected"/>
                        </c:if>>已售
                        </option>
                        <option value="不可售" <c:if test="${sessionScope.plan.compare.equals('不可售')}">
                            <c:out value="selected"/>
                        </c:if>>不可售
                        </option>
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


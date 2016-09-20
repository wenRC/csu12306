<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>计划修改</h1>
    </div>
    <div>
        <form action="plan?function=submitModify&planid=${sessionScope.plan.planid}" method="post" role="form"
              class="form-horizontal">
            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="planid" class="col-sm-3 control-label">计划代码</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="planid" name="planid"
                           value="${sessionScope.plan.planid}" readonly>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="trainid" class="col-sm-3 control-label">车次代码</label>
                <div class="col-sm-9">
                    <select id="trainid" name="trainid" class="form-control">
                        <c:forEach items="${sessionScope.trainList}" var="train">
                            <option value="${train.trainId}" name="${train.trainId}"
                                    <c:if test="${sessionScope.plan.trainid==train.trainId}"><c:out
                                            value="selected"/></c:if>>
                                    ${train.trainId}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="chexiang" class="col-sm-3 control-label">车厢号</label>
                <div class="col-sm-9">
                    <input type="number" class="form-control" id="chexiang" name="chexiang" min="1" max="100"
                           value="${sessionScope.plan.chexiang}" placeholder="请输入车厢号" required>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="compare" class="col-sm-3 control-label">售票状态</label>
                <div class="col-sm-9">
                    <select id="compare" name="compare" class="form-control">
                        <option value="=" name="" <c:if test="${sessionScope.plan.compare.equals('=')}">
                            <c:out value="selected"/>
                        </c:if>>=
                        </option>
                        <option value=">=" name="" <c:if test="${sessionScope.plan.compare.equals('>=')}">
                            <c:out value="selected"/>
                        </c:if>>&gt;=
                        </option>
                        <option value="<=" name="" <c:if test="${sessionScope.plan.compare.equals('<=')}">
                            <c:out value="selected"/>
                        </c:if>>&lt;=
                        </option>
                    </select>
                </div>
            </div>

            <div class="form-group" style="width: 400px;margin: 10px auto;">
                <label for="stationName" class="col-sm-3 control-label">车站</label>
                <div class="col-sm-9">
                    <select id="stationName" name="stationName" class="form-control">
                        <c:forEach items="${sessionScope.stationList}" var="station">
                            <option value="${station.stationName}" name="${station.stationName}"
                                    <c:if test="${sessionScope.plan.stationname.equals(station.stationName)}"><c:out
                                            value="selected"/></c:if>>
                                    ${station.stationName}
                            </option>
                        </c:forEach>
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

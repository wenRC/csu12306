<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sx
  Date: 2016/9/18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp" %>
<div id="content" align="center">
    <div>
        <h1>添加计划</h1>
    </div>
    <div>
        <form action="plan?function=submitAdd" method="post">
            <table cellpadding="5">
                <tr>
                    <td>计划代码</td>
                    <td><input type="text" name="planid" value=""></td>
                </tr>
                <tr>
                    <td>车次代码</td>
                    <td>
                        <select id="trainid" name="trainid">
                            <c:forEach items="${users}" var="u">
                                <option value="${u.id }"
                                        <c:if test="${user.user_id==u.id}">
                                            <c:out value="selected"/>
                                        </c:if>>
                                        ${u.name}
                                </option>
                            </c:forEach>
                        </select>
                        <input type="text" name="trainid">
                    </td>
                </tr>
                <tr>
                    <td>车厢号</td>
                    <td><input type="text" name="chexiang"></td>
                </tr>
                <tr>
                    <td>比较</td>
                    <td><input type="text" name="compare"></td>
                </tr>
                <tr>
                    <td>车站</td>
                    <td><input type="text" name="stationname"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="planAddSubmit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>


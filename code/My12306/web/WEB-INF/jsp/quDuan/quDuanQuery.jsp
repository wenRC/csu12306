<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTopBack.jsp"%>

<div id="content" align="center">
    <div>
        <h1>旅程区段查询</h1>
    </div>
    <div>
        <form action="" method="post">
            旅程区段编号：<input type="text" name="quDuanId"/>
            <input type="submit" name="quDuanQuery" value="查询"/>
        </form>
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
            <tr>
                <td>1234</td>
                <td>长沙</td>
                <td>上海</td>
                <td>1200</td>
                <td>10</td>
                <td><a href="quDuanModify.html">修改</a></td>
            </tr>
        </table>
    </div>
</div>

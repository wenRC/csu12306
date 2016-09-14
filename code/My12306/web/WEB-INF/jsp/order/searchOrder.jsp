<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/IncludeTop.jsp" %>
<div id="content">
    <form role="form" class="form-inline">
        <div class="form-group">

            <select class="form-control" id="select">
                <option value="1">按订票日期</option>
                <option value="2">按出行日期</option>
            </select>
            <input type="text" class="form-control" id="date" placeholder="日期"/>
            <input type="submit" class="btn btn-primary" value="查询"/>
        </div>
    </form>

    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>订单号</th>
                <th> 车次
                </th>
                <th> 席位
                </th>
                <th> 出发站
                </th>
                <th> 到达站
                </th>
                <th>出发时间</th>
                <th> 历时
                </th>
                <th> 票种
                </th>
                <th> 价格
                </th>
                <th>乘车人</th>
                <th>订票日期</th>
                <th>订单状态</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td >39011403</td>
                <td >G6023</td>
                <td >6车1A</td>
                <td >广州北</td>
                <td >长沙南</td>
                <td >2016-10-07 14:32</td>
                <td >00:17</td>
                <td >二等座</td>
                <td >15.0元</td>
                <td >xlf</td>
                <td >2016-10-01</td>
                <td >未出行</td>
                <td ><input type="button" value="退票" class="btn btn-default"/><input type="button" value="取票"
                                                                                       class="btn btn-default"/><input
                        type="button" value="改签" class="btn btn-default"/></td>
            </tr>
            <tr>
                <td >141109</td>
                <td >G1103</td>
                <td >6车2A</td>
                <td >广州北</td>
                <td >广州南</td>
                <td >2016-10-07 16:32</td>
                <td >02:30</td>
                <td >二等座</td>
                <td >294.0元</td>
                <td >wrc</td>
                <td >2016-10-01</td>
                <td >未出行</td>

                <td width="200"><input type="button" value="退票" class="btn btn-default"/><input type="button" value="取票"
                                                                                        class="btn btn-default"/><input
                        type="button" value="改签" class="btn btn-default"/></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/jsp/common/IncludeBottom.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
    />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>

<div id="header">
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/index.jsp">我的12306</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">调度管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=diaodu">席位查询与修改</a></li>
                            <li><a href="to?function=diaodu">客运统计</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">计划管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=plan">查询计划</a></li>
                            <li><a href="plan?function=add">新增计划</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">区段管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=quDuan">查询旅程区段</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">递远递减率管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/addDYDJ">新增递远递减率</a></li>
                            <li><a href="/searchDYDJ">查询修改递远递减率</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">线路管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/addLine">新建线路</a></li>
                            <li><a href="/searchLine">查询线路</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">票价率管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=priceRate">查询票价率</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">列车编组<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=trainGrouped">查询列车编组</a></li>
                            <li><a href="trainGrouped?function=add">添加列车编组</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">列车管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="to?function=train">查询列车</a></li>
                            <li><a href="train?function=add">新建列车</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">车站管理<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/addStation">新建车站</a></li>
                            <li><a href="/searchStation">查询车站</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="">财务统计</a></li>
                    <%--<li class="dropdown"><a href="houtaiexit">管理员退出</a></li>--%>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
</div>
<br><br><br><br>
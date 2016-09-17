<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.min.js"></script>
  </head>
  <body>
    <div id="header">
    <!-- Fixed navbar -->
      <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index.jsp">我的12306</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <c:if test="${sessionScope.user==null}"><li><a href="ViewLogin">登陆</a></li></c:if>
              <c:if test="${sessionScope.user!=null}"><li><a href="ViewChangeUserInfo">${sessionScope.user.username}</a></li></c:if>
              <li><a href="ViewYupiao">订票</a></li>
              <li><a href="ViewOrder">我的订单</a></li>
<<<<<<< HEAD
=======
              <li><a href="/indexB.jsp">后台</a></li>
>>>>>>> 0a13dcfab7cac69e56ba169773843cd544ed308f
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </nav>
    </div>
  <br>
  <br>
  <br>
  <br>
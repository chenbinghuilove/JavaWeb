<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>科技资讯网</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<!--[if lt IE 9]>
 <script src="../assets/js/html5shiv.min.js"></script>
 <script src="../assets/js/respond.min.js"></script>
<![endif]-->
</head>
<body>
 <div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
   <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
     <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">科技资讯网</a>
   </div>
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
     <li class="active"><a href="../home">首页</a></li>
     <c:forEach items="${newsCategoryList}" var="newsCategory">
      <li><a href="../list/?id=${newsCategory.id}">${newsCategory.name}</a></li>
     </c:forEach>
    </ul>
   </div>
  </div>
 </div>
 <div class="container" style="margin-top: 50px;">
  <div class="row">
   <div class="col-md-12">
    <h2 align="center">${newsContent.title}</h2>
    <h4 align="center">作者：${newsContent.author}&nbsp;&nbsp;&nbsp;修改日期：${newsContent.editDate}</h4>
    <p style="background-color: #eee">${newsContent.lead}</p>
    <p>${newsContent.content}</p>
    <!-- 注释，注释，注释，注释 -->
   </div>
  </div>
  <hr>
  <div>
   <p>&copy; Copy Right 2015.</p>
  </div>
 </div>
 <script src="../assets/js/jquery.min.js"></script>
 <script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
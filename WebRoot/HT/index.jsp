<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
    
  </div>
  <div class="logo margin-big-left fadein-top">
  <h4><%=ActionContext.getContext().getSession().get("username")%></h4>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 前台首页</a>  &nbsp;&nbsp;<a class="button button-little bg-red" href="removeaction"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="info.jsp" target="right"><span class="icon-caret-right"></span>添加图书</a></li>
    <li><a href="pass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
      
    <li><a href="selectbookaction" target="right"><span class="icon-caret-right"></span>图书查询</a></li>   
    <li><a href="list.jsp" target="right"><span class="icon-caret-right"></span>图书详情</a></li>     
    <li><a href="column.jsp" target="right"><span class="icon-caret-right"></span>栏目管理</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>职务管理</h2>
  <ul>
    
    <li><a href="addjob.jsp" target="right"><span class="icon-caret-right"></span>添加职务</a></li>
    
    <li><a href="queryjobaction" target="right"><span class="icon-caret-right"></span>查询职务</a></li>
            
  </ul>
  
  <h2><span class="icon-pencil-square-o"></span>部门管理</h2>
  <ul>
    
    <li><a href="adddep.jsp" target="right"><span class="icon-caret-right"></span>添加部门</a></li>
    
    <li><a href="querydepaction" target="right"><span class="icon-caret-right"></span>查询部门</a></li>
            
  </ul>
  
  <h2><span class="icon-pencil-square-o"></span>职位类型管理</h2>
  <ul>
    
    <li><a href="addposit.jsp" target="right"><span class="icon-caret-right"></span>添加职位类型</a></li>
    
    <li><a href="querypositaction" target="right"><span class="icon-caret-right"></span>查询职位类型</a></li>
            
  </ul>
  
  <h2><span class="icon-pencil-square-o"></span>岗级管理</h2>
  <ul>
    
    <li><a href="addpostgrade.jsp" target="right"><span class="icon-caret-right"></span>添加岗级</a></li>
    
    <li><a href="querypostgradeaction" target="right"><span class="icon-caret-right"></span>查询岗级</a></li>
            
  </ul>      
</div>
<script type="text/javascript">

$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.jsp" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>
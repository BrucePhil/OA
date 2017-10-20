<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
<title></title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>

  </head>
  
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> <br>部门列表</strong><br></div>
  
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">部门ID</th>
      <th width="10%">部门名称</th>
      <th width="10%">部门领导人</th>
      <th width="50%">部门简介</th>
      <th width="20%">操作</th>
    </tr>
    <s:iterator var="st" value="#session.dep" status="stat">
    <tr>
      <td><s:property value="#st.getDepId()"/></td>
      <td><s:property value="#st.getDepName()"/></td>
      <td><s:property value="#st.getUserinfo().getId()"/></td>
      <td><s:property value="#st.getDepRemak()"/></td>
      <td><div class="button-group">
       <a class="button border-main" href="querydepidaction?id=<s:property value="#st.getDepId()"/>"><span class="icon-edit"></span> 修改</a>
       <a class="button border-red" href="deldepaction?id=<s:property value="#st.getDepId()"/>" ><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
    </s:iterator>
    
  </table>
</div>
  </body>
</html>

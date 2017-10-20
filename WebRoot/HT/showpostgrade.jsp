<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th>岗级名称</th>  
      <th width="250">操作</th>
    </tr>
    <s:iterator var="st" value="#session.pg" status="stat">
    <tr>
      <td><s:property value="#st.getPgid()"/></td>      
      <td><s:property value="#st.getPgname()"/></td>  
      <td>
      <div class="button-group">
      <a type="button" class="button border-main" href="querpostgradeidaction?id=<s:property value="#st.getPgid()"/>"><span class="icon-edit"></span>修改</a>
      <a class="button border-red" href="delpostgradeaction?id=<s:property value="#st.getPgid()"/>"/><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr>   
    </s:iterator>
  </table>
</div>



</body></html>
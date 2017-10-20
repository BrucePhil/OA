<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 图书列表</strong></div>
  <div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">图书ID</th>
      <th width="10%">图书名</th>
      <th width="15%">作者</th>
      <th width="15%">出版社</th>
      <th width="10%">出版日期</th>
      <th width="15%">图书编号</th>
      <th width="25%">操作</th>
      
      
    </tr>
   <s:iterator var="st" value="#session.book" status="stat">
    <tr>
    
      <td><s:property value="#st.getBookid()"/></td>     
      <td><s:property value="#st.getBookname()"/></td>     
      <td><s:property value="#st.getAuthor()"/></td>
      <td><s:property value="#st.getPublisher()"/></td>
      <td><s:property value="#st.getPubDate()"/></td>
      <td><s:property value="#st.getNumbers()"/></td>
      <td><div class="button-group">
      <a class="button border-main" href="#add"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="delbookaction?bo.bookid=<s:property value="#st.getBookid()"/>"><span class="icon-trash-o"></span> 删除</a>
      <a class="button border-main" href="addbookimgaction?bo.bookid=<s:property value="#st.getBookid()"/>"><span class="icon-edit"></span>图片</a>
      </div>
      </td>
     
    </tr>
    </s:iterator>
  </table>
</div>

<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="addbookimg1action">    
      <div class="form-group">
        <div class="label">
          <label>图书ID：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${id}" name="bo.bookid" data-validate="required:请输入标题" />
          <div class="tips">
          
          </div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <input type="file" class="button bg-blue margin-left" id="image1" name="dp.img" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="dp.descption" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>
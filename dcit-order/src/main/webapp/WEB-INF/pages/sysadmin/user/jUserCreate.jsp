<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>用户新增</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="80%" >
	<tr class="odd">
		<td>用户名：</td>
		<td><input name="username"  type="text"/></td>
		<td>密码：</td>
		<td><input name="password"  type="password"/></td>
	</tr>
	<tr class="odd">
		<td>状态</td>
		<td><select name="status" style="width:150px">
			<option value ="1">激活状态</option>
			<option value ="0">停用状态</option>
		</select></td>
		<td>身份证号</td>
		<td><input name="card"  type="text" style="width:300px"/></td>
	</tr>
	<tr class="odd">
		
		<td>出生日期</td>
		<td><input name="birthday" type="date"/></td>
		<td>性别</td>
		<td><select name="sex" style="width:50px">
			<option value ="男">男</option>
			<option value ="女">女</option>
		</select></td>
	</tr>
	<tr class="odd">
		<td>学历</td>
		<td><select name="education" style="width:150px">
			<option value ="高中">高中</option>
			<option value ="高职">高职</option>
			<option value ="本科">本科</option>
			<option value ="硕士">硕士</option>
			<option value ="博士">博士</option>
		</select></td>
		<td>网点名称：</td>
		<td>
			<select name="websitecode" style="width:200px">
				<c:forEach items="${websiteList}" var="w" varStatus="status">
					<option value ="${w.code}">${w.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>	
</table>
</div>
</div>
</form>
</body>
</html>


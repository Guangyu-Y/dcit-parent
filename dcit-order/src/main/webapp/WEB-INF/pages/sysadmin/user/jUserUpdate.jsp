<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户更新</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>用户名：</td>
		<td><input name="username"  type="text" value="${ teller.username }"/>
			<input name="id" type="hidden" value="${teller.id}">
		</td>
		<td>密码：</td>
		<td><input name="password"  type="text" value="${ teller.password }"/></td>
		
		<td>状态：</td>
		<td><input name="status"  type="text" value="${teller.status }"/></td>
		
		<td>学历：</td>
		<td><input name="education"  type="text" value="${teller.education }"/></td>
		
	</tr>
	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


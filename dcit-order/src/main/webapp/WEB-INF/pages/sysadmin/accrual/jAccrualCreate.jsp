<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>利率新增</title>
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
 	 利率新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>类别:</td>
		<td>
			<select name="mtype" id="selecttype" style="width:30%" onchange="getAccrual(this.value,'accrual')">
				<option value="0">存款利率</option>
				<option value="1">贷款利率</option>
			</select>
		</td>
		<td>时长:</td>
		<td><input name="month"  type="text"/></td>
	</tr>	
	<tr class="odd">	
		<td>描述:</td>
		<td><input name="description"  type="text"/></td>
		<td>利率:</td>
		<td><input name="rate"  type="text"/></td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


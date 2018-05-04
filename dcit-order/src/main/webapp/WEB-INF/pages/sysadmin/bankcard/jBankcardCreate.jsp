<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>新增</title>
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
新增银行卡
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="tableHeader">
		<td>用户名：</td>
		<td><input name="username"  type="hidden" value="${customer.chname}"  />${customer.chname}</td>
		<td>身份证：</td>
		<td><input name="identitycard"  type="hidden" value="${customer.cardno}" />${customer.cardno}</td>
	</tr>
	<tr class="tableHeader">
	    <td >类型：</td>
		<td>
		   <input type="hidden" name="mold" value="0"/> 
			银行卡
		</td>	
		<td>密码：</td>
		<td><input name="password"  type="password"/></td>
	</tr>
	<tr class="tableHeader">
		<td>柜台：</td>
		<td><input name="userid"  type="hidden" value="${user.code}" />${user.username}</td>
		<td>网点：</td>
		<td><input name="websiteid"  type="hidden" value="${website.code}"/>${website.name}</td>
	</tr>
	<tr class="tableHeader">
		<td >是否挂失：</td>
		<td>
			<select name="report">
				<option  value="0">是</option>
				<option selected="selected" value="1">否</option>
			</select>
		</td>
		<td >是否冻结：</td>
		<td>
			<select name="frozen">
				<option  value="0">是</option>
				<option  selected="selected" value="1">否</option>
			</select>
		</td>
	</tr>
	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


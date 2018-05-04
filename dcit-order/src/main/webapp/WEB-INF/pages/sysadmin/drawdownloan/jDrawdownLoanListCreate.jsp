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
    新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="tableHeader">
		<td>贷款编号：</td>
		<td><input name="loancode"  type="hidden" value="${loan.loancode}"/>${loan.loancode}</td>
		<td>到款卡号：</td>
		<td><input name="bankcard"  type="hidden" value = "${loan.cardcode }"/>${loan.cardcode }</td>
	</tr>
	<tr class="tableHeader">
		<td>发放数额：</td>
		<td><input name="ffnumber"  type="hidden" value="${loan.moneynumber }"/>${loan.moneynumber }</td>
		<td>发放网点：</td>
		<td><input name="websitecode"  type="hidden" value="${website.id }"/>${website.name }</td>
	</tr>
	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


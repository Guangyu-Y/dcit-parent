<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>客户还贷</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('/returnLoan/returnloan','_self');this.blur();">还款</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    还贷信息列表
  </div> 

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="80%" >
	<tr class="odd">
		<td>贷款编号：</td>
		<td><input name="loancode"  type="text" value="${loan.loancode}" /></td>
		<!-- <input type="hidden"  name="loancode"/>  -->
		<td>贷款利率：</td>
		<td><input name="interstRate"  type="text" value="${loan.rate}" /></td>
	</tr>
	<tr class="odd">
		<td>还款人：</td>
		<td><input name="ReturnloanName"  type="text" value="${loan.customername }" /></td>
		<td>还款金额(剩余本金：${loan.balance })：</td>
		<input name="surplusnumber" value="${loan.balance }" type="hidden"/>
		<input name="starttime" value="${loan.createTime }" type="hidden"/>
		<td><input name="sumnumber"  type="text"/></td>
	</tr>
	
</table>

</script>
</body>
</html>
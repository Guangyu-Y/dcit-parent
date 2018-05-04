<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
	<script type="text/javascript">
		function check(){
			var yn = $("#status").text();
			 if(yn.trim()=='否'){
				alert("该贷款暂未发放，请发放后操作");
				formSubmit('/drawdownloan/tocreate','_self');
			}
			if(yn.trim()=='是'){
				formSubmit('returnloan','_self');
			} 
		}
	</script>
</head>

<body>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
<div id="navMenubar">
   <ul>
		<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
		<li id="delete" onclick="check();">还款</li>
		<li id="view" onclick="formSubmit('/returnLoan/loanReturnList','_self');this.blur();">明细</li>
	</ul>
</div>
</div>
</div>
</div>
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    	贷款详情
  </div> 
  
<div>


<div class="eXtremeTable" id = "parent1">
<center>
<form name="icform" method="post">
<input name="loanid" value="${one.loanid }" type="hidden">
<input name="loancode" value="${one.loancode }" type="hidden">
<table id="ec_table" class="tableBody" width="98%">
	<tr class="odd">
		<td style="width:20%">贷款编号</td>
		<td style="width:30%" >${one.loanid }</td>
		<td style="width:20%">贷款号</td>
		<td style="width:30%">${one.loancode}</td>
	</tr>
	<tr class="odd"> 
		<td >发放状态</td>
		<td id="status" value="${one.status}">${one.status} </td>
		<td >客户证件号</td>
		<td >${one.borrowCode} </td>
	</tr>
	<tr class="odd">	
		<td >客户类型</td>
		<td >${one.borrowType} </td>
		<td>客户姓名</td>
		<td>${one.customername }</td>
	</tr>
	<tr class="odd">
		<td >审批柜员</td>
		<td >${one.usercode} </td>
		<td >贷款金额</td>
		<td >${one.moneynumber}元 </td>
	</tr>
	<tr class="odd">
		<td >利率</td>
		<td >${one.rate} </td>
		<td >贷款周期</td>
		<td >${one.period}年 </td>
	</tr>
	<tr class="odd">
		<td >剩余本金</td>		
		<td >${one.balance }元 </td>
		<td >申请时间</td>		
		<td >${one.createTime} </td>
	</tr>
	<tr class="odd">
		<td >发放卡号</td>		
		<td >${one.cardcode} </td>
		<td >申请网点</td>
		<td >${one.websitecode} </td>
	</tr>
	

</table>
</center>
 </div>
 
</div>

</body>
</html>


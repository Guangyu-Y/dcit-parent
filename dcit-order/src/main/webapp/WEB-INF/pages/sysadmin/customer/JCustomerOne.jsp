<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    	客户详情
  </div> 
  
<div>


<div class="eXtremeTable" id = "parent1">
<center>
<table id="ec_table" class="tableRegion" width="98%">
	<tr>
		<td class="odd" style="width:50%">客户编号</td>
		<td class="odd" style="width:50%">${customer.id }</td>
	</tr>
	<tr>
		<td class="odd">中文名</td>
		<td class="odd">${customer.chname }</td>
	</tr>
	<tr>
		<td class="odd">英文名</td>
		<td class="odd">${customer.enname} </td>
	</tr>
	<tr>
		<td class="odd">客户账号</td>
		<td class="odd">${customer.code} </td>
	</tr>
	<tr>	
		<td class="odd">年龄</td>
		<td class="odd">${customer.age} </td>
	</tr>
	<tr>
		<td class="odd">性别</td>
		<td class="odd">${customer.sex} </td>
	</tr>
	<tr>
		<td class="odd">学历</td>
		<td class="odd">${customer.education} </td>
	</tr>
	<tr>
		<td class="odd">证件类型</td>
		<td class="odd">${customer.cardtype} </td>
	</tr>
	<tr>
		<td class="odd">证件号</td>
		<td class="odd">${customer.cardno} </td>
	</tr>
	<tr>
		<td class="odd">地区ID</td>
		<td class="odd">${customer.areaid} </td>
	</tr>
	<tr>
		<td class="odd">地区</td>		
		<td class="odd">${cityprovince.name }${citycity.name }${cityarea.name} </td>
	</tr>
	<tr>
		<td class="odd">地址</td>		
		<td class="odd">${customer.address} </td>
	</tr>
	
<!-- 
	<c:forEach items="${CustomerList}" var="c" varStatus="status">
	<tr class="odd" id="complete1" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="customerId" value="${c.id}"/></td>
		<td>${status.index+1}</td>
		<td>${c.id}</td>
		<td>${c.chname}</td>
		<td>${c.age}</td>
		<td>${c.sex}</td>
		<td>${c.cardno}</td>
		<td>${c.cardtype}</td>
		<td><a href="#" onclick="formSubmit('findOne','_self');this.blur();">查看详情</a></td>
		
	</tr>
	</c:forEach>
 -->
</table>
</center>
 </div>
 
</div>
 
 
</form>
</body>
</html>


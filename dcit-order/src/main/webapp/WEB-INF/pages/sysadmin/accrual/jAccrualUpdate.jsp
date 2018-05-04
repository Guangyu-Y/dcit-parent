<%@page import="com.dcit.pojo.Website"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>利率修改</title>
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
      利率修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" > 
	<tr class="odd">
		<td>类别：<input name="id"  type="hidden" value="${accrual.getId() }"/></td>
		<td>
			<select name="mtype" id="selecttype" style="width:30%">
				<c:choose>
					<c:when test="${0 eq accrual.getMtype() }">
						<option value="0" selected="selected">存款利率</option>
						<option value="1">贷款利率</option>
					</c:when>
					<c:when test="${1 eq accrual.getMtype() }">
						<option value="0">存款利率</option>
						<option value="1" selected="selected">贷款利率</option>
					</c:when>
				</c:choose> 
			</select>
		</td>
		<td>时长：</td>
		<td><input name="month"  type="text" value="${accrual.getMonth() }"/></td>
	</tr>	
	<tr class="odd">	
		<td>描述：</td>
		<td><input name="description"  type="text" value="${accrual.getDescription() }"/></td>
		<td>利率：</td>
		<td><input name="rate"  type="text" value="${accrual.getRate() }"/></td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


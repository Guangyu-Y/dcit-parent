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
	<li id="view"><a href="#" onclick="formSubmit('update','_self');this.blur();">保存</a></li>
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
	<c:if test="${not empty bankcard}">
	<tr class="tableHeader">
		<td>用户名：</td>
		<td><input name="username"  type="text" value="${bankcard.username }" disabled="disabled"/></td>
		<td>身份证：</td>
		<td><input name="identitycard"  type="text" value="${bankcard.identitycard }" disabled="disabled"/></td>
		<td>银行卡号：</td>
		<td><input name="cardno"  type="text" value="${bankcard.cardno }"/></td>
		<td>密码：</td>
		<td><input name="passworfd"  type="password" value="${bankcard.passworfd }"/></td>
	</tr>
	<tr class="tableHeader">
		<td>柜台：</td>
		<td><input name="userid"  type="text" value="${bankcard.userid }" disabled="disabled"/></td>
		<td>网点：</td>
		<td><input name="websiteid"  type="text" value="${bankcard.websiteid }" disabled="disabled"/></td>
		<td >是否挂失：</td>
		<td>
			<select name="report">
				<c:choose>
					<c:when test="${bankcard.report=='是'}">
						<option value="是" selected="selected">是</option>
						<option value="否" >否</option>
					</c:when>
					<c:otherwise>
						<option value="是" >是</option>
						<option value="否" selected="selected">否</option>
					</c:otherwise>
				</c:choose>		
			</select>
		</td>
		<td >是否冻结：</td>
		<td>
			<select name="frozen">
				<c:choose>
					<c:when test="${bankcard.frozen=='是'}">
						<option value="是" selected="selected">是</option>
						<option value="否" >否</option>
					</c:when>
					<c:otherwise>
						<option value="是" >是</option>
						<option value="否" selected="selected">否</option>
					</c:otherwise>
				</c:choose>	
			</select>
		</td>
	</tr>
	<tr class="tableHeader">
		<td >银行卡所属类型：</td>
		<td><input name="mtype"  type="text" value="${bankcard.mtype }"/></td>
		<td >银行卡或存折：</td>
		<td>
			<select name="balance">
			<c:choose>
					<c:when test="${bankcard.balance=='1'}">
						<option value="1"  selected="selected">存折</option>
						<option value="0" >银行卡</option>
					</c:when>
					<c:otherwise>
					<option value="1"  >存折</option>
						<option value="0" selected="selected">银行卡</option>
					</c:otherwise>
				</c:choose>			
			</select>
		</td>
		<td >状态：</td>
		<td><input name="state"  type="text" value="${bankcard.state }"/></td>
		<td >备注：</td>
		<td><input name="info"  type="text" value="${bankcard.info }"/></td>	
	</tr>
	<input name="id"  type="hidden" value="${bankcard.id}"/>
	</c:if>
</table>
</div>
</div> 
</form>
</body>
</html>


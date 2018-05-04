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
	<li id="view"><a href="#" onclick="formSubmit('create','_self');this.blur();">保存</a></li>
	<li id="new"><a href="#" onclick="formSubmit('list','_self');this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
客户校验
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="tableHeader">
		<td>身份证：</td>
		<td><input name="identitycard"  type="text"/></td>
			<c:if test="${not empty customer}">
				<c:if test="${empty account}">
					<script type="text/javascript">
						alert("该用户未开户！");
					</script>
				</c:if>
			</c:if>
			<c:if test="${empty customer}">
				<script type="text/javascript">
					alert("用户名不存在！");
				</script>
			</c:if>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


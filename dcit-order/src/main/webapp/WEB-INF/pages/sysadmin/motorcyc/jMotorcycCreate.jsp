<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>尾箱新增</title>
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
    尾箱新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd"> 
		<td>尾箱用户代号：</td>
		<td>
			<select name="usercode" style="width:200px">
				<c:forEach items="${tellers}" var="u" varStatus="status">
					<option value ="${u.code}">用户名：${u.username} 编号：${u.code}</option>
				</c:forEach>
			</select>
		</td>
		
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


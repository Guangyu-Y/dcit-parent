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
	<li id="view"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>模块名称：</td>
		<td><input name="name"  type="text" value="${ module.name }"/>
			<input type="hidden" name="id" value="${ module.id }">
		</td>
	</tr>
	
	<tr class="odd">
		<td>模块描述：</td>
		<td><input name="description"  type="text" value="${ module.description }"/>
		</td>
	</tr>
	
	<tr class="odd">
		<td>上级模块：</td>
		<td>
			<select name="parentid" style="width:121px">
				<option value="0">---请选择/无上级---</option>
				<c:forEach items="${ parentModuleList }" var="m">
					<option value="${ m.id }" <c:if test="${ module.parentid==m.id }">selected="selected"</c:if>>${ m.name }</option>
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


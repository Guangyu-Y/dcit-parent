<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>地区修改</title>
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
    地区修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>上级地区:</td>
	    <td>
	    	<select name="parentid" style="width:155px">
				<option value="${parentCity.id}" >${parentCity.name}</option>
				<c:forEach items="${cityList}" var="c" varStatus="status">
					<option value="${c.id}">${c.name}</option>
				</c:forEach>
	    	</select>
	    </td>
		<td>地区：</td>
		<td><input name="name"  type="text" value="${city.name}"/></td>
		<td><input name="id"  type="hidden" value="${city.id}"/></td>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


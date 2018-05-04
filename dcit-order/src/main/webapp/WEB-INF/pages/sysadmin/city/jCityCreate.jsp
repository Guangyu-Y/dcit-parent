<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title>新增地区</title>
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
    新增地区
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
	    <td>上级地区:</td>
	    <td>
	    	<select name="id" style="width:155px">
				<option value="0" >请选择</option>
				<c:forEach items="${cityList}" var="c" varStatus="status">
					<c:choose>
   						<c:when test="${c.code=='1'}">  
        				 	<option value="${c.id}">${c.name}</option>       
  						</c:when>
  						<c:when test="${c.code=='2'}">  
        				 	<option value="${c.id}">&nbsp;&nbsp;${c.name}</option>       
  						</c:when>
  						<c:when test="${c.code=='3'}">  
        				 	<option value="${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;${c.name}</option>       
  						</c:when>
  						<c:when test="${c.code=='4'}">  
        				 	<option value="${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.name}</option>       
  						</c:when>
  						<c:when test="${c.code=='5'}">  
        				 	<option value="${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.name}</option>       
  						</c:when>
  						<c:when test="${c.code=='6'}">  
        				 	<option value="${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.name}</option>       
  						</c:when>
   						<c:otherwise> 
   							<option value="${c.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${c.name}</option>
   						</c:otherwise>
					</c:choose>	
				</c:forEach>
	    	</select>
	    </td>
		<td>地区：</td>
		<td><input name="name"  type="text"/></td>
	</tr>
	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户新增</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	  $("#ec_table tr:even").css("background-color","#F4F4F4");
	  $("#ec_table tr").css("font-size","25px");
	});
</script>
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
    用户查看
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>用户名：</td>
		<td>${ user.username }</td>
		<td>密码：</td>
		<td>******</td>
	</tr>
	<tr class="odd">
		<td>所属部门：</td>
		<td>
			${ user.dept.deptName }
		</td>
		<td>真实姓名：</td>
		<td>${ user.userInfo.name }</td>
	</tr>
	<tr class="odd">
		<td>身份证号：</td>
		<td>${ user.userInfo.cardNo }</td>
		<td>直属领导：</td>
		<td>
			<c:if test="${ user.userInfo.manager.name==null }">无</c:if>	
			<c:if test="${ user.userInfo.manager.name!=null }">${ user.userInfo.manager.name }</c:if>	
			
		</td>
	</tr>
	<tr class="odd">
		<td>入职时间：</td>
		<td><fmt:formatDate value="${ user.userInfo.joinDate }" pattern="yyyy-MM-dd"/></td>
		<td>薪水：</td>
		<td>${ user.userInfo.salary }</td>
	</tr>
	
	<tr class="odd">
		<td>生日：</td>
		<td><fmt:formatDate value="${ user.userInfo.birthday }" pattern="yyyy-MM-dd"/></td>
		<td>性别：</td>
		<td>${ user.userInfo.gender }
		</td>
	</tr>
	
	<tr class="odd">
		<td>岗位：</td>
		<td>${ user.userInfo.station }</td>
		<td>电话：</td>
		<td>${ user.userInfo.telephone }</td>
	</tr>
	
	<tr class="odd">
		<td>等级：</td>
		<td>
			<c:if test="${ user.userInfo.userLevel==4 }">普通用户</c:if>
			<c:if test="${ user.userInfo.userLevel==3 }">部门经理</c:if>
			<c:if test="${ user.userInfo.userLevel==2 }">副总</c:if>
			<c:if test="${ user.userInfo.userLevel==1 }">总经理</c:if>
		</td>
		<td>排序号：</td>
		<td>${ user.userInfo.orderNo }</td>
	</tr>
	
	<tr class="odd">
		<td>状态：</td>
		<td>
		<c:if test="${ user.state==1 }"><font color="green">启用</font></c:if>
			<c:if test="${ user.state==0 }"><font color="red">停用</font></c:if>
		</td>
		<td>其他</td>
		<td>无</td>
	</tr>
	<tr class="odd">
		<td>备注信息：</td>
		<td colspan="3">
			${ user.userInfo.remark }
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


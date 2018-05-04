<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>模块介绍</title>
  	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/staticfile/skin/default/css/main.css" media="all"/>
</head>
<style>
body{
background: url("../../staticfile/skin/default/images/1232.jpg");
width:100%;
height:100%;
overflow:hidden;
background-size:100% 100%; 
}
</style>
<body>
<form>
<div class="textbox"></div>

	<div class="modelDiv">

        <table class="modelTable" cellspacing="1">
        	<tr>
        		<td colspan="2" class="modelTitle">客户管理模块介绍</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle" width="100">开户</td>
        		<td class="model_intro_right">根据客户id的开通账户。
				</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">开户列表</td>
        		<td class="model_intro_right">查询所有的账户信息。<br></td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">添加客户</td>
        		<td class="model_intro_right">客户信息的添加功能。
        		<!-- 修改走货状态：1)合同新增货物、修改货物 2)报运货物修改、删除货物、增补货物、删除报运 -->
        		</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">客户列表</td>
        		<td class="model_intro_right">查询所有的客户信息。<br></td>
        	</tr>
        	
			<tfoot>
				<tr>
					<td colspan="2" class="tableFooter"></td>
				</tr>
			</tfoot>
        </table>
 
	</div>
</form>
</body>

</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp" %>
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
        		<td colspan="2" class="modelTitle">存折管理模块介绍</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle" width="69">利息列表</td>
        		<td class="model_intro_right">查询存款的时间对应的利率。
				</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle" width="69">添加存折</td>
        		<td class="model_intro_right">存折的添加功能<br></td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">存折列表</td>
        		<td class="model_intro_right">查询出所有的存折信息。
        		<!-- 修改走货状态：1)合同新增货物、修改货物 2)报运货物修改、删除货物、增补货物、删除报运 -->
        		</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">存折明细列表</td>
        		<td class="model_intro_right">查询所有的存折明细信息。<br></td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">存折存款</td>
        		<td class="model_intro_right">用存折进行存款相关操作。<br></td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">存折取款</td>
        		<td class="model_intro_right">用存折进行取款相关操作。<br></td>
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
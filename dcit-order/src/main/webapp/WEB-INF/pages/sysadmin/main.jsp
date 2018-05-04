<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>权限管理</title>
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
        		<td colspan="2" class="modelTitle">权限管理介绍</td>
        	</tr>
        	
        	<tr>
        		<td colspan="2" class="model_intro_right">包括用户管理、角色管理和模块管理，通过给用户分配角色，给角色分配模块，来达到权限控制的目的</td>
        	</tr>
        	<tr>
				<td class="subModelTitle" width="69">用户管理</td>
				<td class="model_intro_right">包括用户的新增、修改、删除、查询，以及对用户进行角色的分配
				</td>
				
				
			</tr>  
        	      	
			<tr>
				<td class="subModelTitle" >角色管理</td>
				<td class="model_intro_right">角色的新增、修改、删除、查询、以及对角色进行模块的分配,主要角色有普通柜员、管理员、系统管理员等。<br>每个角色拥有不同的权限, 支持细粒度权限控制分配(菜单、按钮、状态、功能点)。</td>
        	</tr>        	
			<tr>
				<td class="subModelTitle" width="69">模块管理</td>
				<td class="model_intro_right">模块的新增、修改、删除、查询，主要模块有地区管理、网点管理、客户管理、银行卡管理、存折管理等。<br>可管理一级菜单、二级菜单、按钮等权限。</td>
			</tr>
			
			
			<tfoot>
				<tr>
					<td colspan="2" ></td>
				</tr>
				<br/>
			</tfoot>
        </table>
 
	</div>
</form>
</body>

</html>
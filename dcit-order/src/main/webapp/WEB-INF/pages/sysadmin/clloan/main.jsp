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
        		<td colspan="2" class="modelTitle">网点管理模块介绍</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle" width="100">添加网点</td>
        		<td class="model_intro_right">网点的添加功能。
				</td>
        	</tr>
        	<tr>
        		<td class="subModelTitle">网点列表</td>
        		<td class="model_intro_right">查询所有的网点信息。<br></td>
        	</tr>
        	
        	<tr>
        		<td class="subModelTitle">尾箱列表</td>
        		<td class="model_intro_right">查询所有的尾箱信息。<br></td>
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
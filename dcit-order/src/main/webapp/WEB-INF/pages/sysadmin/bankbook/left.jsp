<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/staticfile/skin/default/css/left.css" media="all"/>
</head>
 
<body id="left_frame">
<div class="PositionFrame_black" id="PositionFrame"></div>
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/staticfile/skin/default/images/icon/cubes.png"/></div>
        <div class="panel-header">
        <div class="panel-title">存折管理</div>
        <div class="panel-content">
			<ul>
			    <<shiro:hasPermission name="利息列表"> 
			     <li><a href="${ctx}/accrual/list" onclick="linkHighlighted(this)" target="main" id="aa_1">利率列表</a></li>
			     </shiro:hasPermission>
			     
			    <shiro:hasPermission name="存折添加"> 
				<li><a href="${ctx}/bankbook/tocreate" onclick="linkHighlighted(this)" target="main" id="aa_1">添加存折</a></li>
				</shiro:hasPermission>
				
				<li><a href="${ctx}/bankbook/list" onclick="linkHighlighted(this)" target="main" id="aa_1">存折列表</a></li>
				<shiro:hasPermission name="存折明细列表"> 
				<li><a href="${ctx}/bankbookdetail/list" onclick="linkHighlighted(this)" target="main" id="aa_1">存折明细列表</a></li>
				</shiro:hasPermission>
				<shiro:hasPermission name="存折存款"> 
				<li><a href="${ctx}/bankbookdetail/tosavemoney" onclick="linkHighlighted(this)" target="main" id="aa_1">存折存款</a></li>
				</shiro:hasPermission>
				
				<shiro:hasPermission name="存折取款"> 
				<li><a href="${ctx}/bankbookdetail/towithdrawal" onclick="linkHighlighted(this)" target="main" id="aa_1">存折取款</a></li>
				</shiro:hasPermission>
			</ul>
        </div>
        </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>  
</div>	


</body>
</html>

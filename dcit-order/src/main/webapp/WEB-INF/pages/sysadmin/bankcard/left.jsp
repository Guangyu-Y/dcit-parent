<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
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
        <div class="panel-title">银行卡管理</div>
        <div class="panel-content">
			<ul>
				<li><a href="${ctx}/bankcard/tocreate" onclick="linkHighlighted(this)" target="main" id="aa_1">添加银行卡</a></li>
				<li><a href="${ctx}/bankcard/list" onclick="linkHighlighted(this)" target="main" id="aa_1">银行卡列表</a></li>
				<li><a href="${ctx}/bankcarddetail/list" onclick="linkHighlighted(this)" target="main" id="aa_1">银行卡明细列表</a></li>
				<li><a href="${ctx}/bankcarddetail/tosavemoney" onclick="linkHighlighted(this)" target="main" id="aa_1">银行卡存款</a></li>
				<li><a href="${ctx}/bankcarddetail/towithdrawal" onclick="linkHighlighted(this)" target="main" id="aa_1">银行卡取款</a></li>
				<li><a href="${ctx}/bankcarddetail/totransfer" onclick="linkHighlighted(this)" target="main" id="aa_1">银行卡转账</a></li>
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

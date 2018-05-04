<%@page import="com.dcit.pojo.Website"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>网点详情</title>
</head>

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
  网点详情
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr class="odd"> 
		<td class="tableHeader">网点代号</td>
		<td class="tableHeader">网点名称</td>
	</tr>
	<tr class="odd">
		<td>${website.getCode()}</td>
		<td>${website.getName()}</td>
	</tr>	
	<tr class="odd">
		<td class="tableHeader">网点级别</td>
		<td class="tableHeader">是否交易机构</td>
	</tr>	
	<tr class="odd">
		<c:choose>
			<c:when test="${0 eq website.getMlevel()}">
				<td>总行</td>  	
			</c:when>
			<c:when test="${1 eq website.getMlevel()}">
				<td>分行</td>  	
			</c:when>
			<c:when test="${2 eq website.getMlevel()}">
				<td>支行</td>  	
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${0 eq website.getIsorg()}">
				<td>是</td>  	
			</c:when>
			<c:when test="${1 eq website.getIsorg()}">
				<td>否</td>  	
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose> 
	</tr>
	<tr class="odd">	
		<td class="tableHeader">客服电话</td>
		<td class="tableHeader">地区代号</td>
	</tr>	
	
	<tr class="odd">
	
		<td>${website.getPhone()}</td> 
		<td>${website.getAreaId()}</td>
	</tr>	
	<tr class="odd">
		<td class="tableHeader">状态</td>
		<td class="tableHeader">地址</td>
	</tr>
	<tr class="odd">
		
		<c:choose>
			<c:when test="${0 eq website.getStatus()}">
				<td>开启</td>  	
			</c:when>
			<c:when test="${1 eq website.getStatus()}">
				<td>关闭</td>  	
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose>
		<td>${website.getAddress()}</td>
		
	</tr>
	<tr class="odd">
		<td class="tableHeader">建立日期</td> 
		<td class="tableHeader">更新日期</td>
	</tr>	
	<tr class="odd">
		<td>${website.getCreatetime()}</td>
		<td>${website.getUpdatetime()}</td> 
	</tr>
	<tr class="odd">
		<td class="tableHeader">网点介绍</td>  
	</tr>	
	<tr class="odd">
		<td>${website.getDescription()}</td>
	</tr>
	 
	<tbody class="tableBody" >
	 
	
</table>
<script>
        $(document).ready(function() {
            var $table = $('table');
            var currentPage = 0;     //当前页索引
            var pageSize = 10;    //每页行数（不包括表头）
            $table.bind('paging',function(){
                //绑定分页事件
                //隐藏所有的行，取出当前页的行显示
                $table.find('tbody tr').hide().slice(currentPage*pageSize,(currentPage + 1)*pageSize).show();
            });
            var sumRows = $table.find('tbody tr').length;    //记录总行数
            var sumPages = Math.ceil(sumRows/pageSize);//总页数
            var $pager = $("<div class='page'></div>");//分页div
            $pager.append("第");
            for(var pageIndex = 0;pageIndex < sumPages;pageIndex++){
                //为分页标签加上链接
                $("<a href='#'><span>"+(pageIndex+1)+"</span></a>").bind('click',{'newPage':pageIndex},function(event){
                    currentPage = event.data["newPage"];
                    $table.trigger('paging');
                }).appendTo($pager);
                $pager.append("  ");
            }
            $pager.append("页");
            $pager.insertAfter($table);        //分页
            $table.trigger('paging');      //触发分页事件
            
        });
        
</script>
</div>
 
</div>
 
 
</form>
</body>
</html>


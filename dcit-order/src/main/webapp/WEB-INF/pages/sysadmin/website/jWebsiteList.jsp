<%@page import="com.dcit.pojo.Website"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>网点列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<shiro:hasPermission name="网点添加"><li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li></shiro:hasPermission>
	<shiro:hasPermission name="网点修改"><li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li></shiro:hasPermission>
	<shiro:hasPermission name="网点删除"><li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li></shiro:hasPermission>
	
</ul>
  </div>
</div>
</div> 
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
  网点列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('websiteId',this)"></td>
		<td class="tableHeader">网点代号</td>
		<td class="tableHeader">网点名称</td>
		<td class="tableHeader">网点级别</td> 
		<td class="tableHeader">状态</td>
		<td class="tableHeader">网点介绍</td>
		<td class="tableHeader">地址</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${websiteList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="websiteId" value="${u.id}"/></td>
		<td>${u.getCode()}</td>
		<td>${u.getName()}</td>
		<c:choose>
			<c:when test="${0 eq u.getMlevel()}">
				<td>总行</td>  	
			</c:when>
			<c:when test="${1 eq u.getMlevel()}">
				<td>分行</td>  	
			</c:when>
			<c:when test="${2 eq u.getMlevel()}">
				<td>支行</td>  	
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${0 eq u.getStatus()}">
				<td>开启</td>  	
			</c:when>
			<c:when test="${1 eq u.getStatus()}">
				<td>关闭</td>  	
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose>
		
		<td>${u.getDescription()}</td>
		<td>${u.getAddress()}</td> 
		<td><a href="info?websiteId=${u.id}" >查看详情</a></td> 
		
	</tr>
	</c:forEach>
	
	</tbody>
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


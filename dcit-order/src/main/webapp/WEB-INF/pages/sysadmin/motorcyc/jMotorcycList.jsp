<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>尾箱操作列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<shiro:hasPermission name="尾箱添加"><li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li></shiro:hasPermission>
	<shiro:hasPermission name="尾箱修改"><li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li></shiro:hasPermission>
	<shiro:hasPermission name="尾箱删除"><li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li></shiro:hasPermission>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    尾箱信息列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">尾箱用户</td>
		<td class="tableHeader">所属网点</td>
		<td class="tableHeader">IP地址</td>
		<td class="tableHeader">现金</td>
		<td class="tableHeader">创建时间</td>
		<td class="tableHeader">上次更新时间</td>
		<td class="tableHeader">操作记录</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${motorcycList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${u.id}"/></td>
		<td>${status.index+1}</td>
		<td>${u.username}</td>
		<td>
		  <c:if test="${u.website==null}">==</c:if>
		  <c:if test="${u.website!=null}">${u.website.name}</c:if>
		</td>
		<td>${u.localip}</td>
		<td>${u.money}</td>
		<td>${u.createtime}</td>
		<td>${u.updatetime}</td>
		<td><a href="listMotorcycOpeInfo/?motorcycid=${u.id}&username=${u.username}">单击查询</a></td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
 
<script>
   $(document).ready(function() {
       var $table = $('table');
       var currentPage = 0;     //当前页索引
       var pageSize =5;    //每页行数（不包括表头）
       $table.bind('paging',function(){
           //绑定分页事件
           //隐藏所有的行，取出当前页的行显示
           $table.find('tbody tr').hide().slice(currentPage*pageSize,(currentPage + 1)*pageSize).show();
       });
       var sumRows = $table.find('tbody tr').length;    //记录总行数
       var sumPages = Math.ceil(sumRows/pageSize);//总页数
       var $pager = $("<div class='page'></div>");//分页div
       $pager.append("第 ");
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
</body>
</html>


<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>还贷详情</title>
</head>

<body>

<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="/clloan/list" >返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    还贷信息列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">贷款编号</td>
		<td class="tableHeader">还款日</td>
		<td class="tableHeader">还款金额</td>
		<td class="tableHeader">剩余款</td>
		<td class="tableHeader">利息</td>
		<td class="tableHeader">还款网点</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${loanReturnList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${u.returnid}"/></td>
		<td>${status.index+1}</td>
		<td>${u.loancode}</td>
		<td>${u.returndate}</td>
		<td>${u.sumnumber}</td>
		<td>${u.surplusnumber}</td>
		<td>${u.interest}</td>
		<td>${u.websitecode}</td>
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
       var pageSize =10;    //每页行数（不包括表头）
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


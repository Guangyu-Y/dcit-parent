<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>账户列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增账户</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除账户</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    账户列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">网点</td>
		<td class="tableHeader">柜员姓名</td>
		<td class="tableHeader">客户号</td>
		<td class="tableHeader">账户</td>
		<td class="tableHeader">创建时间</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${accountList}" var="a" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="accountId" value="${a.id}"/></td>
		<td>${status.index+1}</td>
		<td>
		<c:if test="${a.website==null}">===</c:if>
		<c:if test="${a.website!=null}">${a.website.name}</c:if>
		</td>
		<td>
		 <c:if test="${a.user == null}">===</c:if>
		  <c:if test="${a.user!= null}">${a.user.username}</c:if>
		</td>
		<td>
		 <c:if test="${a.customer==null }">===</c:if>
		 <c:if test="${a.customer!=null }">${a.customer.chname}</c:if> 
		</td>
		<td>${a.createcode }</td>
		<td>${a.createtime}</td>
		
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

</div>
 
</div>
 
 
</form>
</body>
</html>


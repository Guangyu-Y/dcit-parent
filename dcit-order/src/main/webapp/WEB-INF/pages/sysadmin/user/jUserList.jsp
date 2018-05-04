<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li>
	<li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li>	
	<li id="new"><a href="#" onclick="formSubmit('toUserRole','_self');this.blur();">角色</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">代号</td>
		<td class="tableHeader">用户名</td>
		<td class="tableHeader">状态</td>
		<td class="tableHeader">身份证号</td>
		<td class="tableHeader">性别</td>
		<td class="tableHeader">学历</td>
		<td class="tableHeader">出生日期</td>
		<td class="tableHeader">创建时间</td>
		<td class="tableHeader">所属网点名称</td>
		<td class="tableHeader">所属网点IP</td>
		<td class="tableHeader">上次登录时间</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${userList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="userId" value="${u.id}"/></td>
		<td>${status.index+1}</td>
		<td>${u.code}</td>
		<td>${u.username}</td>
		<td><a href="changeStatus/?status=${u.status}&id=${u.id}"> 
			<c:if test="${u.status  eq '1'}">激活
            </c:if>
            <c:if test="${u.status  eq '0'}">停用
            </c:if>
		</a></td>
		<td>${u.card}</td>
		<td>${u.age}</td>
		<td>${u.education}</td>
		<td>${u.birthday}</td>
		<td>${u.createtime}</td>	
		<td>
		<c:if test="${u.website==null }">==</c:if>
		<c:if test="${u.website!=null }">${u.website.name}</c:if>
		</td>
		<td>${u.localip}</td>
		<td>${u.lastlogin}</td>
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
<script>
	function changeStatus(status,id){
	  url = "changeStatus/"
	  $.post(url,
		     {
		      status:status,
		      id:id
		     },
		     function(data,status){
		    	 alert("Data: " + data + "\nStatus: " + status);
		     });
	   }
</script>
</html>


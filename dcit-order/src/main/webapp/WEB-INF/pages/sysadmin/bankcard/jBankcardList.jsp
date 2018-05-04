<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<shiro:hasPermission name="银行卡添加"> <li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li></shiro:hasPermission>
	<shiro:hasPermission name="银行卡修改"> <li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li></shiro:hasPermission>
	<shiro:hasPermission name="银行卡删除"> <li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li></shiro:hasPermission>	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
  	银行卡列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">用户名</td>
		<td class="tableHeader">身份证</td>
		<td class="tableHeader">银行卡号</td>
		<td class="tableHeader">办卡时间</td>
		<td class="tableHeader">柜台</td>
		<td class="tableHeader">网点</td>
		<td class="tableHeader">是否挂失</td>
		<td class="tableHeader">是否冻结</td>
		<td class="tableHeader">状态</td>
		<td class="tableHeader">备注</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	<c:if test="${not empty bankcardList}">
	<c:forEach items="${bankcardList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${u.id}"/></td>
		<td>${u.username}</td>
		<td>${u.identitycard}</td>
		<td>${u.cardno}</td>
		<td>${u.createtime}</td>
		<td>
			<c:if test="${u.user ==null}">===</c:if>
		<c:if test="${u.user!=null}">${u.user.username}</c:if>
		</td>
		<td>
		<c:if test="${u.website==null}">===</c:if>
		<c:if test="${u.website!=null}">${u.website.name}</c:if>
		</td>
		<td>
		<c:if test="${u.report=='0'}">是</c:if>
		<c:if test="${u.report=='1'}">否</c:if>
		</td>
		<td>
		<c:if test="${u.frozen=='0'}">是</c:if>
		<c:if test="${u.frozen=='1'}">否</c:if>
		</td>
		<td>${u.state}</td>
		<td>${u.info}</td>		
	</tr>
	</c:forEach>
	</c:if>
	
	</tbody>
</table>
<script type="text/javascript">
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


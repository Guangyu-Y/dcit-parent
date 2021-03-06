<%@page import="com.dcit.pojo.Website"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
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
	<li id="new"><a href="#" onclick="formSubmit('tocreate','_self');this.blur();">新增</a></li>
	
	<li id="update"><a href="#" onclick="formSubmit('toupdate','_self');this.blur();">修改</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('delete','_self');this.blur();">删除</a></li>
	
</ul>
  </div>
</div>
</div> 
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
  利息列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('accrualId',this)"></td>
		<td class="tableHeader">时长</td>
		<td class="tableHeader">周期</td>		
		<td class="tableHeader">利率</td>
		<td class="tableHeader">利率类型：
			<select name="type" id="selecttype" style="width:30%" onchange="getAccrual(this.value,'accrual')"> 
				<c:choose>
					<c:when test="${0 eq type}">
						<option value="2">--请选择--</option>
						<option value="0" selected="selected">存款</option>
						<option value="1">贷款</option>
					</c:when>
					<c:when test="${1 eq type}">
						<option value="2">--请选择--</option>
						<option value="0">存款</option>
						<option value="1" selected="selected">贷款</option>
					</c:when>
					<c:otherwise>
						<option value="2">--请选择--</option>
						<option value="0">存款</option>
						<option value="1">贷款</option>
					</c:otherwise>
				</c:choose> 
			</select>
			<input type="button" value="查询" onclick="formSubmit('select','_self');this.blur();" /> 
		</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${accrualList}" var="accrual" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="accrualId" value="${ accrual.getId() }"/></td>
		<td>${accrual.getMonth()}</td>
		<td>${accrual.getDescription()}</td> 
		<td>${accrual.getRate()}%</td>

		<c:choose> 
			<c:when test="${0 eq accrual.getMtype()}">
				<td>存款</td>  	 
			</c:when>
			<c:when test="${1 eq accrual.getMtype()}">
				<td>贷款</td>  	 
			</c:when>
			<c:otherwise>
				<td>---</td>  
			</c:otherwise>
		</c:choose> 
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


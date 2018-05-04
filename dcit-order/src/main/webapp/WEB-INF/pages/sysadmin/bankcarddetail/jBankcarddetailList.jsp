<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>银行卡明细列表</title>
</head>

<script type="text/javascript">
   function search(){
	   alert("执行该方法");
   }
</script>


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
    银行卡明细列表
  </div> 
  
<div>


<div class="eXtremeTable" >
账号号：<input type="text" name="searchbankcardid" value="${searchbankcardid}"> 
类型：<select name="searchtype">
     <option value="0">====</option>
      <option value="1" <c:if test="${searchtype!=null&&searchtype=='1'}">selected='selected'</c:if>>存钱</option>
      <option value="2" <c:if test="${searchtype!=null&&searchtype=='2'}">selected='selected'</c:if>>取款</option>
      <option value="3" <c:if test="${searchtype!=null&&searchtype=='3'}">selected='selected'</c:if>>转账</option>
      <option value="4" <c:if test="${searchtype!=null&&searchtype=='4'}">selected='selected'</c:if>>被转账</option>
      
   </select>
<input type="button" value="查询" onclick="formSubmit('tosearch','_self');"/>

<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('userId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">账户卡号</td>
		<td class="tableHeader">类型</td>
		<td class="tableHeader">金额</td>
		<td class="tableHeader">经办人</td>
		<td class="tableHeader">网点</td>
		<td class="tableHeader">对方账户卡号</td>
		<td class="tableHeader">对方账户名</td>
		<td class="tableHeader">创建时间</td>
		<td class="tableHeader">状态</td>
		<td class="tableHeader">备注</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${bankcarddetailList}" var="b" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="bankcarddetailId" value="${b.id}"/></td>
		<td>${status.index+1}</td>
		<td>${b.bankcardid}</td>
		<td>
		  <c:if test="${b.type==1 }">存钱</c:if>
		  <c:if test="${b.type==2}">取钱</c:if>
		  <c:if test="${b.type==3}">转账</c:if>
		  <c:if test="${b.type==4}">收到转账</c:if>
		</td>
		
		<td>
		<c:if test="${b.money==null}">未知</c:if>
		<c:if test="${b.money!=null}">${b.money}</c:if>
	   </td>
	   <td>
		<c:if test="${b.user==null}">未知</c:if>
		<c:if test="${b.user!=null}">${b.user.username}</c:if>
	   </td>
	   <td>
		<c:if test="${b.website==null}">未知</c:if>
		<c:if test="${b.website!=null}">${b.website.name}</c:if>
	   </td>
		<td>
		<c:if test="${b.eachbankcardno ==null}">---</c:if>
		<c:if test="${b.eachbankcardno !=null}">${b.eachbankcardno}</c:if></td>
		<td>
		<c:if test="${b.eachname ==null}">----</c:if>
		<c:if test="${b.eachname!=null}">${b.eachname}</c:if>
		</td>
		<td>
		    ${b.createtime}
		</td>
		<td>
		<c:if test="${b.state =='0'}">成功</c:if>
		<c:if test="${b.state =='1'}">失败</c:if>
		</td>
		<td>
		<c:if test="${b.info ==null}">--</c:if>
		<c:if test="${b.info !=null}">${b.info }</c:if>
		</td>
	</tr>
	</c:forEach>
	
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


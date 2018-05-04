<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>开立贷款</title>
	
<script type="text/javascript">
	function clear() {
		var city = document.getElementById("card");
		//清空所有option
		city.length = 0;
		city.options[0] = new Option("==请选择银行卡==", 0);
	}
	function getCard(){
		var idcard = document.getElementById("idcard").value;
		$.ajax({
			type:"post",
			url:"GetCard",
			data:{idcard:idcard},
			datatype:"json",
			success:function(data){
		    		//判断对象状态，readyState为对象执行状态，status为服务器返回码，如我们常见的404、500，200表示成功
		    	if (data.status == 400) {
		    			//得到服务器回应文本
		  			var dat=data.data;
		    		var str="";
		    		for(var i=0;i<dat.length;i++)
		    		{
		    			str+="<option value='"+dat[i].cardno+"'>"+dat[i].cardno+"</option>";
		    		}
					clear();
		    		$("#card").append(str);
		    	}else{
		    		alter("该用户没有银行卡，请先申请");
		    	}
		    }
		});
		
	}
</script>
	
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    申请贷款
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>证件号：</td>
		<td><input name="borrowCode" id="idcard"  type="text" onchange="getCard()"></td>
		<td>贷款类型：</td>
		<td>
			<select name="borrowType" style="width:30%">
				<option value="个人">个人</option>
				<option value="企业">企业</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td> 贷款金额：</td>
		<td><input name="moneynumber" type="text">
		<td> 贷款周期：</td>
		<td><input name="period" type="text">年
	</tr>
	<tr class="odd">
		<td>请选择贷款人的卡号：</td>
		<td>
			<select name="cardcode" id="card" style="width:30%">
				<option value="">--请选择银行卡--</option>
			</select>
		</td>
	</tr>
	
	
</table>
</div>
 
</div>
 
 
</form>



</body>
</html>


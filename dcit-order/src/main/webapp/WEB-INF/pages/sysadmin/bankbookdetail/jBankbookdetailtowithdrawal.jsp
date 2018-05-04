<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>存折明细新增</title>
</head>
 <script type="text/javascript">
 function formSubmit1(url,sTarget){
	    var flag=true;
	    var eachflag=true;
	    var type=$("#type").val();
		//ajax判断账号 密码是否正确
		if(type!="3")
		{
			//alert("1111");
		   flag = judgemypassword();
		}
		//如果是转账 判断对方卡号和账户
		if(type=="3")
		{
			eachflag = judgeeach();
			
		}
	
		if(flag&&eachflag)
	    {
			document.forms[0].target = sTarget
		    document.forms[0].action = url;
		    document.forms[0].submit();
		    return true; 
	    }else{
	    	return false;
	    }
	    
	}
 
 
   function judgeeach()
   {
	  
	   var flag=0;
	   var eachbankcardno=$("#eachbankcardno").val();
	   var eachname = $("#eachname").val();
	   $.ajax({
	          type: "POST",
	          url: "/bankbookdetail/judgeeach",
	          data: {eachbankcardno:eachbankcardno, eachname:eachname},
	          dataType: "json",
	          async:false,
	          success: function(data){
	        	  //alert(data.msg);
	        	  if(data.status==500)
	        		{
	        		  $("#each").html(data.msg);
	        		  flag=1;

	        		}else{
	        			$("#each").html(data.msg);
	        			var list = data.data;
	        	
	        			// alert(data.msg);
	        			//$("#msg").html("卡上余额为："+data.msg+"元");
	        		}
	        	  
	          }
		  });
	   if(flag==0)
		{
		   return true;
		}else{
			return false;
		}
	   
   }
   function judgemypassword()
   {
	   var mymoney=$("#money").val();
		  if(mymoney.trim()=="")
		  {
			  alert("金额不能为空");
			  return false;
		  }
		  
	  var flag = judgepassword();
	  return flag;
   }
   function judgepassword()
   {
	  
	  var bankcardid=$("#bankcardid").val();
	  var password=$("#password").val();
	  var flag=0;
	  $.ajax({
          type: "POST",
          url: "/bankbookdetail/judgeidandpassword",
          data: {bankcardid:bankcardid, password:password},
          dataType: "json",
          async:false,
          success: function(data){
        	  //alert(data.msg);
        	  if(data.status==500)
        		{
      
        		  $("#msg").html(data.msg);
        		  flag=1;
        		 
        		}else{
        			$("#msg").html(data.msg);
        		}
        	  
          }
	  });
	
	  if(flag==0)
	  {

		  return true;
	  }else{
		  return false;
	  }
   }
   
   
   function search(){
	
	   var flag=0;
	   var bankcardid=$("#bankcardid").val();
	   var password=$("#password").val();
	   var money = $("#money").val();
	   var bankcarddetailid=$("#bankcarddetailid").val();
	   
	   $.ajax({
	          type: "POST",
	          url: "/bankbookdetail/findinfo",
	          data: {bankcardid:bankcardid, password:password,money:money,bankcarddetailid:bankcarddetailid},
	          dataType: "json",
	          async:false,
	          success: function(data){
	        	  alert(data.msg);
	        	  if(data.status==500)
	        		{
	                  flag=1;
	        		  $("#msg").html(data.msg);
	        		 
	        		}else{
	        			var mydata = data.data;
	        			alert(mydata.summoney);
	        			$("#summoney").html(mydata.summoney);
	        			$("#withdrawaltime").html(mydata.withdrawaltime);
	        			$("#month").html(mydata.month);
	        			$("#withdrawalrate").html(mydata.withdrawalrate);
	        			$("#createtime").html(mydata.createtime);
	        			if(mydata.state=="0")
	        			{
	        				$("#state").html("未取款");
	        			}else{
	        				$("#state").html("已取款");
	        			}
	        			//$("#")
	        			//$("#")
	        			$("#msg").html(data.msg);
	        		}
	        	  
	          }
		  });
   }
  
 </script>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit1('withdrawal','_self');this.blur();">保存</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
	<li id="view" onclick="search();this.blur();">查询</li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    存折取款
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>存折编号：</td>
		<td><input name="bankcardid"  type="text" id="bankcardid"/><span id="msg" Style="color: red"></span></td>
		<td>存折详细编号：</td>
		<td><input name="bankcarddetailid"  type="text" id="bankcarddetailid"/></td>
		<td>密码</td>
		<td><input name="password" type="password" id="password" onfocus=""/></td>
	
	</tr>

	<tr class="odd">
		<td>网点：</td>
		<td>
		   <input type="hidden" name="websitecode" value="${website.code}">
		   ${website.name}
		</td>
		
		<td>经办人：</td>
		<td>
		 <input type="hidden" name="usercode" value="${user.code}">
		   ${user.username}
		</td>
	
	</tr>
	<tr class="odd">
		
		 <td>总金额：</td>
		<td><span id="summoney" name="summoney" >待查询</span>
		</td>  
		
		<td>金额：</td>
		<td><input type="text" name="money" onclick="judgepassword()" id="money"/>元</td>
	</tr>
	
	<tr class="odd">
		<td>存款日期：</td>
		<td>
		<span id="createtime" name="createtime" >待查询</span>
		</td>  
		
		<td>应取款日期：</td>
		<td><span id="withdrawaltime" name="withdrawaltime" >待查询</span></td>
	</tr>
	<tr class="odd">
		<td>存款期限：</td>
		<td>
		<span id="month" name="month" >待查询</span>
		</td>  
		
		<td>应得利息：</td>
		<td><span id="withdrawalrate" name="withdrawalrate" >待查询</span></td>
	</tr>
	<tr class="odd">
		<td>操作类型：</td>
		<td>
		<span id="type" name="type" value="2">取款</span>
        <td>取款状态</td>
        <td>待查询</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


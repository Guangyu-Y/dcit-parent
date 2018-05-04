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
 
 
   
   function judgemypassword()
   {
	   var mymoney=$("#money").val();
		  if(mymoney.trim()=="")
		  {
			  alert("金额不能为空");
			  return false;
		  }
	  var rate=$("#rate").val();
	  if(rate.trim()=="")
	  {
		  alert("利率不能为空");
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
   
   function monthchange()
   {
	   var month=$("#month").val();
	   $.ajax({
	          type: "POST",
	          url: "/accrual/findborrowAccrualBymonth",
	          data: {month:month},
	          dataType: "json",
	          async:false,
	          success: function(data){
	     
	        	  if(data.status==500)
	        		{
	                  
	        		 
	        		}else{
	        		
	        			var rate = data.data.rate;
	        			$("#rate").val(rate);
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
	<li id="view"><a href="#" onclick="formSubmit1('savemoney','_self');this.blur();">保存</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    存折存款
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd">
		<td>存折：</td>
		<td><input name="bankcardid"  type="text" id="bankcardid"/><span id="msg" Style="color: red"></span></td>
		
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
		<td>操作类型：</td>
		<td>
		<span id="type" name="type" value="1">存款</span>
		 
		</td>  
		
		<td>金额：</td>
		<td><input type="text" name="money" onclick="judgepassword()" id="money"/>元</td>
	</tr>
	
	<tr class="odd">
		<td>存款期限：</td>
		<td>
		<select name="month" onchange="monthchange()" id="month">
		   <option value="0"> ==请选择存款期限==</option>
		 
		   <c:forEach items="${accrualList}" var="c" >
		   <option value="${c.month}">${c.description}</option>
		   </c:forEach>	 
		</select>  
		
		<td>利率：</td>
		<td><input type="text" name="rate"  id="rate" readonly="readonly"/>%</td>
	</tr>
	
	
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


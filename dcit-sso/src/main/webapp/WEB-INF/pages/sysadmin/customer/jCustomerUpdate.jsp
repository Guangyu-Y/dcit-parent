<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>客户信息更新</title>
	<script type="text/javascript">
	function clearCities(id) {
		var city = document.getElementById(id);
		//清空所有option
		city.length = 0;
		city.options[0] = new Option("--请选择--", 0);
	}
	function getCitys(parent_id,flag){
		var parent = parent_id;
		$.ajax({
				type:"post",
				url:"GetCitys",
				data:{parentid:parent},
				datatype:"json",
				success:function(data){
					var city=$("#selectcity");
					var area=$("#selectarea");
					
		    		//判断对象状态，readyState为对象执行状态，status为服务器返回码，如我们常见的404、500，200表示成功
		    		if (data.status == 400) {
		    			//得到服务器回应文本
		  				var dat=data.data;
		    			var str="";
		    			for(var i=0;i<dat.length;i++)
		    			{
		    				str+="<option value='"+dat[i].id+"'>"+dat[i].name+"</option>";
		    			}
		    			if(flag=="city"){
		    				clearCities("selectcity");
		    				$("#selectcity").append(str);
		    				clearCities("selectarea");
		    			}
		    			if(flag=="area"){
		    				clearCities("selectarea");
		    				$("#selectarea").append(str);
		    			}
		    			
		    		}
		    		
		    		if (data.status == 200){
		    			if(flag=="city"){
		    				clearCities("selectcity");
		    			}
		    			if(flag="area"){
		    				clearCities("selectarea");
		    			}
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
	<li id="view"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="new"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<input name="id"  type="hidden" value="${ customer.id }"/>
	<tr class="odd">
		<td style="width:10%">客户名：</td>
		<td><input name="chname"  type="text" value="${ customer.chname }"/>
		</td>
	</tr>
	<tr class="odd">
		<td>英文名：</td>
		<td><input name="enname"  type="text" value="${ customer.enname }"/></td>
	</tr>
		<input name="code"  type="hidden" value="${ customer.code }"/>
	<tr class="odd">
		<td>年龄：</td>
		<td><input name="age"  type="text" value="${ customer.age }"/></td>
	</tr>
	<tr class="odd">
		<td>性别：</td>
		<td>
			<select name="sex" style="width:130px">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>学历：</td>
		<td>
			<select name="education" style="width:130px">
				<option value="高中">高中</option>
				<option value="大专">大专</option>
				<option value="大专">本科</option>
				<option value="大专">硕士</option>
				<option value="大专">博士/博士后</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>证件号：</td>
		<td><input name="cardno"  type="text" value="${ customer.cardno }"/></td>
	</tr>
	<tr class="odd">
		<td>证件类型：</td>
		<td><select name="cardtype" style="width:130px">
				<option value="身份证">中华人民共和国第二代居民身份证</option>
				<option value="港澳通行证">港澳通行证</option>
				<option value="护照">护照</option>
			</select>
		</td>
	</tr>
	
	<tr class="odd">
		<td>地区</td>
		<td>
			<select name="province" id="selectprovince" style="width:30%" onchange="getCitys(this.value,'city')">
				<option value="">--请选择省份--</option>
				<c:forEach items="${provinces}" var="p" varStatus="status" >
					<option value="${p.id }">${p.name }</option>
				</c:forEach>
			</select>
			<select name="city" id="selectcity" style="width:30%" onchange="getCitys(this.value,'area')">
				<option value="">--请选择城市--</option>
			</select>
			<select name="areaid" id="selectarea" style="width:30%">
				<option value="${customer.areaid }">--请选择区--</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>地址：</td>
		<td><input name="address"  type="text" value="${ customer.address }"/></td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


<%@page import="com.dcit.pojo.Website"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	Website website = (Website)request.getAttribute("website"); 
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>网点修改</title>
	<script type="text/javascript">
	function clearCities(id) {
		var city = document.getElementById(id);
		//清空所有option
		city.length = 0;
		city.options[0] = new Option("==请选择==", 0);
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
    网点修改
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr class="odd"> 
		<td>网点代号：</td>
		<td>
			<input name="id"  type="hidden" value="${ website.getId() }"/>
 			${ website.getCode() }"
		</td>
		<td>网点名称：</td>
		<td>
		<input name="name"  type="text" value="${ website.getName() }"/>
		</td> 
	</tr>	
	<tr class="odd">	
		<td>客服电话：</td>
		<td><input name="phone"  type="text" value="${ website.getPhone() }"/></td>
		<td>网点级别：</td>
		<td>
			<select name="mlevel"  style="width:30%" ">
				<option value="">--请选择--</option>
					<c:choose>
						<c:when test="${0 eq website.getMlevel()}">
							<option value="0" selected="selected">总行</option>
						</c:when>
						<c:otherwise>
							<option value="0" >总行</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${1 eq website.getMlevel()}">
							<option value="1" selected="selected">分行</option>
						</c:when>
						<c:otherwise>
							<option value="1" >分行</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${2 eq website.getMlevel()}">
							<option value="2" selected="selected">支行</option>
						</c:when>
						<c:otherwise>
							<option value="2" >支行</option>
						</c:otherwise>
					</c:choose>
			</select>
		</td>
		
	</tr> 
	<tr class="odd">
		<td>是否交易机构：</td>
		<td>
			<select name="isorg"  style="width:30%" ">
				<option value="">--请选择--</option>
				<c:choose>
						<c:when test="${0 eq website.getIsorg()}">
							<option value="0" selected="selected">是</option>
						</c:when>
						<c:otherwise>
							<option value="0" >是</option>
						</c:otherwise>
						
				</c:choose>	
				<c:choose>
						<c:when test="${1 eq website.getIsorg()}">
							<option value="1" selected="selected">否</option>
						</c:when>
						<c:otherwise>
							<option value="1" >否</option>
						</c:otherwise>
				</c:choose>		
			</select> 
		</td>
		<td>地区代号：</td>
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
				<option value="${website.getAreaId()}">--请选择区--</option> 
			</select>
		</td>
	</tr> 	
	<tr class="odd">
		<td>状态：</td>
		<td>
			<select name="status"  style="width:30%" ">
				<option value="">--请选择--</option>
				<c:choose>
						<c:when test="${0 eq website.getStatus()}">
							<option value="0" selected="selected">开启</option>
						</c:when>
						<c:otherwise>
							<option value="0" >开启</option>
						</c:otherwise>
				</c:choose>	
				<c:choose>
						<c:when test="${1 eq website.getStatus()}">
							<option value="1" selected="selected">关闭</option>
						</c:when>
						<c:otherwise>
							<option value="1" >关闭</option>
						</c:otherwise>
				</c:choose>	
			</select> 
		</td> 
		<td>网点介绍：</td>
		<td><input name="description"  type="text" value="${ website.getDescription() }"/></td>
	</tr> 
	<tr class="odd">
		<td>地址：</td>
		<td><input name="address"  type="text" value="${ website.getAddress() }"/></td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


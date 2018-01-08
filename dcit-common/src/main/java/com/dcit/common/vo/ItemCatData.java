package com.dcit.common.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
//经过分析  该对象是一级菜单和二级菜单的包装对象    不适用于三级菜单
public class ItemCatData {
	//添加了该注解后,将数据转化为JSON时内部的key值就是注解指定的数据
	//为什么不用全名的原因: url name items  为了在网络传输中 减少数据量
	@JsonProperty("u")
	private String url;
	
	@JsonProperty("n")
	private String name;
	
	@JsonProperty("i")
	private List<?> items;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<?> getItems() {
		return items;
	}
	public void setItems(List<?> items) {
		this.items = items;
	}
}

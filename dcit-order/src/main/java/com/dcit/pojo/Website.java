package com.dcit.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="t_website")
@JsonIgnoreProperties(ignoreUnknown = true)  //表示忽略未知字段
public class Website {
	@Id
	private String id;
	private String name;
	private String code;
	private String phone;
	//0总行 ，1分行 ，2支行
	private String mlevel;
	//0 是， 1否
	private String isorg;
	private String areaid;
	//0开启，1关闭
	private String status;
	private String createtime;
	private String updatetime;
	private String description;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getIsorg() {
		return isorg;
	}
	public void setIsorg(String isorg) {
		this.isorg = isorg;
	}
	public String getAreaId() {
		return areaid;
	}
	public void setAreaId(String areaId) {
		this.areaid = areaId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Website [id=" + id + ", name=" + name + ", code=" + code + ", phone=" + phone + ", mlevel=" + mlevel
				+ ", isorg=" + isorg + ", areaId=" + areaid + ", status=" + status + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", description=" + description + ", address=" + address + "]";
	}
	
}

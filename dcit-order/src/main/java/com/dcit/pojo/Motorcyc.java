package com.dcit.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(name="T_MOTORCYC")
@JsonIgnoreProperties(ignoreUnknown = true)  //表示忽略未知字段
public class Motorcyc {
	
	  @Id
	  private String id;    
	  private Double money ;  
	  private String usercode;
	  @Transient
	  private String username;
	  //所属网点
	  @Transient
	  private Website website;
	  
	  private String localip;
	  private String createtime;   
	  private String updatetime ; 
	  
	  public String getUsername() {
		return username;
	  }
	public void setUsername(String username) {
		this.username = username;
	}
	public  String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public Double getMoney() {
			return money;
		}
		public void setMoney(Double i) {
			this.money = i;
		}
		public String getUsercode() {
			return usercode;
		}
		public void setUsercode(String usercode) {
			this.usercode = usercode;
		}
		public String getLocalip() {
			return localip;
		}
		
		public Website getWebsite() {
			return website;
		}
		public void setWebsite(Website website) {
			this.website = website;
		}
		public void setLocalip(String localip) {
			this.localip = localip;
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
		@Override
		public String toString() {
			return "Motorcyc [id=" + id + ", money=" + money + ", usercode=" + usercode + ", localip=" + localip
					+ ", createtime=" + createtime + ", updatetime=" + updatetime + "]";
		}
		
}

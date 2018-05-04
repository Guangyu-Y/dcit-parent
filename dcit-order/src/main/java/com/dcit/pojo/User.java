package com.dcit.pojo;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="T_USER")
@JsonIgnoreProperties(ignoreUnknown = true)  //表示忽略未知字段
public class User {
	  @Id
	  private String id ;        
	  private String username ;   
	  private String password ;  
	  private String status;      
	  private String localip ;   
	  private String createtime;     
	  private String card    ;   
	  private String code ;      
	  private String age;        
	  private String sex; 
	  private String birthday; 
	 
	 
	  private String education ;  
	  @Transient
	  private Website website;
	  
	  private String websitecode;
	 
	private String mlevel  ;     
	  private String lastlogin ;
	  
	
	  public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWebsitecode() {
		return websitecode;
	}
	public void setWebsitecode(String websitecode) {
		this.websitecode = websitecode;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Teller [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", localip=" + localip + ", createtime=" + createtime + ", card=" + card + ", code=" + code + ", age="
				+ age + ", sex=" + sex + ", birthday=" + birthday + ", education=" + education + ", websitecode="
				+ websitecode + ", mlevel=" + mlevel + ", lastlogin=" + lastlogin + "]";
	}
	public String getLocalip() {
		return localip;
	}
	public void setLocalip(String localip) {
		this.localip = localip;
	}
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		this.website = website;
	}
	
	
	
}

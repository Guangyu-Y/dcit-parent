package com.dcit.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(name="T_MOTORCYC_RECORD")
@JsonIgnoreProperties(ignoreUnknown = true) 
public class MotorcycRecord {

	@Id
	private String id; 
	private String operateorid;
	private String operatetime; 
	private String motorcycid ;
	private String operatecode ;
	private String operateinfo ;
	private String motorcyccash;
	@Transient
	private String operateorname;
	public String getOperateorname() {
		return operateorname;
	}
	public void setOperateorname(String operateorname) {
		this.operateorname = operateorname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperateorid() {
		return operateorid;
	}
	public void setOperateorid(String operateorid) {
		this.operateorid = operateorid;
	}
	public String getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(String operatetime) {
		this.operatetime = operatetime;
	}
	public String getMotorcycid() {
		return motorcycid;
	}
	public void setMotorcycid(String motorcycid) {
		this.motorcycid = motorcycid;
	}
	public String getOperatecode() {
		return operatecode;
	}
	public void setOperatecode(String operatecode) {
		this.operatecode = operatecode;
	}
	public String getOperateinfo() {
		return operateinfo;
	}
	public void setOperateinfo(String operateinfo) {
		this.operateinfo = operateinfo;
	}
	public String getMotorcyccash() {
		return motorcyccash;
	}
	public void setMotorcyccash(String motorcyccash) {
		this.motorcyccash = motorcyccash;
	}
	@Override
	public String toString() {
		return "MotorcycRecord [id=" + id + ", operateorid=" + operateorid + ", operatetime=" + operatetime
				+ ", motorcycid=" + motorcycid + ", operatecode=" + operatecode + ", operateinfo=" + operateinfo
				+ ", motorcyccash=" + motorcyccash + "]";
	}
	
}

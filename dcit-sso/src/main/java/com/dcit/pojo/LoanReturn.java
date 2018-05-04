package com.dcit.pojo;


import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(name="LOAD_RETURN")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanReturn {

	@Id
	private String returnid;
	
	private String  loancode ;     
	private Integer   times;             
	private String   returndate ;     
	private Double  sumnumber ;        
	private Double   surplusnumber;     
	private Double   interest ;         
	private String   websitecode ;      
	private String  type;
	
	public String getReturnid() {
		return returnid;
	}
	public void setReturnid(String returnid) {
		this.returnid = returnid;
	}
	public String getLoancode() {
		return loancode;
	}
	public void setLoancode(String loancode) {
		this.loancode = loancode;
	}
	
	
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public Double getSumnumber() {
		return sumnumber;
	}
	public void setSumnumber(Double sumnumber) {
		this.sumnumber = sumnumber;
	}
	public Double getSurplusnumber() {
		return surplusnumber;
	}
	public void setSurplusnumber(Double surplusnumber) {
		this.surplusnumber = surplusnumber;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public String getWebsitecode() {
		return websitecode;
	}
	public void setWebsitecode(String websitecode) {
		this.websitecode = websitecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoanReturn [returnid=" + returnid + ", loancode=" + loancode + ", times=" + times + ", returndate="
				+ returndate + ", sumnumber=" + sumnumber + ", surplusnumber=" + surplusnumber + ", interest="
				+ interest + ", websitecode=" + websitecode + ", type=" + type + "]";
	}
	
}

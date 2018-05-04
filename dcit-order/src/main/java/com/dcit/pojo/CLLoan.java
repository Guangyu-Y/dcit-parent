package com.dcit.pojo;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Table(name="T_LOAN")
public class CLLoan {
	@Id
    private String loanid;

    private String loancode;

    private String status;

    private String borrowCode;

    private String borrowType;

    private String websitecode;

    private String usercode;

    private Double moneynumber;

    private Double rate;

    private String period;

    private Double balance;

    private String createTime;

    private String cardcode;
    
    @Transient
    private String customername;

    public String getLoanid() {
        return loanid;
    }

    public void setLoanid(String loanid) {
        this.loanid = loanid == null ? null : loanid.trim();
    }

    public String getLoancode() {
        return loancode;
    }

    public void setLoancode(String loancode) {
        this.loancode = loancode == null ? null : loancode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode == null ? null : borrowCode.trim();
    }

    public String getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(String borrowType) {
        this.borrowType = borrowType == null ? null : borrowType.trim();
    }

    public String getWebsitecode() {
        return websitecode;
    }

    public void setWebsitecode(String websitecode) {
        this.websitecode = websitecode == null ? null : websitecode.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public Double getMoneynumber() {
        return moneynumber;
    }

    public void setMoneynumber(Double moneynumber) {
        this.moneynumber = moneynumber;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCardcode() {
        return cardcode;
    }

    public void setCardcode(String cardcode) {
        this.cardcode = cardcode == null ? null : cardcode.trim();
    }
    
    public void setCustomername(String customername) {
		this.customername=customername;
	}
    
    public String getCustomername(){
    	return customername;
    }
//    public void setCustomerName(String customername) {
//		this.customername=customername;
//	}
//    
//    public String getCustomerName(){
//    	return customername;
//    }
    
}
package com.dcit.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table(name="drawdown_loan")
@JsonIgnoreProperties(ignoreUnknown=true)
public class DrawdownLoan {
	@Id
    private String loancode;

    private String bankcard;

    private String dddate;

    private String ffnumber;

    private String websitecode;
    @Transient
    private String webName;
    

    public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getLoancode() {
        return loancode;
    }

    public void setLoancode(String loancode) {
        this.loancode = loancode == null ? null : loancode.trim();
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard == null ? null : bankcard.trim();
    }

    public String getDddate() {
        return dddate;
    }

    public void setDddate(String dddate) {
        this.dddate = dddate == null ? null : dddate.trim();
    }

    public String getFfnumber() {
        return ffnumber;
    }

    public void setFfnumber(String ffnumber) {
        this.ffnumber = ffnumber == null ? null : ffnumber.trim();
    }

    public String getWebsitecode() {
        return websitecode;
    }

    public void setWebsitecode(String websitecode) {
        this.websitecode = websitecode == null ? null : websitecode.trim();
    }
}
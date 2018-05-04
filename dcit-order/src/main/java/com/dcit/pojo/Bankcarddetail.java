package com.dcit.pojo;

import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="t_bankcarddetail")
@JsonIgnoreProperties(ignoreUnknown= true)
public class Bankcarddetail {
	
	@Id
    private String id;
	
	//1 存款 2取款 3转账 4收到转账
    private String type;

    private String eachbankcardno;
    
    private String usercode;
     
    private String createtime;

    private Double money;

    private String eachname;

    private String eachtype;
    //0代表银行卡操作  1代表存折操作
    private String mold="0";

    private Integer month;

    private Integer rate;

    private String bankcardid;
    
    //状态 0代表成功 1代表失败
    private String state;
    //备注
    private String info;
    
    //网点id
    private String websitecode;

    
    @Transient
    private User user;
    @Transient
    private Website website;
    
    
    public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEachbankcardno() {
        return eachbankcardno;
    }

    public void setEachbankcardno(String eachbankcardno) {
        this.eachbankcardno = eachbankcardno == null ? null : eachbankcardno.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	

	public String getWebsitecode() {
		return websitecode;
	}

	public void setWebsitecode(String websitecode) {
		this.websitecode = websitecode;
	}

	public String getEachname() {
        return eachname;
    }

    public void setEachname(String eachname) {
        this.eachname = eachname == null ? null : eachname.trim();
    }

    public String getEachtype() {
        return eachtype;
    }

    public void setEachtype(String eachtype) {
        this.eachtype = eachtype == null ? null : eachtype.trim();
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold == null ? null : mold.trim();
    }
    
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(String bankcardid) {
        this.bankcardid = bankcardid == null ? null : bankcardid.trim();
    }
}
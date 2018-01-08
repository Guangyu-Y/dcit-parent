package com.dcit.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_account")
public class Account {
	@Id
    private String id;

    private String websitecode;

    private String usercode;

    private String customercode;

    private String createcode;

    private String createtime;

    private String updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode == null ? null : customercode.trim();
    }

    public String getCreatecode() {
        return createcode;
    }

    public void setCreatecode(String createcode) {
        this.createcode = createcode == null ? null : createcode.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}
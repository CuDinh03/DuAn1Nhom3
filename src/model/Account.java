
package model;

import java.util.Date;


public class Account {
    
    private String id;
    private String username;
    private String pass;
    private Date createDate;
    private Date updateDate;
    private int accStatus;

    public Account() {
    }

    public Account(String id, String username, String pass, int accStatus) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.accStatus = accStatus;
    }

    
    
    public Account(String id, String username, String pass, Date createDate, Date updateDate, int accStatus) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.accStatus = accStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(int accStatus) {
        this.accStatus = accStatus;
    }
    
   
}

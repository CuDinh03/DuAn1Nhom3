
package model;

import java.util.Date;


public class Custormer {
    private String id;
    private String userName;
    private String userAddress;
    private String phone;
    private Date createDate;
    private Date updateDate;
    private int cusStatus;

    public Custormer() {
    }

    public Custormer(String id, String userName, String userAddress, String phone, Date createDate, Date updateDate, int cusStatus) {
        this.id = id;
        this.userName = userName;
        this.userAddress = userAddress;
        this.phone = phone;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.cusStatus = cusStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getCusStatus() {
        return cusStatus;
    }

    public void setCusStatus(int cusStatus) {
        this.cusStatus = cusStatus;
    }

    
}

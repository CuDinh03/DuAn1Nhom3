package model;


import java.sql.Date;

public class Customer {
    private String id;
    private String userName;
    private String phone;
    private String userAddress;
    private Date createDate;
    private Date updateDate;
    private int cusStatus;

    public Customer() {
        // Default constructor
    }

    public Customer(String id, String userName, String phone, String userAddress, Date createDate, Date updateDate, int cusStatus) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.userAddress = userAddress;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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


package model;

import java.util.Date;

public class User {

    private String id;
    private String userName;
    private String phone;
    private String userAddress;
    private String idAcc;
    private Date createDate;
    private Date updateDate;
    private int userStatus;

    public User() {
    }

    public User(String id, String userName, String phone, String userAddress, String idAcc, Date createDate, Date updateDate, int userStatus) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.userAddress = userAddress;
        this.idAcc = idAcc;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userStatus = userStatus;
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

    public String getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(String idAcc) {
        this.idAcc = idAcc;
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

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

  
   
}

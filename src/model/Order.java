package model;

import java.util.Date;

public class Order {

    private String id;
    private String code;
    private String inventoryName;
    private String idUser;
    private String idCustomer;
    private Date createDate;
    private Date updateDate;
    private int inventoryStatus;

    public Order() {
    }

    public Order(String id, String code, String inventoryName, String idCustomer, String idUser, Date createDate, Date updateDate, int inventoryStatus) {
        this.id = id;
        this.code = code;
        this.inventoryName = inventoryName;
        this.idCustomer = idCustomer;

        this.idUser = idUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.inventoryStatus = inventoryStatus;
    }

    public Order(String code, String inventoryName, String idCustomer, String idUser, Date createDate, Date updateDate, int inventoryStatus) {
        this.code = code;
        this.inventoryName = inventoryName;
        this.idCustomer = idCustomer;

        this.idUser = idUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.inventoryStatus = inventoryStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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

    public int getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(int inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

}

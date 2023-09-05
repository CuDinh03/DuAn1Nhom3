package model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetail {
    private String ID;
    private String code;
    private String inventoryId;
    private BigDecimal total;
    private Date createDate;
    private Date updateDate;
    private int inventoryStatus;

    public OrderDetail(String code, String inventoryId, BigDecimal total, Date createDate, Date updateDate, int inventoryStatus) {
        this.code = code;
        this.inventoryId = inventoryId;
        this.total = total;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.inventoryStatus = inventoryStatus;
    }

    public OrderDetail(String ID, String code, String inventoryId, BigDecimal total, Date createDate, Date updateDate, int inventoryStatus) {
        this.ID = ID;
        this.code = code;
        this.inventoryId = inventoryId;
        this.total = total;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.inventoryStatus = inventoryStatus;
    }

    public OrderDetail() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

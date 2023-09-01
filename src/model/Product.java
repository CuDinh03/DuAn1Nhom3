package model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;
    private String prName;
    private int prQuantity;
    private String nguonGoc;
    private BigDecimal giaGoc;
    private Date expiry;
    private Date MFG;
    private String idType;
    private Date createDate;
    private Date updateDate;
    private int prStatus;

    public Product() {
    }

    public Product(String id, String prName, int prQuantity, String nguonGoc, BigDecimal giaGoc, Date expiry, Date MFG, String idType, Date createDate, Date updateDate, int prStatus) {
        this.id = id;
        this.prName = prName;
        this.prQuantity = prQuantity;
        this.nguonGoc = nguonGoc;
        this.giaGoc = giaGoc;
        this.expiry = expiry;
        this.MFG = MFG;
        this.idType = idType;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.prStatus = prStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrName() {
        return prName;
    }

    public void setPrName(String prName) {
        this.prName = prName;
    }

    public int getPrQuantity() {
        return prQuantity;
    }

    public void setPrQuantity(int prQuantity) {
        this.prQuantity = prQuantity;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public BigDecimal getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(BigDecimal giaGoc) {
        this.giaGoc = giaGoc;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public Date getMFG() {
        return MFG;
    }

    public void setMFG(Date MFG) {
        this.MFG = MFG;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
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

    public int getPrStatus() {
        return prStatus;
    }

    public void setPrStatus(int prStatus) {
        this.prStatus = prStatus;
    }



}

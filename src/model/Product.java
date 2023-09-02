package model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String id;
    private String code;
    private String prName;
    private int prQuantity;
    private String original;
    private BigDecimal cost;
    private Date expiry;
    private Date MFG;
    private String idType;
    private Date createDate;
    private Date updateDate;
    private int prStatus;

    public Product() {
    }

    public Product(String id, String code, String prName, int prQuantity, String original, BigDecimal cost, Date expiry, Date MFG, String idType, Date createDate, Date updateDate, int prStatus) {
        this.id = id;
        this.code = code;
        this.prName = prName;
        this.prQuantity = prQuantity;
        this.original = original;
        this.cost = cost;
        this.expiry = expiry;
        this.MFG = MFG;
        this.idType = idType;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.prStatus = prStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

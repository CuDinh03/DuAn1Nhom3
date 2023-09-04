
package model;

import java.math.BigDecimal;
import java.util.Date;


public class Items {
    private String id;
    private String idCart;
    private String idInventory;
    private String codeProducts;
    private String idProducs;
    private int quantity;
    private BigDecimal price;
    private Date createDate;
    private Date updateDate;
    private int itemsStatus;

    public Items() {
    }

    public Items(String codeProducts, String idProducs, int quantity, BigDecimal price, int itemsStatus) {
        this.codeProducts = codeProducts;
        this.idProducs = idProducs;
        this.quantity = quantity;
        this.price = price;
        this.itemsStatus = itemsStatus;
    }
    public Items(String id, String idCart, String idInventory, String codeProducts, String idProducs, int quantity, BigDecimal price, Date createDate, Date updateDate, int itemsStatus) {
        this.id = id;
        this.idCart = idCart;
        this.idInventory = idInventory;
        this.codeProducts = codeProducts;
        this.idProducs = idProducs;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.itemsStatus = itemsStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(String idInventory) {
        this.idInventory = idInventory;
    }

    public String getCodeProducts() {
        return codeProducts;
    }

    public void setCodeProducts(String codeProducts) {
        this.codeProducts = codeProducts;
    }

    public String getNameProducs() {
        return idProducs;
    }

    public void setNameProducs(String idProducs) {
        this.idProducs = idProducs;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public int getItemsStatus() {
        return itemsStatus;
    }

    public void setItemsStatus(int itemsStatus) {
        this.itemsStatus = itemsStatus;
    }

    
}

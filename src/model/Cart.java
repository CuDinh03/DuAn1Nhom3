
package model;

import java.util.Date;


public class Cart {
    
    private String id;
    private String code;
    private String idstore;
    private String idCustomer;
    private String iduser;
    private Date createDate;
    private Date updateDate;
    private int cartStatus;

    public Cart() {
    }

    public Cart(String id, String code, String idstore, String idCustomer, String iduser, Date createDate, Date updateDate, int cartStatus) {
        this.id = id;
        this.code = code;
        this.idstore = idstore;
        this.idCustomer = idCustomer;
        this.iduser = iduser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.cartStatus = cartStatus;
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

    public String getIdstore() {
        return idstore;
    }

    public void setIdstore(String idstore) {
        this.idstore = idstore;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
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

    public int getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(int cartStatus) {
        this.cartStatus = cartStatus;
    }

    
    
}

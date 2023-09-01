
package model;

import java.util.Date;


public class ProductTypes {
    
    private String id;
    private String typename;
    private Date createDate;
    private Date updateDate;
    private int prtypeStatus;

    
    public ProductTypes() {
    }

    public ProductTypes(String id, String typename, Date createDate, Date updateDate, int prtypeStatus) {
        this.id = id;
        this.typename = typename;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.prtypeStatus = prtypeStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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

    public int getPrtypeStatus() {
        return prtypeStatus;
    }

    public void setPrtypeStatus(int prtypeStatus) {
        this.prtypeStatus = prtypeStatus;
    }

    
}

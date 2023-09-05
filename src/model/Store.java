
package model;

import java.util.Date;

public class Store {
    private String id;
    private String nameStore;
    private String adrStore;
    private Date createDate;
    private Date updateDate;
    private int storeStatus;

    public Store() {
    }

    public Store(String id, String nameStore, String adrStore, Date createDate, Date updateDate, int storeStatus) {
        this.id = id;
        this.nameStore = nameStore;
        this.adrStore = adrStore;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.storeStatus = storeStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getAdrStore() {
        return adrStore;
    }

    public void setAdrStore(String adrStore) {
        this.adrStore = adrStore;
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

    public int getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }

    

}

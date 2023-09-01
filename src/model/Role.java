
package model;

import java.util.Date;


public class Role {

    private String id;
    private String name;
    private Date createDate;
    private Date updateDate;
    private int rolesStatus;

    public Role() {
    }

    public Role(String id, String name, Date createDate, Date updateDate, int rolesStatus) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rolesStatus = rolesStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRolesStatus() {
        return rolesStatus;
    }

    public void setRolesStatus(int rolesStatus) {
        this.rolesStatus = rolesStatus;
    }
    
    
        
}

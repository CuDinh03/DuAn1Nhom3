
package model;

import java.util.Date;


public class ProductTypes {
    private String id;
    private String name;
    private Date ngayTao;
    private Date ngaySua;
    private boolean status;

    public ProductTypes() {
    }

    public ProductTypes(String id, String name, Date ngayTao, Date ngaySua, boolean status) {
        this.id = id;
        this.name = name;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}

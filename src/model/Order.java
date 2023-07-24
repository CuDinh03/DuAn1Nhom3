
package model;

import java.util.Date;

public class Order {

    private String id;
    private String ma;
    private String name;
    private String tenNv;
    private String tenKh;
    private String idCh;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Order() {
    }

    public Order(String ma, String name, String tenNv, String tenKh, String idCh, Date ngayTao, Date ngaySua, int status) {
        this.ma = ma;
        this.name = name;
        this.tenNv = tenNv;
        this.tenKh = tenKh;
        this.idCh = idCh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }

    public Order(String id, String ma, String name, String tenNv, String tenKh, String idCh, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.name = name;
        this.tenNv = tenNv;
        this.tenKh = tenKh;
        this.idCh = idCh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }


    
    

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdKh() {
        return tenKh;
    }

    public void setIdKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getIdCh() {
        return idCh;
    }

    public void setIdCh(String idCh) {
        this.idCh = idCh;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

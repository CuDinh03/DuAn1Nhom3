
package model;

import java.util.Date;
import java.util.List;

public class Inventory {
    private String id;
    private String ma;
    private String ten;
    private String idKh;
    private String idCh;
    private List<Items> items;
    private double totalAmount; 
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Inventory() {
    }

    public Inventory(String id, String ma, String ten, String idKh, String idCh, List<Items> items, double totalAmount, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.idKh = idKh;
        this.idCh = idCh;
        this.items = items;
        this.totalAmount = totalAmount;
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
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

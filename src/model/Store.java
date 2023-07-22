
package model;

import java.util.Date;


public class Store {
    private String id;
    private String ma;
    private String ten;
    private String diaChi;
    private String idPhieuNhanHang;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Store() {
    }

    public Store(String id, String ma, String ten, String diaChi, String idPhieuNhanHang, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.idPhieuNhanHang = idPhieuNhanHang;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }

    public Store(String id, String ma, String ten, String diaChi, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getIdPhieuNhanHang() {
        return idPhieuNhanHang;
    }

    public void setIdPhieuNhanHang(String idPhieuNhanHang) {
        this.idPhieuNhanHang = idPhieuNhanHang;
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

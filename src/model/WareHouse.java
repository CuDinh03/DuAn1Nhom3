
package model;

import java.util.Date;


public class WareHouse {
    private String id;
    private String ma;
    private String tenKho;
    private Date ngayTao;
    private Date ngaySua;
    private String diaChi;
    private int status;
    private String idPhieuNhap;

    public WareHouse() {
    }

    public WareHouse(String id, String ma, String tenKho, Date ngayTao, Date ngaySua, String diaChi, int status, String idPhieuNhap) {
        this.id = id;
        this.ma = ma;
        this.tenKho = tenKho;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.diaChi = diaChi;
        this.status = status;
        this.idPhieuNhap = idPhieuNhap;
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

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }
    
    

}

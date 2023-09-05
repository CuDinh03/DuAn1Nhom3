
package model;

import java.util.Date;


public class ImportOrder {
    private String id;
    private String ma;
    private Date ngayTao;
    private Date ngaySua;
    private String donViTinh;
    private double giaNhap;
    private int status;

    public ImportOrder() {
    }

    public ImportOrder(String id, String ma, Date ngayTao, Date ngaySua, String donViTinh, double giaNhap, int status) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    
}

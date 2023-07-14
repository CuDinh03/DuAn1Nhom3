
package model;

import java.util.Date;


public class ImportOrder {
    private String id;
    private String dvtinh;
    private double giaNhap;
    private String maPn;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public ImportOrder() {
    }

    public ImportOrder(String id, String dvtinh, double giaNhap, String maPn, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.dvtinh = dvtinh;
        this.giaNhap = giaNhap;
        this.maPn = maPn;
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

    public String getDvtinh() {
        return dvtinh;
    }

    public void setDvtinh(String dvtinh) {
        this.dvtinh = dvtinh;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMaPn() {
        return maPn;
    }

    public void setMaPn(String maPn) {
        this.maPn = maPn;
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

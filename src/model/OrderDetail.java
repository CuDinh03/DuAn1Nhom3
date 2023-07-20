
package model;

import java.util.Date;


public class OrderDetail {
    private String id;
    private String ma;
    private String idHD;
    private double tongTien;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public OrderDetail(String ma, String idHD, double tongTien, Date ngayTao, Date ngaySua, int status) {
        this.ma = ma;
        this.idHD = idHD;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }
    

    public OrderDetail(String id, String ma, String idHD, double tongTien, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.idHD = idHD;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }

    public OrderDetail() {
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

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
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

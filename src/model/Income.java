
package model;

import java.util.Date;


public class Income {
    private String id;
    private String idCh;
    private String ma;
    private double doanhThu;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Income() {
    }

    public Income(String id, String idCh, String ma, double doanhThu, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.idCh = idCh;
        this.ma = ma;
        this.doanhThu = doanhThu;
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

    public String getIdCh() {
        return idCh;
    }

    public void setIdCh(String idCh) {
        this.idCh = idCh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
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

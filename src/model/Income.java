
package model;

import java.math.BigDecimal;
import java.util.Date;


public class Income {
    private String idCh;
    private String ma;
    private BigDecimal doanhThu;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Income() {
    }

    public Income(String idCh, String ma, BigDecimal doanhThu, Date ngayTao, Date ngaySua, int status) {
        this.idCh = idCh;
        this.ma = ma;
        this.doanhThu = doanhThu;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
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

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
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

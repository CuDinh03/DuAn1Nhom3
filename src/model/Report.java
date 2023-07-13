
package model;


import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author maccuacu
 */

public class Report {
    private String id;
    private String ma;
    private String noiDung;
    private String ten;
    private Date ngayTao;
    private Date ngaySua;
    private BigDecimal doanhThu;
    private int trangThai;
    private String idNV;
    private String idCH;

    public Report() {
    }

    public Report(String id, String ma, String noiDung, String ten, Date ngayTao, Date ngaySua, BigDecimal doanhThu, int trangThai, String idNV, String idCH) {
        this.id = id;
        this.ma = ma;
        this.noiDung = noiDung;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.doanhThu = doanhThu;
        this.trangThai = trangThai;
        this.idNV = idNV;
        this.idCH = idCH;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }
    
    
}

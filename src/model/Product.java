package model;

import java.util.Date;

public class Product {

    private String id;
    private String ma;
    private String name;
    private String nguonGoc;
    private double giaGoc;
    private Date ngaySx;
    private Date hsd;
    private String idDanhMuc;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Product() {
    }

    public Product(String id, String ma, String name, String nguonGoc, double giaGoc, Date ngaySx, Date hsd, String idDanhMuc, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.name = name;
        this.nguonGoc = nguonGoc;
        this.giaGoc = giaGoc;
        this.ngaySx = ngaySx;
        this.hsd = hsd;
        this.idDanhMuc = idDanhMuc;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }    
    
    public Product(String ma, String name, String nguonGoc, double giaGoc, Date ngaySx, Date hsd, String idDanhMuc, Date ngayTao, Date ngaySua, int status) {
        this.name = name;
        this.ma = ma;
        this.nguonGoc = nguonGoc;
        this.giaGoc = giaGoc;
        this.ngaySx = ngaySx;
        this.hsd = hsd;
        this.idDanhMuc = idDanhMuc;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public Date getNgaySx() {
        return ngaySx;
    }

    public void setNgaySx(Date ngaySx) {
        this.ngaySx = ngaySx;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
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

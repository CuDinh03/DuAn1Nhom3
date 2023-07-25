
package model;

import java.util.Date;


public class Items {
    private String id;
    private String idCart;
    private String idOrder;
    private String maSP;
    private String tenSp;
    private int soLuong;
    private double giaban;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Items() {
    }

    public Items(String id, String idCart, String idOrder, String maSP, String tenSp, int soLuong, double giaban, int status) {
        this.id = id;
        this.idCart = idCart;
        this.idOrder = idOrder;
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaban = giaban;
        this.status = status;
    }

    public Items(String id, String idCart, String idOrder, String maSP, String tenSp, int soLuong, double giaban, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.idCart = idCart;
        this.idOrder = idOrder;
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaban = giaban;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }
    



    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }    
    
    

    public Items(String id, String idCart, String idOrder, int soLuong, double giaban, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.idCart = idCart;
        this.idOrder = idOrder;
        this.soLuong = soLuong;
        this.giaban = giaban;
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

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
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

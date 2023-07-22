/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author maccuacu
 */
public class StoreProducts {

    private String id;
    private String sanPhamId;
    private String cuaHangId;
    private String tenSp;
    private int soLuong;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public StoreProducts() {
    }

    public StoreProducts(String id, String sanPhamId, String cuaHangId, String tenSp, int soLuong, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.sanPhamId = sanPhamId;
        this.cuaHangId = cuaHangId;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
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

    public String getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(String sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

    public String getCuaHangId() {
        return cuaHangId;
    }

    public void setCuaHangId(String cuaHangId) {
        this.cuaHangId = cuaHangId;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

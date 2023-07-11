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
public class Custormer {
    private String idKh;
    private String maKh;
    private String tenKh;
    private String sdt;
    private Date ngayTao;
    private Date ngaySua;
    private boolean status;

    public Custormer() {
    }

    public Custormer(String idKh, String maKh, String tenKh, String sdt, Date ngayTao, Date ngaySua, boolean status) {
        this.idKh = idKh;
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}

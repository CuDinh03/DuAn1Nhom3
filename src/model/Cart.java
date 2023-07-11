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
public class Cart {
    private String id;
    private String maCart;
    private String idNv;
    private String idKh;
    private String idCh;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public Cart() {
    }

    public Cart(String id, String maCart, String idNv, String idKh, String idCh, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.maCart = maCart;
        this.idNv = idNv;
        this.idKh = idKh;
        this.idCh = idCh;
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

    public String getMaCart() {
        return maCart;
    }

    public void setMaCart(String maCart) {
        this.maCart = maCart;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public String getIdCh() {
        return idCh;
    }

    public void setIdCh(String idCh) {
        this.idCh = idCh;
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

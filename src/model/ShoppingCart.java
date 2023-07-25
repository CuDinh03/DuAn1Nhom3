/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class ShoppingCart {
    private String id;
    private String ma;
    private String idch;
    private List<Items> itemsList;
    private String nameKh;
    private String nameNv;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public ShoppingCart() {
    }

    public ShoppingCart(String id, List<Items> itemsList, String nameKh, String nameNv) {
        this.id = id;
        this.itemsList = itemsList;
        this.nameKh = nameKh;
        this.nameNv = nameNv;
    }

    public ShoppingCart(String id, String ma, String idch, List<Items> itemsList, String nameKh, String nameNv, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.ma = ma;
        this.idch = idch;
        this.itemsList = itemsList;
        this.nameKh = nameKh;
        this.nameNv = nameNv;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.status = status;
    }



    

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getIdch() {
        return idch;
    }

    public void setIdch(String idch) {
        this.idch = idch;
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
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getNameNv() {
        return nameNv;
    }

    public void setNameNv(String nameNv) {
        this.nameNv = nameNv;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author trung
 */
public class ExportOrder {
    private String id;
    private String ma;
    private Date ngayTao;
    private Date ngaySua;
    private String donViTinh;
    private int trangThai;
    private String idKho;
    private List<ProductXuatKho> productXuatKho;

    public ExportOrder() {
    }

    public ExportOrder(String id, String ma, Date ngayTao, Date ngaySua, String donViTinh, int trangThai, String idKho) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.donViTinh = donViTinh;
        this.trangThai = trangThai;
        this.idKho = idKho;
    }

    public ExportOrder(String id, String ma, Date ngayTao, Date ngaySua, String donViTinh, int trangThai, String idKho, List<ProductXuatKho> productXuatKho) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.donViTinh = donViTinh;
        this.trangThai = trangThai;
        this.idKho = idKho;
        this.productXuatKho = productXuatKho;
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

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdKho() {
        return idKho;
    }

    public void setIdKho(String idKho) {
        this.idKho = idKho;
    }

    public List<ProductXuatKho> getProductXuatKho() {
        return productXuatKho;
    }

    public void setProductXuatKho(List<ProductXuatKho> productXuatKho) {
        this.productXuatKho = productXuatKho;
    }

   
    
    }
    


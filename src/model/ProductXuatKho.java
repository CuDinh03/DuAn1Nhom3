/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author trung
 */
public class ProductXuatKho {

    private String id;
    private String maSP;
    private String idCH;
    private String tenSp;
    private int soLuong;
    private double giaBan;


    public ProductXuatKho() {
    }

    public ProductXuatKho(String id, String maSP, String idCH, String tenSp, int soLuong, double giaBan) {
        this.id = id;
        this.maSP = maSP;
        this.idCH = idCH;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBan = giaBan;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
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

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
   
    }
  
    


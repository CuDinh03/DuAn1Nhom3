/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trung
 */
public class ExportOrderDetail {
    private String idPhieuXuat;
    private String idSanPham;

    public ExportOrderDetail() {
    }

    public ExportOrderDetail(String idPhieuXuat, String idSanPham) {
        this.idPhieuXuat = idPhieuXuat;
        this.idSanPham = idSanPham;
    }

    public String getIdPhieuXuat() {
        return idPhieuXuat;
    }

    public void setIdPhieuXuat(String idPhieuXuat) {
        this.idPhieuXuat = idPhieuXuat;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }
    
    
}

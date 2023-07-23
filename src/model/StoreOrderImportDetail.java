
package model;


public class StoreOrderImportDetail {
    
    private String idPhieuNhap;
    private String idSanPham;

    public StoreOrderImportDetail() {
    }

    public StoreOrderImportDetail(String idPhieuNhap, String idSanPham) {
        this.idPhieuNhap = idPhieuNhap;
        this.idSanPham = idSanPham;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }
    
    
}

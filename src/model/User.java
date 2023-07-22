
package model;

import java.util.Date;


public class User {
    private String id;
    private String maNv;
    private String tenNV;
    private int tuoi;
    private String diaChi;
    private String email;
    private int gender;
    private String sdt;
    private String idKho;
    private Date ngayTao;
    private Date ngaySua;
    private int status;

    public User() {
    }

    public User(String id, String maNv, String tenNV, int tuoi, String diaChi, String email, int gender, String sdt, String idKho, Date ngayTao, Date ngaySua, int status) {
        this.id = id;
        this.maNv = maNv;
        this.tenNV = tenNV;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.email = email;
        this.gender = gender;
        this.sdt = sdt;
        this.idKho = idKho;
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

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getIdKho() {
        return idKho;
    }

    public void setIdKho(String idKho) {
        this.idKho = idKho;
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


package model;

import java.util.Date;


public class Account {
    
    private String id;
    private String iduser;
    private String maTk;
    private Date ngayTao;
    private Date ngaySua;
    private String username;
    private String passWord;
    private int status;

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", maTk=" + maTk + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", username=" + username + ", passWord=" + passWord + ", status=" + status + '}';
    }

    public Account() {
    }

    public Account(String id,String username, String passWord, int status) {
        this.id =id;
        this.username = username;
        this.passWord = passWord;
        this.status = status;
    }
    
    
    

    public Account(String id, String maTk, Date ngayTao, Date ngaySua, String username, String passWord, int status) {
        this.id = id;
        this.maTk = maTk;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.username = username;
        this.passWord = passWord;
        this.status = status;
    }

    public Account(String id, String iduser, String maTk, Date ngayTao, Date ngaySua, String username, String passWord, int status) {
        this.id = id;
        this.iduser = iduser;
        this.maTk = maTk;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.username = username;
        this.passWord = passWord;
        this.status = status;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaTk() {
        return maTk;
    }

    public void setMaTk(String maTk) {
        this.maTk = maTk;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}

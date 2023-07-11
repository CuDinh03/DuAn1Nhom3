/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maccuacu
 */
public class ImportOrderDetail {
    private String idPN;
    private String idSp;

    public ImportOrderDetail() {
    }

    public ImportOrderDetail(String idPN, String idSp) {
        this.idPN = idPN;
        this.idSp = idSp;
    }

    public String getIdPN() {
        return idPN;
    }

    public void setIdPN(String idPN) {
        this.idPN = idPN;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }
    
}

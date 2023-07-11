/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maccuacu
 */
public class AccountRole {
    private String idAccount;
    private String idRole;

    public AccountRole() {
    }

    public AccountRole(String idAccount, String idRole) {
        this.idAccount = idAccount;
        this.idRole = idRole;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }
    
    
    
}

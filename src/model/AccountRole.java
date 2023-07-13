
package model;


public class AccountRole {
    private String idAccount;
    private String idRole;

    public AccountRole(String idAccount) {
        this.idAccount = idAccount;
    }

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


package model;


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

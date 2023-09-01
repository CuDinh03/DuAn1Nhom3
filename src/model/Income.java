
package model;

import java.math.BigDecimal;
import java.util.Date;


public class Income {
    private String idCh;
    private String code;
    private BigDecimal total;
    private Date createDate;
    private Date updateDate;
    private int incomeStatus;

    public Income() {
    }

    public Income(String idCh, String code, BigDecimal total, Date createDate, Date updateDate, int incomeStatus) {
        this.idCh = idCh;
        this.code = code;
        this.total = total;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.incomeStatus = incomeStatus;
    }

    public String getIdCh() {
        return idCh;
    }

    public void setIdCh(String idCh) {
        this.idCh = idCh;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getIncomeStatus() {
        return incomeStatus;
    }

    public void setIncomeStatus(int incomeStatus) {
        this.incomeStatus = incomeStatus;
    }

   
   
}

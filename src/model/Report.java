
package model;


import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author maccuacu
 */

public class Report {
    private String id;
    private String code;
    private String reportDESCRIPTION;
    private String namerp;
    private String idnv;
    private String income;
    private Date createDate;
    private Date updateDate;
    private int rpStatus;

    public Report() {
    }

    public Report(String id, String code, String reportDESCRIPTION, String namerp, String idnv, String income, Date createDate, Date updateDate, int rpStatus) {
        this.id = id;
        this.code = code;
        this.reportDESCRIPTION = reportDESCRIPTION;
        this.namerp = namerp;
        this.idnv = idnv;
        this.income = income;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rpStatus = rpStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReportDESCRIPTION() {
        return reportDESCRIPTION;
    }

    public void setReportDESCRIPTION(String reportDESCRIPTION) {
        this.reportDESCRIPTION = reportDESCRIPTION;
    }

    public String getNamerp() {
        return namerp;
    }

    public void setNamerp(String namerp) {
        this.namerp = namerp;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
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

    public int getRpStatus() {
        return rpStatus;
    }

    public void setRpStatus(int rpStatus) {
        this.rpStatus = rpStatus;
    }




    
    
}

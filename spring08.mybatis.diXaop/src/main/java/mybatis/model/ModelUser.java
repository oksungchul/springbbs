package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ModelUser.class);
    String    userid;
    String    email;
    String    passwd;
    String    name;
    String    mobile;
    boolean   retireYN;;
    String    InsertUID;
    Date      InsertDT;
    String    UpdateUID;
    Date      UpdateDT;
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public boolean isRetireYN() {
        return retireYN;
    }
    public void setRetireYN(boolean retireYN) {
        this.retireYN = retireYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }
    public ModelUser() {
        super();
    }
}

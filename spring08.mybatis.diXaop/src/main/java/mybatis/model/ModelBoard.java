package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelBoard {
    String  boardcd;
    String  boardnm;
    Boolean UseYN;
    String  InsertUID;
    Date    InsertDT;
    String  UpdateUID;
    Date    UpdateDT;
    
    public ModelBoard() {
        super();
    }
    
    public String getBoardcd() {
        return boardcd;
    }
    
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    
    public String getBoardnm() {
        return boardnm;
    }
    
    public void setBoardnm(String boardnm) {
        this.boardnm = boardnm;
    }
    
    public Boolean getUseYN() {
        return UseYN;
    }
    
    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
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
}

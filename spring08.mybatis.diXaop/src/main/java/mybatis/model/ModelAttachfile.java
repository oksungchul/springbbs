package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelAttachfile {
    Integer attachfileno;
    String  filename;
    String  filetype;
    Integer filesize;
    Integer articleno;
    Boolean UseYN;
    String  InsertUID;
    Date    InsertDT;
    String  UpdateUID;
    Date    UpdateDT;
    
    public ModelAttachfile() {
        super();
    }

    public Integer getAttachfileno() {
        return attachfileno;
    }

    public void setAttachfileno(Integer attachfileno) {
        this.attachfileno = attachfileno;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getArticleno() {
        return articleno;
    }

    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
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

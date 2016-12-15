package mybatis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;

public interface IDAOBook {
    
    List<ModelBook> getSQLSelectAll() throws SQLException;
    
    List<ModelBook> getSQLSelectLike(String bookname)
            throws SQLException;
    
    List<ModelBook> getSQLSelectEqual(String bookname)
            throws SQLException;
    
    int setSQLInsert(String bookname, String publisher,
            String year, int price, String dtm, boolean use_yn, int authid)
            throws SQLException;
    
    int setSQLInsertSequence (String bookname, String publisher,
            String year, int price, String dtm, boolean use_yn, int authid)
            throws SQLException;
    
    int setSQLUpdate(String bookname, String year, int price)
            throws SQLException;
    
    int setSQLDelete( String bookname) throws SQLException;
    
}

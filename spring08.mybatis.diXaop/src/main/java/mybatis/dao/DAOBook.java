package mybatis.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBook;
@Repository
public class DAOBook implements IDAOBook {
    @Autowired
    SqlSession session;
    @Override
    public List<ModelBook> getSQLSelectAll()
            throws SQLException {
        List<ModelBook> result= null;
        
        result= session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
       
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectLike( String bookname)
            throws SQLException {
        List<ModelBook> result= null;
        
        result= session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike",bookname );
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectEqual( String bookname)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int setSQLInsert(String bookname, String publisher,
            String year, int price, String dtm, boolean use_yn, int authid)
            throws SQLException {
                int result=0;
        ModelBook book = new ModelBook(5,bookname,publisher,year,price,dtm,use_yn,authid);
        result= session.insert("mybatis.mapper.mapperBook.setSQLInsert",book);
       
        return result;
    }

    @Override
    public int setSQLInsertSequence(String bookname,
            String publisher, String year, int price, String dtm,
            boolean use_yn, int authid) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setSQLUpdate(String bookname, String year,
            int price) throws SQLException {
        // TODO Auto-generated method stub
        int result=0;
        ModelBook book = new ModelBook();
        book.setBookname(bookname);
        book.setYear(year);
        book.setPrice(price);
        result= session.update("mybatis.mapper.mapperBook.setSQLUpdate",book);
       
        return result;
    }

    @Override
    public int setSQLDelete(String bookname)
            throws SQLException {
        int result=0;
    
        result= session.delete("mybatis.mapper.mapperBook.setSQLDelete",bookname);
       
        return result;
    }

  

    public DAOBook(SqlSession conn) {
        super();
        this.session = conn;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DAOBook() {
        super();
    }
    
    
}
package mybatis.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.dao.*;
import mybatis.model.ModelBook;
@Service
public class ServiceBook implements IServiceBook {
    
    private static Logger           logger    = LoggerFactory
            .getLogger(ServiceBook.class);
    @Autowired
    private SqlSession session;
    
    @Override
    public List<ModelBook> getSQLSelectAll() {
       
        IDAOBook book = new DAOBook(session);
        List<ModelBook> result = null;
        try {
            result = book.getSQLSelectAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectAll" + e.getMessage());
            
        }
        
        
        return result;
    }
    
    @Override
    public List<ModelBook> getSQLSelectLike(String expr) {
       
        IDAOBook book = new DAOBook(session);
        List<ModelBook> result = null;
        try {
            result = book.getSQLSelectLike(expr);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectAll" + e.getMessage());
            
        }
        
        
        return result;
    }
    
    @Override
    public List<ModelBook> getSQLSelectEqual(String expr) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int setSQLInsert(String bookname, String publisher, String year,
            int price, String dtm, boolean use_yn, int authid) {
        // TODO Auto-generated method stub
       
        IDAOBook book = new DAOBook(session);
        int result = 0;
        try {
            result = book.setSQLInsert(bookname, publisher, year, price, dtm,
                    use_yn, authid);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectAll" + e.getMessage());
            
        }
        session.commit();
        
        return result;
    }
    
    @Override
    public int setSQLUpdate(String bookname, String year, int price) {
       
        IDAOBook book = new DAOBook(session);
        int result = 0;
        try {
            result = book.setSQLUpdate(bookname, year, price);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectAll" + e.getMessage());
            
        }
        session.commit();
        
        return result;
    }
    
    @Override
    public int setSQLDelete(String bookname) {
       
        IDAOBook book = new DAOBook(session);
        int result = 0;
        try {
            result = book.setSQLDelete(bookname);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getSQLSelectAll" + e.getMessage());
            
        }
        session.commit();
        
        return result;
    }
    
    @Override
    public int setTransCommit(String bookname) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int setTransRollback(String bookname) {
        // TODO Auto-generated method stub
        return 0;
    }

    public ServiceBook() {
        super();
    }

    public ServiceBook(SqlSession session) {
        super();
        this.session = session;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }
    
}

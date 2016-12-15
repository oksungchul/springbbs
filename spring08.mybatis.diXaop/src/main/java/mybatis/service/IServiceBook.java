package mybatis.service;

import java.util.List;

import mybatis.model.ModelBook;

public interface IServiceBook {

    public List<ModelBook> getSQLSelectAll() ;
     
    public List<ModelBook> getSQLSelectLike(String expr) ;

    public List<ModelBook> getSQLSelectEqual(String expr) ;

    public int setSQLInsert( String bookname
            , String publisher
            , String year
            , int price
            , String dtm
            , boolean use_yn
            , int authid ) ;

    public int setSQLUpdate(String bookname, String year, int price ) ;

    public int setSQLDelete(String bookname) ;
    
    public int setTransCommit(String bookname) ;

    public int setTransRollback(String bookname);
   
}

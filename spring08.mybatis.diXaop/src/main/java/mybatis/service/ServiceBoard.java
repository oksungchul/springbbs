package mybatis.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DAOBoard;
import mybatis.dao.IDaoBoard;
import mybatis.model.*;

@Service("boardservice")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);
 //   public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();
    @Autowired
    @Qualifier("boarddao")
    IDaoBoard dao;
    @Override
    public String getBoardName(String boardcd) {
        String result = "";
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getBoardName(boardcd);
        
        return result;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard result = null;
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getBoardOne(boardcd);
        
        return result;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        List<ModelBoard> result;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.getBoardList();
        
        return result;
    }
    
    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        Map<String, ModelBoard> result;
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getBoardListResultMap();
        
        return result;
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        try {
            result = dao.insertBoard(board);
        } catch (SQLException e) {
            
        }
        
        
        return result;
    }
    
    @Override
    public int updateBoard(ModelBoard searchvalue,ModelBoard updatevalue) throws SQLException {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        try {
            result = dao.updateBoard(searchvalue,updatevalue);
            
        } catch (SQLException e) {
        }
        
        return result;
    }
    
    @Override
    public int deleteBoard(ModelBoard  boardcd) throws SQLException {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        try {
            result = dao.deleteBoard(boardcd);
        } catch (SQLException e) {
        }
        
        //
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard boardcd) {
        List<ModelBoard> result;
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getBoardSearch(boardcd);
        
        return result;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd,String searchWord,int start,int end) {
        List<ModelBoard> result;
        //  SqlSession session = sqlMapper.openSession();
          
          result = dao.getBoardPaging(boardcd, searchWord, start, end);
          
          
          return result;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.insertBoardList(list);
        
        
        return result;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        List<ModelArticle> result;
      //  SqlSession session = sqlMapper.openSession();
        
        result = dao.getArticleList(boardCd, searchWord, start, end);
        
        
        return result;
    }
    
    @Override
    public ModelArticle getArticle(int articleNo) {
        ModelArticle result;
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getArticle(articleNo);
        dao.increaseHit(articleNo);
        
        
        return result;
    }
    
    @Override
    public int getArticleTotalRecord(String boardCd, String searchWord) {
        int result = 0;
      //  SqlSession session = sqlMapper.openSession();
        
        result = dao.getArticleTotalRecord(boardCd, searchWord);
        
        
        return result;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.insertArticle(article);
        
        
        return result;
    }
    
    @Override
    public int updateArticle(ModelArticle searchvalue,ModelArticle updatevalue) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.updateArticle(searchvalue,updatevalue);
        
        
        return result;
    }
    
    @Override
    public int deleteArticle(ModelArticle articleNo) {
        int result = 0;
      //  SqlSession session = sqlMapper.openSession();
        
        result = dao.deleteArticle(articleNo);
        
        
        return result;
    }
    
    @Override
    public int increaseHit(int articleNo) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.increaseHit(articleNo);
        
        
        return result;
    }
    
    @Override
    public ModelArticle getNextArticle(int articleNo, String boardCd,
            String searchWord) {
        ModelArticle result;
       // session = sqlMapper.openSession();
        
        Map<String,String> hashmap=new HashMap<String,String>();
        hashmap.put("boardCd", boardCd);
        hashmap.put("articleNo",  Integer.toString(articleNo));
        hashmap.put("searchWord", searchWord);
        
        result = dao.getNextArticle(hashmap);
        
        
        return result;
    }
    
    @Override
    public ModelArticle getPrevArticle(int articleNo, String boardCd,
            String searchWord) {
        ModelArticle result;
     //   SqlSession session = sqlMapper.openSession();
        
        HashMap<String,String> hashmap=new HashMap<String,String>();
        hashmap.put("boardCd", boardCd);
        hashmap.put("articleNo",  Integer.toString(articleNo));
        hashmap.put("searchWord", searchWord);
        
        result = dao.getPrevArticle(hashmap);
        
        
        return result;
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        List<ModelAttachfile> result ;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.getAttachFileList(articleNo);
        
        
        return result;
    }
    
    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        ModelAttachfile result ;
      //  SqlSession session = sqlMapper.openSession();
        
        result = dao.getAttachFile(attachFileNo);
        
        
        return result;
    }
    
    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.insertAttachFile(attachFile);
        
        
        return result;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachfile attachFileNo) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.deleteAttachFile(attachFileNo);
        
        
        return result;
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        List<ModelComments> result;
      // SqlSession session = sqlMapper.openSession();
        
        result = dao.getCommentList(articleNo);
        
        
        return result;
    }
    
    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments result;
        //SqlSession session = sqlMapper.openSession();
        
        result = dao.getComment(commentNo);
        
        
        return result;
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.insertComment(comment);
        
        
        return result;
    }
    
    @Override
    public int updateComment(ModelComments searchvalue,ModelComments updatevalue) {
        int result = 0;
       // SqlSession session = sqlMapper.openSession();
        
        result = dao.updateComment(searchvalue,updatevalue);
        
        
        return result;
    }
    
    @Override
    public int deleteComment(ModelComments commentNo) {
        int result = 0;
     //   SqlSession session = sqlMapper.openSession();
        
        result = dao.deleteComment(commentNo);
        
        
        return result;
    }
  
    public ServiceBoard() {
        super();
    }

    public IDaoBoard getDao() {
        return dao;
    }

    public void setDao(IDaoBoard dao) {
        this.dao = dao;
    }
}

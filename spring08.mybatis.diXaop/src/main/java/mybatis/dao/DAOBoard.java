package mybatis.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
@Repository("boarddao")

public class DAOBoard implements IDaoBoard {
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String getBoardName(String boardcd) {
      
        return  session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);
        
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {

        return  session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);
        
    }
    
    @Override
    public List<ModelBoard> getBoardList() {

        return  session.selectList("mybatis.mapper.mapperBoard.getBoardList");
        
    }
    
    @Override
    public Map<String,ModelBoard> getBoardListResultMap() {
     
        return  session.selectMap("mybatis.mapper.mapperBoard.getBoardListreturnMap","boardcd");
        
    }
    
    @Override
    public int insertBoard(ModelBoard board) throws SQLException {

        return  session.insert("mybatis.mapper.mapperBoard.insertBoard",board);
        
    }
    
    @Override
    public int updateBoard(ModelBoard searchvalue,ModelBoard updatevalue) throws SQLException {
     
        Map<String,ModelBoard> map = new HashMap<>();
        map.put("searchValue",searchvalue);
        map.put("updateValue",updatevalue);
        return  session.update("mybatis.mapper.mapperBoard.updateBoard",map);
        
    }
    
    @Override
    public int deleteBoard(ModelBoard boardcd) throws SQLException {
             return  session.delete("mybatis.mapper.mapperBoard.deleteBoard",boardcd);
        
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {

        return  session.selectList("mybatis.mapper.mapperBoard.getBoardSearch", board);
        
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd,String searchWord,int start,int end) {

        Map<String,String> article =new HashMap<String,String>();
        article.put("boardcd", boardcd);
        article.put("searchWord", searchWord);
        article.put("start",Integer.toString(start));
        article.put("end",Integer.toString(end) );
        return  session.selectList("mybatis.mapper.mapperBoard.getBoardPaging",article);
        
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {

        return  session.insert("mybatis.mapper.mapperBoard.insertBoardList", list);
        
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd,
            String searchWord) {

        Map<String,String> article =new HashMap<String,String>();
        article.put("boardcd", boardcd);
        article.put("searchWord", searchWord);
        return  session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord",article);
        
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd,
            String searchWord, int start, int end) {

        Map<String,String> article= new HashMap<String,String>();
        article.put("boardcd", boardcd);
        article.put("searchWord", searchWord);
        article.put("start",Integer.toString(start));
        article.put("end",Integer.toString(end) );
        return  session.selectList("mybatis.mapper.mapperBoard.getArticleList",article);
        
    }
    
    @Override
    public ModelArticle getArticle(int articleNo) {
    
        return  session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleNo);
        
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
      return  session.insert("mybatis.mapper.mapperBoard.insertArticle",article);
        
    }
    
    @Override
    public int updateArticle( ModelArticle searchvalue,ModelArticle updatevalue) {
  
        Map<String,ModelArticle> map  =new HashMap<>();
        map.put("searchValue",searchvalue);
        map.put("updateValue",updatevalue);
        return  session.update("mybatis.mapper.mapperBoard.updateArticle",map);
        
    }
    
    @Override
    public int deleteArticle(ModelArticle article) {
      
        return  session.delete("mybatis.mapper.mapperBoard.deleteArticle",article);
        
    }
    
    @Override
    public int increaseHit( int articleNo) {

        return  session.update("mybatis.mapper.mapperBoard.increaseHit",articleNo);
        
    }
    
    @Override
    public ModelArticle getNextArticle(
            Map<String, String> hashmap) {

        return  session.selectOne("mybatis.mapper.mapperBoard.getNextArticle",hashmap);
        
    }
    
    @Override
    public ModelArticle getPrevArticle(
            Map<String, String> hashmap) {

        return  session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle",hashmap);
        
        
    }
    
    @Override
    public ModelAttachfile getAttachFile( int attachFileNo) {
  
        return  session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachFileNo);
        
    }
    
    @Override
    public List<ModelAttachfile> getAttachFileList(
            int articleNo) {
       
        return  session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", articleNo);
        
    }
    
    @Override
    public int insertAttachFile(
            ModelAttachfile attachFile) {
       
        return  session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile);
        
    }
    
    @Override
    public int deleteAttachFile( ModelAttachfile attachFileNo) {
     
        return  session.delete("mybatis.mapper.mapperBoard.deleteAttachFile", attachFileNo);
        
    }
    
    @Override
    public int insertComment( ModelComments comment) {
    
        return  session.insert("mybatis.mapper.mapperBoard.insertComment", comment);
        

    }
    
    @Override
    public int updateComment( ModelComments searchvalue,ModelComments updatevalue) {
  
        Map<String,ModelComments> map = new HashMap<>();
        map.put("searchValue",searchvalue);
        map.put("updateValue",updatevalue);
        return  session.update("mybatis.mapper.mapperBoard.updateComment", map);
        

    }
    
    @Override
    public int deleteComment( ModelComments commentNo) {
     
        return  session.delete("mybatis.mapper.mapperBoard.deleteComment", commentNo);
        
    }
    
    @Override
    public ModelComments getComment( int commentNo) {
       
        return  session.selectOne("mybatis.mapper.mapperBoard.getComment", commentNo);
        
    }
    
    @Override
    public List<ModelComments> getCommentList(
            int articleno) {
       
        return  session.selectList("mybatis.mapper.mapperBoard.getCommentList", articleno);
        
    }



    public DAOBoard(SqlSession conn) {
        super();
        this.session = conn;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DAOBoard() {
        super();
    }
}

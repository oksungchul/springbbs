package mybatis.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.service.IServiceBoard;
import mybatis.service.IServiceUser;
import mybatis.service.ServiceBoard;

public class TestServiceBoard {
    // SLF4J Logging
   
    
    private static ApplicationContext context =null;
    private static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
       context=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
       service =  context.getBean("boardservice",IServiceBoard.class);
        
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
       
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void getBoardName() {
        
        String result = "";
        result = service.getBoardName("free");
        assertEquals(result, "자유게시판");
    }
    
    @Test
    public void getBoardOne() {
        
        ModelBoard result = null;
        result = service.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
    }
    
    @Test
    public void getBoardTotalRecord() {
        // TODO Auto-generated method stub
        
    }
    
    @Test
    public void getBoardList() {
        // TODO Auto-generated method stub
        
        List<ModelBoard> result = null;
        result = service.getBoardList();
        assertEquals(result.size(), 3);
    }
    
    @Test
    public void getBoardListResultMap() {
        
        Map<String, ModelBoard> result = null;
        result = service.getBoardListResultMap();
        assertEquals(result.size(), 3);
        
    }
    
    @Test
    public void insertBoard() throws SQLException {
        
        int result = 0;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notice");
        board.setBoardnm("공지사항");
        board.setUseYN(true);
        board.setInsertUID("a");
        board.setUpdateDT(new Date());
        board.setInsertDT(new Date());
        board.setUpdateUID("a");
        result = service.insertBoard(board);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void updateBoard() throws SQLException {
        // TODO Auto-generated method stub
        
        int result = 0;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notice");
        board.setBoardnm("공지사항");
        ModelBoard board1 = new ModelBoard();
        board1.setBoardnm("공지사");
        board1.setUseYN(true);
        board1.setUpdateDT(new Date());
        board1.setUpdateUID("b");
        result = service.updateBoard(board,board1);
        assertEquals(result, 1);
    }
    
    @Test
    public void deleteBoard() throws SQLException {
        // TODO Auto-generated method stub
        
        int result = 0;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("notice");
        result = service.deleteBoard(board);
        assertEquals(result, 1);
    }
    
    @Test
    public void getBoardSearch() {
        
        List<ModelBoard> result = null;
        ModelBoard board = new ModelBoard();
        board.setBoardcd("free");
        
        result = service.getBoardSearch(board);
        assertEquals(result.size(), 1);
    }
    
    @Test
    public void getBoardPaging() {
        
        
        
        List<ModelBoard> result = service.getBoardPaging("free", "", 1, 2);
        assertEquals(result.size(),6);
        
    }
    
    @Test
    public void insertBoardList() {
        
        List<ModelBoard> list = new ArrayList<>();
        int result =0;
        for (int i = 0; i < 10; i++) {
            ModelBoard board = new ModelBoard();
            board.setBoardcd("notice"+i);
            board.setBoardnm("공지사항");
            board.setUseYN(true);
            board.setInsertUID("a");
            board.setUpdateDT(new Date());
            board.setInsertDT(new Date());
            board.setUpdateUID("a");
            list.add(board);
        }
        result = service.insertBoardList(list);
        assertEquals(result, 10);;
        
    }
    
    @Test
    public void getArticleList() {
        
        
        
        List<ModelArticle> result = service.getArticleList("free", "", 1, 6);
        assertEquals(result.size(),6);
        
    }
    
    @Test
    public void getArticle() {
        
        
       
        ModelArticle result = service.getArticle(1);
        assertEquals(result.getTitle(), "article test 01");
        
    }
    
    @Test
    public void getArticleTotalRecord() {
        
        String boardcd="free";
        String searchword="";
       
        int result = service.getArticleTotalRecord(boardcd, searchword);
        assertEquals(result, 14);
        
    }
    
    @Test
    public void insertArticle() {
        
        int result = 0;
        ModelArticle board = new ModelArticle();
        board.setBoardcd("free");
        board.setTitle("a");
        board.setContent("a");
        board.setEmail("a");
        board.setRegdate(new Date());
        board.setInsertUID("a");
        board.setUpdateDT(new Date());
        board.setInsertDT(new Date());
        board.setUpdateUID("a");
        result = service.insertArticle(board);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void updateArticle() {
        
        int result = 0;
        ModelArticle board = new ModelArticle();
        board.setArticleno(44);
        ModelArticle board1 = new ModelArticle();
        board1.setBoardcd("free");
        board1.setTitle("asa");
        board1.setContent("as");
       board1.setUpdateDT(new Date());
       board1.setUpdateUID("as");
       board1.setUseYN(true);
        result = service.updateArticle(board,board1);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void deleteArticle() {
        
        int result = 0;
        ModelArticle article =new ModelArticle();
        article.setArticleno(42);
        result = service.deleteArticle(article);
        assertEquals(result, 1);
    }
    
    @Test
    public void increaseHit() {
        
        int result = 0;
        result = service.increaseHit(1);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void getNextArticle() {
        
        ModelArticle result=null; 
       
        result = service.getNextArticle(8, "free", "");
        assertEquals(result.getTitle(),"article test 09");
    }
    
    @Test
    public void getPrevArticle() {
        
        ModelArticle result=null; 
       
        result = service.getPrevArticle(8, "free", "");
       
        assertEquals(result.getTitle(),"article test 07");
        
    }
    
    @Test
    public void getAttachFileList() {
        
        List<ModelAttachfile> result=null; 
       
        result = service.getAttachFileList(1);
       
        assertEquals(result.size(),3);
    }
    
    @Test
    public void getAttachFile() {
        
        ModelAttachfile result=null; 
       
        result = service.getAttachFile(2);
       
        assertEquals(result.getFilename(),"a");
    }
    
    @Test
    public void insertAttachFile() {
        
        int result = 0;
        ModelAttachfile board = new ModelAttachfile();
        board.setFilename("a");
        board.setFilesize(12);
        board.setFiletype("a");
        board.setArticleno(1);
        board.setInsertUID("a");
        board.setUpdateDT(new Date());
        board.setInsertDT(new Date());
        board.setUpdateUID("a");
        result = service.insertAttachFile(board);
        assertEquals(result, 1);
    }
    
    @Test
    public void deleteAttachFile() {
        
        int result = 0;
        ModelAttachfile a =new ModelAttachfile();
        a.setArticleno(1);
        a.setAttachfileno(21);
        result = service.deleteAttachFile(a);
        assertEquals(result, 1);
    }
    
    @Test
    public void getCommentList() {
        
        List<ModelComments> result;
 
       
        result = service.getCommentList(1);
        assertEquals(result.size(), 1);
    }
    
    @Test
    public void getComment() {
        
        ModelComments result;
        result = service.getComment(1);
        assertEquals(result.getMemo(), "comment test");
        
    }
    
    @Test
    public void insertComment() {
        
        int result = 0;
        ModelComments board = new ModelComments();
        board.setArticleno(1);
        board.setEmail("a");
        board.setMemo("a");
        board.setInsertUID("a");
        board.setUpdateDT(new Date());
        board.setInsertDT(new Date());
        board.setUpdateUID("a");
        board.setRegdate(new Date());
        result = service.insertComment(board);
        assertEquals(result, 1);
    }
    
    @Test
    public void updateComment() {
        
        int result = 0;
        ModelComments board = new ModelComments();
        board.setCommentno(42);
        ModelComments board2 = new ModelComments();
        board2.setUseYN(false);
        board2.setMemo("c");
        board2.setEmail("as");
        result = service.updateComment(board,board2);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void deleteComment() {
        
        int result = 0;
        ModelComments comment = new ModelComments();
        comment.setCommentno(42);
        result = service.deleteComment(comment);
        assertEquals(result, 1);
    }
}

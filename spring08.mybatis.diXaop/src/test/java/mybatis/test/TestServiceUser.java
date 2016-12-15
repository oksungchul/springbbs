package mybatis.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import mybatis.model.ModelUser;
import mybatis.service.IServiceBoard;
import mybatis.service.IServiceUser;
import mybatis.service.ServiceBoard;
import mybatis.service.ServiceUser;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUser {
    // SLF4J Logging
    private static Logger     logger  = LoggerFactory
            .getLogger(TestServiceUser.class);
   
    private static ApplicationContext context =null;
    private static IServiceUser service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        service =  context.getBean("userservice",IServiceUser.class);
       
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
      // ((ClassPathXmlApplicationContext)context).close();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testInsert() {
        ModelUser user = new ModelUser();
       // IServiceUser service = new ServiceUser(session);
        user.setEmail("a");
        user.setUserid("c");
        user.setInsertDT(new Date());
        user.setMobile("a");
        user.setName("a");
        user.setPasswd("a");
        user.setRetireYN(true);
        user.setUpdateDT(new Date());
        int result = service.insertUser(user);
        assertEquals(result, 1);
    }
    
    @Test
    public void testLogin() {
        ModelUser user = new ModelUser();
      // IServiceUser service = new ServiceUser(session);
        user.setPasswd("a");
        user.setUserid("b");
        ModelUser result = service.LoginUser(user);
        assertEquals(result.getPasswd(), "a");
        
    }
    
    @Test
    public void testUpdateUserInfo() {
        ModelUser user = new ModelUser();
        
        //IServiceUser service = new ServiceUser(session);
        user.setEmail("b");
        user.setMobile("b");
        user.setName("b");
        user.setPasswd("b");
        user.setRetireYN(false);
        user.setUpdateDT(new Date());
        ModelUser user1 = new ModelUser();
        
        user1.setUserid("a");
        int result = service.updateUserInfo(user1, user);
        assertEquals(result, 1);
    }
    
    @Test
    public void testdelete() {
        //IServiceUser service = new ServiceUser(session);
        int result = service.deleteUser("b");
        assertEquals(result, 1);
    }
    
    @Test
    public void testUpdatePasswd() {
        ModelUser user = new ModelUser();
        
        //IServiceUser service = new ServiceUser(session);
        
        user.setPasswd("c");
        ModelUser user1 = new ModelUser();
        
        user1.setUserid("a");
        int result = service.updatePasswdUser(user1, user);
        assertEquals(result, 1);
        
    }
    
    @Test
    public void testSelectOne() {
        //IServiceUser service = new ServiceUser(session);
        
        ModelUser result = service.selectoneUser("a");
        assertEquals(result.getPasswd(), "c");
        
    }
    
    @Test
    public void testSelectList() {
        ModelUser user = new ModelUser();
        //IServiceUser service = new ServiceUser(session);
        user.setUserid("a");
        List<ModelUser> result = service.selectUserList(user);
        assertEquals(result.size(), 1);
        
    }
}

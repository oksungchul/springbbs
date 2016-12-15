package mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;
import mybatis.service.IServiceBook;
import mybatis.service.ServiceBook;

public class TestServiceBook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBook.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
    public void testGetSQLselectAll() {
        IServiceBook service= new ServiceBook();
        List<ModelBook> result= service.getSQLSelectAll();
        
        assertSame(result.size(), 4);
    }
    @Test
    public void testGetSQLselectLike() {
        IServiceBook service= new ServiceBook();
        List<ModelBook> result= service.getSQLSelectLike("JAV");
        
        assertSame(result.size(), 1);
    }
    @Test
    public void testsetSQLInsert() {
        IServiceBook service= new ServiceBook();
        service.setSQLInsert("1","1", "1999", 1000, "1999/12/10", true,15);
         List<ModelBook> result=service.getSQLSelectAll();
        assertSame(result.size(), 5);
    }
    @Test
    public void testsetSQLUpdate() {
        IServiceBook service= new ServiceBook();
        service.setSQLUpdate("1", "2016",1000);
         List<ModelBook> result=service.getSQLSelectAll();
        assertSame(result.size(), 5);
    }
    @Test
    public void testsetSQLDelete() {
        IServiceBook service= new ServiceBook();
        service.setSQLDelete("1");
         List<ModelBook> result=service.getSQLSelectAll();
        assertSame(result.size(), 4);
    }
}

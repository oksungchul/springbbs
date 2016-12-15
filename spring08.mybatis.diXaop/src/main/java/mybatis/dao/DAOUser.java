package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelUser;

@Repository("userdao")
public class DAOUser implements IDaoUser {
    // SLF4J Logging
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public int insertUser(ModelUser user) {
       
        return session.insert("mybatis.mapper.mapperUser.insert",user);
       
    }
    
    @Override
    public ModelUser LoginUser(ModelUser user) {
        
        return session.selectOne("mybatis.mapper.mapperUser.login",user);
        
    }
    
    @Override
    public int LogoutUser(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser searchvalue, ModelUser updatevalue) {
        
        Map<String, ModelUser> map =new HashMap<>();
        map.put("searchvalue", searchvalue);
        map.put("updatevalue",  updatevalue);
        return session.update("mybatis.mapper.mapperUser.updateUserInfo",map);
        
    }
    
    @Override
    public int deleteUser(String userid) {
        
        return session.update("mybatis.mapper.mapperUser.delete",userid);
        
    }
    
    @Override
    public int updatePasswdUser(ModelUser searchvalue, ModelUser updatevalue) {
      
        Map<String, ModelUser> map =new HashMap<>();
        map.put("searchvalue", searchvalue);
        map.put("updatevalue",  updatevalue);
        return session.update("mybatis.mapper.mapperUser.updatePasswd",map);
        
    }
    
    @Override
    public ModelUser selectoneUser(String userid) {
   
        return session.selectOne("mybatis.mapper.mapperUser.selectOne",userid);
        
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser userid) {
     
        return session.selectList("mybatis.mapper.mapperUser.selectUserList",userid);
        
    }

 

    public DAOUser(SqlSession conn) {
        super();
        this.session = conn;
    }

    public SqlSession getSession() {
        return session;
    }

    public void setSession(SqlSession session) {
        this.session = session;
    }

    public DAOUser() {
        super();
    }
}

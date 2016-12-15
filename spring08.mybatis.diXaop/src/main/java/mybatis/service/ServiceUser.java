package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DAOUser;
import mybatis.dao.IDaoUser;
import mybatis.model.ModelUser;
@Service("userservice")
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    @Autowired
    @Qualifier("userdao")
    IDaoUser dao;
 
    
  
    @Override
    public int insertUser(ModelUser user) {
        int result=0;
         
        result = dao.insertUser(user);
        
        return result;
    }
    
    @Override
    public ModelUser LoginUser(ModelUser user) {
        ModelUser result;
 
        result = dao.LoginUser(user);
        
        return result;
    }
    
    @Override
    public int LogoutUser(String userid) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateUserInfo(ModelUser searchvalue, ModelUser updatevalue) {
        int result=0;
        
        result = dao.updateUserInfo(searchvalue, updatevalue);
        
        return result;
    }
    
    @Override
    public int deleteUser(String userid) {
       int result;
        
        result = dao.deleteUser(userid);
        
        return result;
    }
    
    @Override
    public int updatePasswdUser(ModelUser searchvalue, ModelUser updatevalue) {
        int result=0;
        
        result = dao.updatePasswdUser(searchvalue, updatevalue);
        
        return result;
    }
    
    @Override
    public ModelUser selectoneUser(String userid) {
        ModelUser result;
        
        result = dao.selectoneUser(userid);
     //   
        return result;
    }
    
    @Override
    public List<ModelUser> selectUserList(ModelUser userid) {
        List<ModelUser> result;
        
        result = dao.selectUserList(userid);
        
        return result;
    }
    public ServiceUser() {
        super();
    }

    public IDaoUser getDao() {
        return dao;
    }

    public void setDao(IDaoUser dao) {
        this.dao = dao;
    }
    

  
}

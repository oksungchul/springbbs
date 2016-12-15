package mybatis.service;

import java.util.List;

import mybatis.model.ModelUser;

public interface IServiceUser {
    public abstract int insertUser(ModelUser user);
    public abstract ModelUser LoginUser(ModelUser user);
    public abstract int LogoutUser(String userid);
    
    public abstract int updateUserInfo(ModelUser searchvalue,ModelUser updatevalue);
    public abstract int deleteUser(String userid);
    public abstract int updatePasswdUser(ModelUser searchvalue,ModelUser updatevalue);
    public abstract ModelUser selectoneUser(String userid);
    public abstract List<ModelUser> selectUserList(ModelUser userid);
    
    
}

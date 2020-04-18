package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;

public interface UserService {

    public boolean queryUserIsExist(String userName);

    public Users createUsers(UserBo users);
}

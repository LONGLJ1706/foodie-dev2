package com.imooc.service.impl;

import com.imooc.enums.Sex;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtil;
import com.imooc.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    public  static  final  String user_face="http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUserIsExist(String userName) {
        Example userExample=new Example(Users.class);
        Example.Criteria userCriteria=userExample.createCriteria();
        userCriteria.andEqualTo("username", userName);
        Users result= usersMapper.selectOneByExample(userExample);
        boolean bool=result==null ? false:true;
        return bool;
    }

    public Users createUsers(UserBo users) {
        Users newUsers=new Users();
        String userid=sid.nextShort();
        newUsers.setId(userid);
        newUsers.setUsername(users.getUsername());
        try {
            newUsers.setPassword(MD5Utils.getMD5Str(users.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        newUsers.setNickname(users.getUsername());
        newUsers.setFace(user_face);
        newUsers.setBirthday(DateUtil.stringToDate("1990-01-02"));
        newUsers.setSex(Sex.secret.type);
        newUsers.setCreatedTime(DateUtil.getCurrentDateTime());
        newUsers.setUpdatedTime(DateUtil.getCurrentDateTime());
        usersMapper.insert(newUsers);
        return newUsers;
    }
}

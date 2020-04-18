package com.imooc.service.impl;

import com.imooc.mapper.StuMapper;
import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Stu getStuById(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    public void saveStu(Stu stu){

    }

    public void saveChildernStu() {
       Stu stu=new Stu();
       stu.setName("childern");
       stu.setAge(24);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveParentStu() {
        Stu stu=new Stu();
        stu.setName("parent");
        stu.setAge(28);
        stuMapper.insert(stu);
    }


    public void updateStu(Stu stu) {

    }

    public void deleteStuById(int id) {

    }
}

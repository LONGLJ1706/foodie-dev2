package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {

    public Stu getStuById(Integer id);

    public void saveStu(Stu stu);

    public void updateStu(Stu stu);

    public void deleteStuById(int id);
}

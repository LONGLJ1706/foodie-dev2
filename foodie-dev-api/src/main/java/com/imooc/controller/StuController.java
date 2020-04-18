package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.service.StuService;
import com.imooc.service.impl.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {

    @Autowired
    private StuServiceImpl stuService;

    @GetMapping("/getStu")
    public Stu getStuById(Integer id){
        return  stuService.getStuById(id);
    }

    @PostMapping("/save")
    @Transactional(propagation = Propagation.REQUIRED)
    public String save(){
        stuService.saveChildernStu();
        int a=1/0;
        stuService.saveParentStu();
        return  "ok";
    }

}

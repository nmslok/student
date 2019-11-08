package com.gzy.student.controller;

import com.gzy.student.entity.Student;
import com.gzy.student.repository.StudentRepository;
import org.hibernate.sql.OracleJoinFragment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class controller {
    @Resource
    StudentRepository studentRepository;

    //添加新数据
    @RequestMapping("/add")
    public Object add(String sid,String name,String sex,Integer age,String remark){


        Student student = new Student();

        student.setSid(sid);
        student.setName(name);
        student.setSex(sex);
        student.setAge(age);
        student.setRemark(remark);

        Student student1 = studentRepository.save(student);
        return student1;
    }

    //按id查找
    @GetMapping("/{sid}")
    public Object fndStudent(@PathVariable("sid") String sid){
        Student student = studentRepository.findStudentBySid(sid);
        if (student==null){
            //return ResponseEntity.badRequest().body("请输入用户名称");
            return ResponseEntity.badRequest().body("无此用户");
        }
        return student;
    }
//按id删除
    @GetMapping("/delete")
    public Object deleteStudent(String sid){
        Integer student = studentRepository.deleteStudentBySid(sid);
        return student;
    }
   //查询所有
    @GetMapping("/studyall")
    public List<Student> findStudentAll(){
        return studentRepository.findAll();
    }

    //更新数据
  @GetMapping("/update")
   public Integer update( String sid, Integer age, String name,String sex, String remark) {
            Integer s = studentRepository.updataNameBySid(sid, age, name, sex, remark);
            return s;
 }


}

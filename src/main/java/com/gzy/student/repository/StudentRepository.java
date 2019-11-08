package com.gzy.student.repository;

import com.gzy.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
@Transactional
public interface StudentRepository extends JpaRepository<Student,String> {
    Student findStudentBySid(String sid);
    Integer deleteStudentBySid(String sid);


    //https://blog.csdn.net/xlp789/article/details/82913408
    @Modifying
   @Query(value = "update student set  sid = :sid,age = :age,name = :name ,remark = :remark,sex = :sex where sid = :sid",
           nativeQuery = true)
    Integer updataNameBySid( String sid,  Integer age, String name, String sex, String remark);

}

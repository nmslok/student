package com.gzy.student.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"sid"})})
public class Student {
    @Id
    private String sid;
    private String name;
    private String sex;
    private Integer age;
    private String remark;

}

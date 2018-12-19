package com.vily.demo3.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @NotBlank(message = "参数id不能为空")
    private String id;

    private String name;
}

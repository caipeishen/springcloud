package cn.bd.springcloud.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String userName;

    private String userPassword;

    private Integer userGender;

    private Date createDate;

}

package com.cp.shardingspheresubdatabasetable.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description
 * @author: chenping
 * @create: 2020
 **/
@Data
public class User {
    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;


    /**
     * 年龄
     */
    private Integer age;

    private Integer region;

}

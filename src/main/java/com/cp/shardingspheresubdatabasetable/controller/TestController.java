package com.cp.shardingspheresubdatabasetable.controller;

import com.cp.shardingspheresubdatabasetable.entity.User;
import com.cp.shardingspheresubdatabasetable.mapper.UserMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-06-21
 */
@RestController
public class TestController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/list")
    public String list() {
        User user = mapper.selectById(481519049071656961L);
        return user.toString();
    }

    @RequestMapping("/insert")
    public int insert() {
        User user = new User();
        Long id = (Long) new SnowflakeShardingKeyGenerator().generateKey();
        user.setId(id);
        user.setAge(22);
        user.setName("jjjack");
        int result = mapper.inserts(user);

        return result;
    }
}

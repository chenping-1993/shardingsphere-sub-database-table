package com.cp.shardingspheresubdatabasetable.controller;

import com.cp.shardingspheresubdatabasetable.entity.TestTable;
import com.cp.shardingspheresubdatabasetable.entity.User;
import com.cp.shardingspheresubdatabasetable.mapper.TestTableMapper;
import com.cp.shardingspheresubdatabasetable.mapper.UserMapper;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 分表、不分表测试控制类
 * @Author: chenping
 * @Date: 2020-06-21
 */
@RestController
public class TestController {

    @Autowired
    UserMapper mapper;

    @Autowired
    TestTableMapper testTableMapper;

    /** 
     * @Description: 分表-- 根据id和地区id查询用户 region 必传
     * @param:  
     * @return: java.lang.String 
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/listById")
    public String list() {
        User user = mapper.selectById(486306718741954561L,1000);
        return user.toString();
    }

    /** 
     * @Description:  分表--- 插叙分表的所有数据
     * @param: region 分表策略字段 必传
     * @return: java.lang.String 
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/listAll")
    public String listAll(@RequestParam(value="region") Integer region) {
        List<User> user = mapper.selectAll(region);
        return user.toString();
    }

    /** 
     * @Description: 分表-- 根据地区插入用户
     * @param: region 分表策略字段 必传
     * @return: int 
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/insert")
    public int insert(@RequestParam(value="region") Integer region) {
        User user = new User();
        Long id = (Long) new SnowflakeShardingKeyGenerator().generateKey();//唯一id
        user.setId(id);
        user.setRegion(region);
        user.setAge(18);
        user.setName("James");
        int result = mapper.inserts(user);

        return result;
    }

    /**
     * @Description: 不分表 test表，根据id查询
     * @param:
     * @return: java.lang.String
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/getById")
    public String testById() {
        TestTable user = testTableMapper.selectById(1);
        return user.toString();
    }

    /** 
     * @Description:  不分表 获取所有数据
     * @param:  
     * @return: java.lang.String 
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/getAll")
    public String testAll() {
        List<TestTable> user = testTableMapper.selectAll();
        return user.toString();
    }

    /** 
     * @Description:  不分表 插入数据
     * @param:  
     * @return: int 
     * @Author: chenping
     * @Date: 2020/7/4
     */
    @RequestMapping("/testInsert")
    public int testInsert() {
        TestTable user = new TestTable();
        user.setUsername("aaa1");
        user.setPassword("bbb1");
        int result = testTableMapper.inserts(user);

        return result;
    }
}

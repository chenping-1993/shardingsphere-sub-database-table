package com.cp.shardingspheresubdatabasetable.mapper;

import com.cp.shardingspheresubdatabasetable.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @description
 * @author: chenping
 * @create: 2019-12-03
 **/
public interface UserMapper {
    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int inserts(User record);

    /**
     * 获取用户
     */
    User selectById(@Param(value = "id") Long id);

}

package com.cp.shardingspheresubdatabasetable.mapper;

import com.cp.shardingspheresubdatabasetable.entity.TestTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-07-04
 */
public interface TestTableMapper {

    /**
     * 插入一条记录
     *
     * @param record 实体对象
     * @return 更新条目数
     */
    int inserts(TestTable record);

    /**
     * 获取test信息
     */
    TestTable selectById(@Param(value = "id") Integer id);

    List<TestTable> selectAll();
}

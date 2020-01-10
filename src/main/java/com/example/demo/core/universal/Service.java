package com.example.demo.core.universal;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface Service<T> {
    Integer insert(T model);

    Integer deleteById(String id);

    Integer deleteByIds(String id);

    Integer update(T model);

    T selectById(String id);

    T selectBy(String fieldName, Object value) throws TooManyResultsException;

    List<T> selectListBy(String fieldName, Object value);

    List<T> selectListByIds(String ids);

    List<T> selectByCondition(Condition condition);

    List<T> selectAll();

    List<T> select(T record);

    T selectOne(T record);
}

package com.random.generate_random.dao;

import com.random.generate_random.entity.ChangeCode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ChangeCodeMapper {
    int deleteByPrimaryKey(String changeCodeId);

    int insert(ChangeCode record);

    int insertSelective(ChangeCode record);

    ChangeCode selectByPrimaryKey(String changeCodeId);

    int updateByPrimaryKeySelective(ChangeCode record);

    int updateByPrimaryKey(ChangeCode record);

    List<String> selectByCode();

    int insertBatchCode(Map<String,Object> param);
}
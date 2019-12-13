package com.random.generate_random.dao;

import com.random.generate_random.entity.CardCode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CardCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CardCode record);

    int insertSelective(CardCode record);

    CardCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardCode record);

    int updateByPrimaryKey(CardCode record);

    /**
     * 查询所有的码
     * @return
     */
    List<String> selectByCode();

    int insertBatchCode(Map<String,Object> param);
}
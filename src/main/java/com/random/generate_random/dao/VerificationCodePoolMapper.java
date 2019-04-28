package com.random.generate_random.dao;

import com.random.generate_random.entity.VerificationCodePool;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VerificationCodePoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VerificationCodePool record);

    int insertSelective(VerificationCodePool record);

    VerificationCodePool selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VerificationCodePool record);

    int updateByPrimaryKey(VerificationCodePool record);

    List<String> selectByCode();

    int insertBatchCode(Map<String,Object> param);
}
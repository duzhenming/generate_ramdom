package com.random.generate_random.dao;

import com.random.generate_random.entity.MaCouponCode;
import com.random.generate_random.entity.MaCouponCode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CouponCodeMapper {

    int insert(MaCouponCode record);

    List<String> selectAllCode();

//    MaCouponCode selectByPrimaryKey(String MaCouponCodeId);

//    int updateByPrimaryKeySelective(MaCouponCode record);

//    int updateByPrimaryKey(MaCouponCode record);

//    List<String> selectByCode();

    int insertBatchCode(Map<String, Object> param);
}
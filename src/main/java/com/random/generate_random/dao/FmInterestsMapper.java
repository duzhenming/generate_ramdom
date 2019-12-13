package com.random.generate_random.dao;

import com.random.generate_random.entity.FmInterests;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FmInterestsMapper {

	FmInterests queryFmInterestsInfoByCode(@Param("code") String code);

	List<String> selectAllCode();


	void insertBatchCode(Map<String,Object> param);
}

package com.random.generate_random.service;

import java.util.List;

public interface IGenerateService {

    List<String> readExcelInsertTable(String filePath, Integer excelNum);

    /**
     * @param totalNum
     * @param num
     * @param couponId 业务id
     * @return
     */
    List<String> generateRandomCode(Integer totalNum, Integer num, String couponId);

    /**
     * 生产去权益激活码
     * @param totalNum
     * @param num
     * @param channelId
     * @param interestsId
     * @return
     */
    List<String> generateInterestsCode(Integer totalNum, Integer num, String channelId, String interestsId);
}

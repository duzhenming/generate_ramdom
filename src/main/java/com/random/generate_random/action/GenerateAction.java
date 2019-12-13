package com.random.generate_random.action;

import com.random.generate_random.service.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("generate")
@RestController
public class GenerateAction {

    @Autowired
    private IGenerateService generateRandomCode;

    @GetMapping("/generateRandomCode")
    public List<String> generateRandomCode(Integer totalNum, Integer num, String couponId) {
        return generateRandomCode.generateRandomCode(totalNum, num, couponId);
    }

    @GetMapping("/readExcelInsertTable")
    public List<String> readExcelInsertTable(String filePath, Integer excelNum, String couponId) {
        return generateRandomCode.readExcelInsertTable(filePath, excelNum);
    }


    /**
     * 生产成权益渠道码
     * @param totalNum 码总数
     * @param num = pageSize 每页数量能和码总数整除
     * @param channelId
     * @param interestsId
     * @return
     */
    @GetMapping("/generateInterestsCode")
    public List<String> generateInterestsCode(Integer totalNum, Integer num, String channelId, String interestsId) {
        return generateRandomCode.generateInterestsCode(totalNum, num, channelId, interestsId);
    }
}

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
    public List<String> generateRandomCode(Integer totalNum, Integer num){
        return generateRandomCode.generateRandomCode(totalNum,num);
    }

    @GetMapping("/readExcelInsertTable")
    public List<String> readExcelInsertTable(String filePath, Integer excelNum){
        return generateRandomCode.readExcelInsertTable(filePath, excelNum);
    }
}

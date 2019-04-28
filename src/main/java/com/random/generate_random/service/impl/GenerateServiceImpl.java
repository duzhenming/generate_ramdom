package com.random.generate_random.service.impl;

import com.random.generate_random.dao.ChangeCodeMapper;
import com.random.generate_random.dao.VerificationCodePoolMapper;
import com.random.generate_random.service.IGenerateService;
import com.random.generate_random.util.ExcelWrite;
import com.random.generate_random.util.RandomCreateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("GenerateServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class GenerateServiceImpl implements IGenerateService {

    @Autowired
    private VerificationCodePoolMapper verificationCodePoolMapper;
    @Autowired
    private ChangeCodeMapper changeCodeMapper;

    @Override
    public List<String> generateRandomCode(Integer totalNum, Integer num) {
        //返回生成的文件
        List<String> resultList = new ArrayList<>();
        //当前excel名称
        String excelName = "";
        //临时存储随机码的列表
        List<Map> list = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        //随机码校验不重复
        Map<String, Integer> randomMap = new HashMap<>();
        //将库中的核销码放入内存中验重
        List<String> codeList = changeCodeMapper.selectByCode();
        for(String code : codeList){
            randomMap.put(code,0);
        }
        for (int i = 0; i < totalNum; i++) {
            //随机码对象
            Map map = new HashMap<>();
            String randomCode;
            //随机码验重
            while (true) {
                randomCode = RandomCreateCode.randomNumber(7, RandomCreateCode.MODE_CHARACTER);
                if (!randomMap.containsKey(randomCode)) {
                    randomMap.put(randomCode, 0);
                    break;
                }
            }
            map.put("randomCode", randomCode);
            list.add(map);
            codes.add(randomCode);
            if ((i + 1) % num == 0) {
                excelName = "C:/Users/EDZ/Desktop/randomCode/" + ((i + 1) / num) + ".xls";
                String title[] = {"randomCode"};
                try {
                    ExcelWrite.createExcel(excelName, "sheet1", title);
                    ExcelWrite.writeToExcel(excelName, "sheet1", list);
                    //批量存入
                    Map<String,Object> param = new HashMap<>();
                    param.put("codes", codes);
                    changeCodeMapper.insertBatchCode(param);
                    list.clear();
                    codes.clear();
                    resultList.add("生成第" + ((i + 1) / num) + "个表格");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("IO异常");
                }
            }
        }
        return resultList;
    }

    @Override
    public List<String> readExcelInsertTable(String filePath, Integer excelNum) {
        List<String> resultList = new ArrayList<>();
        for(int a = 0;a < excelNum;a++){
            List<String> codes = new ArrayList<>();
            String filePathName = filePath+(a+1)+".xls";
            try {
                String[][] data = ExcelWrite.getData(new File(filePathName), 1);
                for(int i=0;i<data.length;i++){
                    codes.add(data[i][0]);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常");
            }
            Map<String, Object> param = new HashMap<>();
            param.put("codes",codes);
            changeCodeMapper.insertBatchCode(param);
            System.out.println(filePathName);
            resultList.add(filePathName);
        }
        return resultList;
    }
}

package com.random.generate_random.service.impl;

import com.random.generate_random.dao.*;
import com.random.generate_random.service.IGenerateService;
import com.random.generate_random.util.ExcelWrite;
import com.random.generate_random.util.RandomCreateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service("GenerateServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class GenerateServiceImpl implements IGenerateService {

    private static final Logger log = LoggerFactory.getLogger(GenerateServiceImpl.class);

    @Autowired
    private VerificationCodePoolMapper verificationCodePoolMapper;
    @Autowired
    private ChangeCodeMapper changeCodeMapper;
    @Autowired
    private CardCodeMapper cardCodeMapper;
    @Autowired
    private CouponCodeMapper couponCodeMapper;

    @Autowired
    private FmInterestsMapper interestsMapper;


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

    @Override
    public List<String> generateRandomCode(Integer totalNum, Integer num, String couponId) {
        //开始时间
        StopWatch sw = new StopWatch("生成码耗时！");
        sw.start("step 1 读取数据中所有的码");
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
        List<String> codeList = interestsMapper.selectAllCode();
        sw.stop();
        sw.start("step 2 开始本次生成码");
        for(String code : codeList){
            randomMap.put(code,0);
        }
        for (int i = 0; i < totalNum; i++) {
            //随机码对象
            Map map = new HashMap<>();
            String randomCode;
            //随机码验重
            while (true) {
                randomCode = RandomCreateCode.randomNumber(8, RandomCreateCode.MODE_NUM_BIG_CHAR);
                if (!randomMap.containsKey(randomCode)) {
                    randomMap.put(randomCode, 0);
                    break;
                }
            }
            map.put("randomCode", randomCode);
            list.add(map);
            codes.add(randomCode);
            if ((i + 1) % num == 0) {
                excelName = "E:\\ideagit\\" + ((i + 1) / num) + ".xls";
                File file=new File(excelName);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String title[] = {"randomCode"};
                try {
                    ExcelWrite.createExcel(excelName, "sheet1", title);
                    ExcelWrite.writeToExcel(excelName, "sheet1", list);
                    Map<String, Object> param = new HashMap<>(16);
                    param.put("couponId", couponId);
//                    param.put("cardid", 3);
                    param.put("codes", codes);
                    /*param.put("status", 9);
                    param.put("createtime", "1563414195");*/
                    couponCodeMapper.insertBatchCode(param);
                    list.clear();
                    codes.clear();
                    resultList.add("生成第" + ((i + 1) / num) + "个表格");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("IO异常");
                }
            }
        }
        //总共花费时间
        sw.stop();
        log.info(sw.prettyPrint());
        return resultList;
    }

    @Override
    public List<String> generateInterestsCode(Integer totalNum, Integer num, String channelId, String interestsId) {
        //开始时间
        StopWatch sw = new StopWatch("生成码耗时！");
        sw.start("step 1 读取数据中所有的码");
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
        List<String> codeList = interestsMapper.selectAllCode();
        sw.stop();
        sw.start("step 2 开始本次生成码");
        for(String code : codeList){
            randomMap.put(code,0);
        }
        for (int i = 0; i < totalNum; i++) {
            //随机码对象
            Map map = new HashMap<>();
            String randomCode;
            //随机码验重
            while (true) {
                randomCode = RandomCreateCode.randomNumber(8, RandomCreateCode.MODE_NUM_BIG_CHAR);
                if (!randomMap.containsKey(randomCode)) {
                    randomMap.put(randomCode, 0);
                    break;
                }
            }
            map.put("randomCode", randomCode);
            list.add(map);
            codes.add(randomCode);
            if ((i + 1) % num == 0) {
                excelName = "E:\\ideagit\\" + ((i + 1) / num) + ".xls";
                File file=new File(excelName);
                if(!file.exists())
                {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String title[] = {"randomCode"};
                try {
                    ExcelWrite.createExcel(excelName, "sheet1", title);
                    ExcelWrite.writeToExcel(excelName, "sheet1", list);
                    Map<String, Object> param = new HashMap<>(16);
                    param.put("channelId", channelId);
                    param.put("interestsId", interestsId);
                    param.put("codes", codes);
                    param.put("createTime", new Date());
                    interestsMapper.insertBatchCode(param);
                    list.clear();
                    codes.clear();
                    resultList.add("生成第" + ((i + 1) / num) + "个表格");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("IO异常");
                }
            }
        }
        //总共花费时间
        sw.stop();
        log.info(sw.prettyPrint());
        return resultList;
    }

}

package com.random.generate_random.service;

import java.util.List;

public interface IGenerateService {
    List<String> generateRandomCode(Integer totalNum, Integer num);

    List<String> readExcelInsertTable(String filePath, Integer excelNum);
}

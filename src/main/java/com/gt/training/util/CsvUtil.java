/*
package com.gt.training.util;

import com.hkm.ticket.core.exception.EntityNotFoundException;
import com.opencsv.bean.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

*/
/**
 * @Program: eiga-ticket-backend
 * @ClassName CsvUtil
 * @Description CSV文件封装成pojo
 * @Author ben
 * @Date 2:23 PM 2019/9/3
 **//*

public class CsvUtil implements CsvToBeanFilter{

    */
/**
     * 解析csv文件并转成bean
     * @param <T> 泛型
     * @param file csv文件
     * @param clazz 类
     * @return 泛型bean集合
     *//*

    public <T> List<T> getCsvDataByName(MultipartFile file, Class<T> clazz) {
        InputStreamReader in ;
        try {
            in = new InputStreamReader(file.getInputStream(), "utf-8");
        } catch (Exception e) {
            throw new EntityNotFoundException("File format error");
        }

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }

    */
/**
     * 通过行位置（index）的内容，解析csv文件并转成bean
     * @param <T> 泛型
     * @param file csv文件
     * @param clazz 类
     * @Author ben
     * @return 泛型bean集合
     *//*

    public <T> List<T> getCsvDataByPosition(MultipartFile file, Class<T> clazz) {
        InputStreamReader in ;
        try {
            in = new InputStreamReader(file.getInputStream(), "utf-8");
        } catch (Exception e) {
            throw new EntityNotFoundException("File format error");
        }

        ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withFilter(new CsvUtil())
                .withMappingStrategy(strategy)
                .build();
        return csvToBean.parse();
    }

    */
/**
     * 过滤通过列位置（index）映射的内容的第一行内容。
     * @param line
     * @Author ben
     * @return boolean
     *//*

    @Override
    public boolean allowLine(String[] line) {
        //过滤第一列值等于"名前"的行，0表示第一行。
        if("名前".equals(line[0])){
            return false;
        }
        return true;
    }
}


*/

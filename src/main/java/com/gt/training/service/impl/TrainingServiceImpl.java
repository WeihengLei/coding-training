package com.gt.training.service.impl;

import com.gt.training.dao.TrainingDao;
import com.gt.training.entity.Training;
import com.gt.training.error.ErrorCode;
import com.gt.training.exception.BaseException;
import com.gt.training.model.request.RoundOneReq;
import com.gt.training.config.Config;
import com.gt.training.model.response.RoundOneResp;
import com.gt.training.model.response.RoundOneResponse;
import com.gt.training.service.TrainingService;
import com.gt.training.util.CreateTxtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by WeiHang on 2020/02/22.
 */
@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrainingServiceImpl.class);

    @Autowired
    private TrainingDao trainingDao;
    @Autowired
    private Config config;


    @Override
    public RoundOneResponse roundOne(RoundOneReq roundOneReq)  throws Exception{

        int num1 = roundOneReq.getSpecialNumberFirst();
        int num2 = roundOneReq.getSpecialNumberSecond();
        int num3 = roundOneReq.getSpecialNumberThird();
        int num = roundOneReq.getNumber();

        checkRoundOneRequest(num1,num2,num3,num);

        String title= "round_one_"+num1+"_"+num2+"_"+num3+"_"+num;
        StringBuffer content = new StringBuffer();
        for (int i = 1; i <= num; i++) {
            String name = getName(num1,num2,num3,i);
            content.append("\n"+name);
        }
        // create txt file
        String filePath = CreateTxtUtil.writeTXT(config.getPath(),title,content.toString());
        //response
        RoundOneResp roundOneResp = new RoundOneResp();
        roundOneResp.setFilePath(filePath);
        RoundOneResponse response = new RoundOneResponse();
        response.setRespCode("200");
        response.setResponseBody(roundOneResp);
        return response;
    }

    @Override
    public Training create(String name) throws Exception {

        Training training = new Training();
        training.setName(name);

        trainingDao.save(training);
        LOGGER.info("save====="+training);

        return training;
    }

    @Override
    public Training update(Training training) throws Exception {

        training.setName("updateName");
        trainingDao.update(training);

        LOGGER.info("update====="+training);
        return training;
    }


    /**
     * check: 1.number cannot be zero
     *        2.special number must be a single digit
     */
    private void checkRoundOneRequest(int num1, int num2, int num3, int num) throws BaseException {

        int one = num1 / 10;
        int two = num2 / 10;
        int three = num3 / 10;

        if(num1 == 0 || num2 == 0 || num3 == 0 || num == 0){
            throw new BaseException(ErrorCode.ZERO,"number cannot be zero");
        }
        if(one > 0 || two > 0 || three > 0){
            throw new BaseException(ErrorCode.NOT_SINGLE_DIGITS,"special number must be a single digit");
        }
    }

    /**
     * get name
     */
    public String getName(int num1, int num2, int num3, int i) throws BaseException {

        String name;
        //rule 1. check if num contains the first special number
        boolean hasSpecialNumberFirst = checkContains(num1, i);

        //rule 2. check if num is a multiple of a special number
        if(hasSpecialNumberFirst){
            name = config.getFizz();
        }else{
            name = checkMultiple(i, num1, config.getFizz()) + checkMultiple(i, num2, config.getBuzz()) + checkMultiple(i, num3, config.getWhizz());
        }
        //rule 3. not the rule 1 and rule 2
        if(name.isEmpty()){
            name = String.valueOf(i);
        }
        return name;
    }

    /**
     * rule 1: check if num contains the first special number
     */
    private boolean checkContains(int num1, int num) throws BaseException {

        //boolean result = (num + "").contains(num1+"");
        boolean result = (num + "").indexOf(num1) != -1; //Is equal to -1 means there is no num1 in this string

        return result;
    }

    /**
     * rule 2: check if num is a multiple of a special number
     */
    private String checkMultiple(int x, int y, String name) throws BaseException  {

        if (x % y == 0){
            return  name;
        }else{
            return "";
        }
    }


}
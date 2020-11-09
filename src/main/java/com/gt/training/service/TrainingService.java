package com.gt.training.service;

import com.gt.training.entity.Training;
import com.gt.training.model.request.RoundOneReq;
import com.gt.training.model.response.RoundOneResponse;
import org.springframework.stereotype.Repository;


/**
 * Created by WeiHang on 2020/02/22.
 */
@Repository
public interface TrainingService {

    RoundOneResponse roundOne(RoundOneReq roundOneReq)  throws Exception;

    Training create(String name)  throws Exception;

    Training update(Training training)  throws Exception;

}
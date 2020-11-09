package com.gt.training.controller;

import com.gt.training.dao.TrainingDao;
import com.gt.training.exception.BaseException;
import com.gt.training.model.BaseResponse;
import com.gt.training.model.request.RoundOneReq;
import com.gt.training.model.response.RoundOneResponse;
import com.gt.training.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import reactor.core.publisher.Mono;


/**
 * Created by WeiHang on 2020/02/22.
 */
@RestController

public class RoundOneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoundOneController.class);

    @Autowired
    private TrainingService trainingService;


    @Autowired
    private TrainingDao trainingDao;

    /**
     * round 1
     * @param roundOneReq    :has three special number and people number
     * @return  RoundOneResponse: file path
     * @throws BaseException
     */

    @CrossOrigin(origins ="*",maxAge = 3600,allowCredentials= "true")
    @RequestMapping(method = RequestMethod.POST,value = "/roundOne")
    //@PostMapping("/roundOne")
    public BaseResponse roundOne(@Valid @RequestBody RoundOneReq roundOneReq, HttpServletRequest request) throws Exception {
        final String method = "RoundOneController.roundOne";

        System.out.println("1===="+request.getHeader("Authorization"));

        RoundOneController.LOGGER.debug("{} enter", method);
        RoundOneController.LOGGER.debug("{} request is {}", method, roundOneReq);

        RoundOneResponse response = trainingService.roundOne(roundOneReq);

        RoundOneController.LOGGER.debug("{}, response is {}", method, response.toString());
        RoundOneController.LOGGER.debug("{} exit", method);

        return response;
    }

    @GetMapping("/create")
    public Boolean create(@RequestParam String name, HttpServletRequest request) throws Exception {


        trainingService.create(name);

        return true;
    }
//
//    public Mono<BaseResponse> baseUpdate (@RequestParam String name) {
//
//
//        return trainingService.createMono(name);
//    }
//


}

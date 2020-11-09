package com.gt.training.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by WeiHang on 2020/02/22.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "training")
public class Config {

    private String fizz;
    private String buzz;
    private String whizz;

    private String path;

}


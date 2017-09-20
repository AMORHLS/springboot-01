package com.hls.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

@ConfigurationProperties(prefix = "road",locations = "classpath:config/road.yml")
public class RoadConfig {
    //日志输出信息
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String age;

    @PostConstruct
    public  void init(){
       logger.info("方式三："+this.name);
       logger.info("方式三："+this.age);
    }
}

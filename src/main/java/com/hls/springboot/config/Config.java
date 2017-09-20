package com.hls.springboot.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * 获取application.yml中的信息
 */
@Configuration
public class Config implements EnvironmentAware{
    //日志输出信息
    private Logger logger = LoggerFactory.getLogger(getClass());
    //方式一：使用注解的方式取值
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @PostConstruct
    public void init(){
        logger.info("方法一：applicationName"+this.applicationName);
        logger.info("方法一：port"+this.port);
    }

    /**
     * 方式二：实现EnvironmentAware重写setEnvironment
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        logger.info("方法二：applicationName"+environment.getProperty("spring.application.name"));
        logger.info("方法二：port"+environment.getProperty("server.port"));
    }
}

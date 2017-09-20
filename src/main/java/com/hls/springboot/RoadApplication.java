package com.hls.springboot;

import com.hls.springboot.banner.RoadBanner;
import com.hls.springboot.config.RoadConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 加载springboot
 */
@SpringBootApplication
@EnableConfigurationProperties({RoadConfig.class})
@ServletComponentScan
@MapperScan(basePackages = "com.hls.springboot.security.dao")
public class RoadApplication {
    /**
     * 在main方法中使用静态方法加载
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RoadApplication.class,args);
        /**
         * 对象的方式
       /*  *//*
        SpringApplication springApplication = new SpringApplication(RoadApplication.class);
        springApplication.setBanner(new RoadBanner());//设置banner
        springApplication.run(args);//启动*/
    }
}

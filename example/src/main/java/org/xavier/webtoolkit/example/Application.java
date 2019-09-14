package org.xavier.webtoolkit.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xavier.common.logging.core.HyggeLogger;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2019/9/14
 * @since Jdk 1.8
 */
@SpringBootApplication
@RestController
public class Application {
    @Autowired
    HyggeLogger logger;

    @GetMapping("/")
    public String test() {
        logger.always("always 测试请求" + System.currentTimeMillis());
        logger.info("info 测试请求" + System.currentTimeMillis());
        logger.warn("warn 测试请求" + System.currentTimeMillis());
        logger.error("error 测试请求" + System.currentTimeMillis());
        return "success " + System.currentTimeMillis();
    }


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}
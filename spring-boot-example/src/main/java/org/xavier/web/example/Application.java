package org.xavier.web.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xavier.common.logging.HyggeLogger;

/**
 * 描述信息：<br/>
 *
 * @author Xavier
 * @version 1.0
 * @date 2018.12.18
 * @since Jdk 1.8
 */
@SpringBootApplication
@RestController
public class Application {
    @Autowired
    HyggeLogger logger;

    @GetMapping("/")
    public String abc() {
        logger.info("asd搞事情");
        logger.warn("asd搞事情2");
        logger.error("asd搞事情3");
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            logger.error("搞出事情了", e);
        }

        return "abc";
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }
}

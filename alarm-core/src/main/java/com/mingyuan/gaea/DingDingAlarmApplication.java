package com.mingyuan.gaea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author limingyuan
 */
@SpringBootApplication
@EnableScheduling
public class DingDingAlarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingDingAlarmApplication.class, args);
    }
}

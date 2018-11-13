package com.mingyuan.gaea.config;

import com.mingyuan.gaea.feign.DingDingRobotFeign;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author limingyuan
 */
@Component
public class FeignConfiguration {

    @Bean
    public DingDingRobotFeign dingDingRobotFeign() {
        return Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .target(DingDingRobotFeign.class, "https://oapi.dingtalk.com/");
    }
}

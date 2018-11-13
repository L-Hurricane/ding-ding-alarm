package com.mingyuan.gaea.feign;

import com.mingyuan.gaea.feign.param.AlarmDingDingParam;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author limingyuan
 */
public interface DingDingRobotFeign {

    /**
     * 发送钉钉报警
     *
     * @param accessToken 钉钉机器人Token
     * @param message     报警消息体
     */
    @RequestLine("POST /robot/send?access_token={access_token}")
    @Headers("Content-Type: application/json; charset=utf-8")
    void dingDingAlarm(@Param("access_token") String accessToken, AlarmDingDingParam message);
}


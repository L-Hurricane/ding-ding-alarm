package com.mingyuan.gaea.feign.client;

import com.mingyuan.gaea.feign.client.param.AlarmDingDingParam;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author limingyuan
 */
public interface DingDingRobotFeign {

    /**
     * send ding ding alarm
     *
     * @param accessToken ding ding robot Token
     * @param message     alarm message body
     */
    @RequestLine("POST /robot/send?access_token={access_token}")
    @Headers("Content-Type: application/json; charset=utf-8")
    void dingDingAlarm(@Param("access_token") String accessToken, AlarmDingDingParam message);
}


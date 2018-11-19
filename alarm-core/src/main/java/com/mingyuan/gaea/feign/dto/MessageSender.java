package com.mingyuan.gaea.feign.dto;

import com.mingyuan.gaea.feign.client.param.AlarmDingDingParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Ding ding message sender
 *
 * @author limingyuan
 */
@Data
@Accessors(chain = true)
public class MessageSender {

    private String accessToken;

    private AlarmDingDingParam alarmDingDingParam;
}

package com.mingyuan.gaea.feign.client.param;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author limingyuan
 */
@Getter
@Setter
@Accessors(chain = true)
public class AlarmDingDingParam {

    private String msgtype;

    private String text;

    private At at;

    public AlarmDingDingParam() {
        msgtype = "text";
    }
}

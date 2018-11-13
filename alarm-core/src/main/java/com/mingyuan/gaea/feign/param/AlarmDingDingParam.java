package com.mingyuan.gaea.feign.param;

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

    String msgtype;

    String text;

    public AlarmDingDingParam() {
        msgtype = "text";
    }
}

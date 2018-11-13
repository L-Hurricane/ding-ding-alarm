package com.mingyuan.gaea.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 报警主体
 *
 * @author limingyuan
 */
@Data
@Accessors(chain = true)
public class AlarmInfo {

    private String token;

    private String message;

    private String timestamp;
}

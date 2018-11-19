package com.mingyuan.gaea.feign.client.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author limingyuan
 */
@Data
@Accessors(chain = true)
public class At {

    private List<String> atMobiles;

    private boolean isAtAll;
}

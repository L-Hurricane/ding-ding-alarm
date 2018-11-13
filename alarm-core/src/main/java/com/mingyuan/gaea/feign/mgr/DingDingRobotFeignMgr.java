package com.mingyuan.gaea.feign.mgr;

import com.mingyuan.gaea.feign.dto.MessageSender;

/**
 * Ding ding robot alarm mgr
 *
 * @author limingyuan
 */
public interface DingDingRobotFeignMgr {

    /**
     * Send ding ding message
     *
     * @param messageSender ding ding robot token and ding ding robot feign param
     */
    void sendMessage(MessageSender messageSender);
}

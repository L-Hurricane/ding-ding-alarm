package com.mingyuan.gaea.feign.mgr.impl;

import com.mingyuan.gaea.feign.client.DingDingRobotFeign;
import com.mingyuan.gaea.feign.dto.MessageSender;
import com.mingyuan.gaea.feign.mgr.DingDingRobotFeignMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of ding ding robot alarm mgr
 *
 * @author limingyuan
 */
@Service
public class DingDingRobotFeignMgrImpl implements DingDingRobotFeignMgr {

    private final DingDingRobotFeign dingDingRobotFeign;

    @Autowired
    public DingDingRobotFeignMgrImpl(DingDingRobotFeign dingDingRobotFeign) {
        this.dingDingRobotFeign = dingDingRobotFeign;
    }

    @Override
    public void sendMessage(MessageSender messageSender) {
        dingDingRobotFeign.dingDingAlarm(messageSender.getAccessToken(), messageSender.getAlarmDingDingParam());
    }
}

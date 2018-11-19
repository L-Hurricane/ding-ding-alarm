package com.mingyuan.gaea.service.impl;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.feign.client.param.AlarmDingDingParamFactory;
import com.mingyuan.gaea.feign.dto.MessageSender;
import com.mingyuan.gaea.feign.mgr.DingDingRobotFeignMgr;
import com.mingyuan.gaea.redis.mgr.AlarmInfoMgr;
import com.mingyuan.gaea.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author limingyuan
 */
@Service
public class AlarmServiceImpl implements AlarmService {

    private final AlarmInfoMgr alarmInfoMgr;

    private final DingDingRobotFeignMgr dingDingRobotFeignMgr;

    @Autowired
    public AlarmServiceImpl(AlarmInfoMgr alarmInfoMgr, DingDingRobotFeignMgr dingDingRobotFeignMgr) {
        this.alarmInfoMgr = alarmInfoMgr;
        this.dingDingRobotFeignMgr = dingDingRobotFeignMgr;
    }

    @Override
    public void pushAlarmInfo(AlarmInfo alarmInfo) {
        alarmInfoMgr.pushMessage(alarmInfo);
    }

    @Override
    public void alarm(List<AlarmInfo> alarmInfo) {
        Map<String, List<AlarmInfo>> alarmMap = alarmInfo.stream().collect(groupingBy(AlarmInfo::getToken));
        alarmMap.forEach((token, alarmInfoGroup) -> {
            MessageSender messageSender = AlarmDingDingParamFactory.generateMessageSender(token, alarmInfoGroup);
            dingDingRobotFeignMgr.sendMessage(messageSender);
        });
    }

    @Override
    public List<AlarmInfo> getAllAlarm() {
        return alarmInfoMgr.getAllAlarmInfo();
    }
}

package com.mingyuan.gaea.service.impl;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.feign.DingDingRobotFeign;
import com.mingyuan.gaea.feign.param.AlarmDingDingParam;
import com.mingyuan.gaea.redis.mgr.AlarmInfoMgr;
import com.mingyuan.gaea.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author limingyuan
 */
@Service
public class AlarmServiceImpl implements AlarmService {

    private final AlarmInfoMgr alarmInfoMgr;

    private DingDingRobotFeign dingDingRobotFeign;

    @Autowired
    public AlarmServiceImpl(AlarmInfoMgr alarmInfoMgr, DingDingRobotFeign dingDingRobotFeign) {
        this.alarmInfoMgr = alarmInfoMgr;
        this.dingDingRobotFeign = dingDingRobotFeign;
    }

    @Override
    public void pushAlarmInfo(AlarmInfo alarmInfo) {
        alarmInfoMgr.pushMessage(alarmInfo);
    }

    @Override
    public void alarm(List<AlarmInfo> alarmInfo) {
        Map<String, List<AlarmInfo>> alarmMap = alarmInfo.stream().collect(groupingBy(AlarmInfo::getToken));
        alarmMap.forEach(
            (token, alarmInfoGroup) ->
                dingDingRobotFeign.dingDingAlarm(token,
                    new AlarmDingDingParam().setText("{\"content\": \"" + alarmInfoGroup.stream().map(AlarmInfo::getMessage).collect(Collectors.joining("\\n")) + "\"}"))
        );
    }

    @Override
    public List<AlarmInfo> getAllAlarm() {
        return alarmInfoMgr.getAllAlarmInfo();
    }
}

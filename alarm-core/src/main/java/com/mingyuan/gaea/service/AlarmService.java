package com.mingyuan.gaea.service;

import com.mingyuan.gaea.entity.AlarmInfo;

import java.util.List;

/**
 * @author limingyuan
 */
public interface AlarmService {

    void pushAlarmInfo(AlarmInfo alarmInfo);

    void alarm(List<AlarmInfo> alarmInfo);

    List<AlarmInfo> getAllAlarm();
}

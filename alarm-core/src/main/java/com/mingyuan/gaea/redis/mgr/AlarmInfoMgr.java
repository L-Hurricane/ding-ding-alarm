package com.mingyuan.gaea.redis.mgr;

import com.mingyuan.gaea.entity.AlarmInfo;

import java.util.List;

/**
 * @author limingyuan
 */
public interface AlarmInfoMgr {

    List<AlarmInfo> getAllAlarmInfo();

    void pushMessage(AlarmInfo alarmInfo);
}

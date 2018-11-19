package com.mingyuan.gaea.scheduler;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author limingyuan
 */
@Component
public class AlarmTask {

    private final AlarmService alarmService;

    @Autowired
    public AlarmTask(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @Scheduled(fixedRate = 60 * 1000)
    public void reportCurrentTime() {
        List<AlarmInfo> alarmInfoGroup = alarmService.getAllAlarm();
        alarmService.alarm(alarmInfoGroup);
    }
}

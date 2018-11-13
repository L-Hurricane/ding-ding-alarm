package com.mingyuan.gaea.controller;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author limingyuan
 */
@RestController
public class PushAlarmInfoController {

    private AlarmService alarmService;

    @Autowired
    public PushAlarmInfoController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @GetMapping("/push_alarm_info")
    public String pushAlarmInfo(@RequestParam String token,
                                @RequestParam String message,
                                @RequestParam List<String> phones) {
        alarmService.pushAlarmInfo(new AlarmInfo().setToken(token).setMessage(message).setPhones(phones));
        return "mingyuan_test";
    }

    @GetMapping("/alarm")
    public List<AlarmInfo> alarm() {
        List<AlarmInfo> alarmInfoGroup = alarmService.getAllAlarm();
        alarmService.alarm(alarmInfoGroup);
        return alarmInfoGroup;
    }
}

package com.mingyuan.gaea.feign.client.param;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.feign.dto.MessageSender;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * @author limingyuan
 */
public class AlarmDingDingParamFactory {

    private AlarmDingDingParamFactory() {
        throw new Error("AlarmDingDingParamFactory不能被初始化");
    }

    public static MessageSender generateMessageSender(String token, List<AlarmInfo> alarmInfo) {
        AlarmDingDingParam alarmDingDingParam = generateAlarmDingDingParam(alarmInfo);
        return new MessageSender()
            .setAccessToken(token)
            .setAlarmDingDingParam(alarmDingDingParam);
    }

    private static AlarmDingDingParam generateAlarmDingDingParam(List<AlarmInfo> alarmInfo) {
        List<String> phones = alarmInfo.stream()
            .map(AlarmInfo::getPhones)
            .collect(toList())
            .stream()
            .flatMap(Collection::stream)
            .collect(toList());

        At at = new At().setAtMobiles(phones).setAtAll(false);

        String alarmMessage = alarmInfo.stream()
            .map(alarm -> {
                String message = alarm.getMessage();
                String ding = alarm.getPhones().stream().map(phone -> "@" + phone + " ").collect(joining());
                return message + " " + ding;
            })
            .collect(joining("\\n"));
        return new AlarmDingDingParam()
            .setAt(at)
            .setText("{\"content\": \"" + alarmMessage + "\"}");
    }
}

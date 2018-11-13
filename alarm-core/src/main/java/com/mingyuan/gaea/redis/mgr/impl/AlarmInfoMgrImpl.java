package com.mingyuan.gaea.redis.mgr.impl;

import com.mingyuan.gaea.entity.AlarmInfo;
import com.mingyuan.gaea.redis.mgr.AlarmInfoMgr;
import com.mingyuan.gaea.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author limingyuan
 */
@Slf4j
@Service
public class AlarmInfoMgrImpl implements AlarmInfoMgr {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public AlarmInfoMgrImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<AlarmInfo> getAllAlarmInfo() {
        BoundListOperations<String, String> boundListOperations = redisTemplate.boundListOps("alarm");
        List<AlarmInfo> alarmInfoGroup = new ArrayList<>();
        while (true) {
            Object object = boundListOperations.leftPop();
            if (object == null) {
                break;
            }
            String alarmInfoInRedis = String.valueOf(object);
            if (alarmInfoInRedis != null && !"".equals(alarmInfoInRedis)) {
                log.info("Redis中的值为[{}]", alarmInfoInRedis);
                alarmInfoGroup.add(JsonUtil.parse(alarmInfoInRedis, AlarmInfo.class).orElse(new AlarmInfo()));
            }
        }
        return alarmInfoGroup.stream().distinct().collect(toList());
    }

    @Override
    public void pushMessage(AlarmInfo alarmInfo) {
        String alarm = JsonUtil.format(alarmInfo).orElse("");
        BoundListOperations<String, String> boundListOperations = redisTemplate.boundListOps("alarm");
        boundListOperations.rightPush(alarm);
    }
}

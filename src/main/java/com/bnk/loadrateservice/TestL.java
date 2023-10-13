package com.bnk.loadrateservice;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TestL {
//    RedisTemplate<String, Long> redisTemplate;
    ValueOperations<String, String> valueOperations;
//    ListOperations<String,String> listOperations;
    @Scheduled(cron = "*/5 * * * * *")
    public void getInfo() {
        log.info(String.valueOf(valueOperations.get("bike:1")));
//        log.info(String.valueOf(listOperations.));
    }
}

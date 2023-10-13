package com.bnk.loadrateservice.services;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoadRateService {
    ValueOperations<String, Long> valueOperations;
    public static final String keyFormat = "%s:%s:%s";

    //возвращаем оценку от 0 до 10 по свободности
    //чем больше maxCurrentNum выше оценка
    //чем больше total ниже оценка
    public Long getLoadRateByOfficeId(Long id, String faceType) {
        String totalKey = keyFormat.formatted(String.valueOf(id),faceType,"total");
        String maxCurrentNumKey = keyFormat.formatted(String.valueOf(id),faceType,"current");

        Long total = valueOperations.get(totalKey);
        Long maxCurrentNum = valueOperations.get(maxCurrentNumKey);

        return 10-((total-maxCurrentNum)/total)*10;
//        return (1-maxCurrentNum/total);
    }
}

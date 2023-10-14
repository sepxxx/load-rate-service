package com.bnk.loadrateservice.controllers;

import com.bnk.loadrateservice.services.LoadRateService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class LoadRateController {

    LoadRateService loadRateService;

    @GetMapping("/offices/{id}/load/rating/{faceType}")
    public Double getLoadRateByOfficeId(@PathVariable Long id, @PathVariable String faceType) {
        log.info("getLoadRateByOfficeId(), id:{}, faceType:{}",id,faceType);

        return loadRateService.getLoadRateByOfficeId(id,faceType);
    }
}

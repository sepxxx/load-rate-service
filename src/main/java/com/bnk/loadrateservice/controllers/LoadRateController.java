package com.bnk.loadrateservice.controllers;

import com.bnk.loadrateservice.services.LoadRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoadRateController {

    LoadRateService loadRateService;

    @GetMapping("/offices/{id}/load/rating/{faceType}")
    public Long getLoadRateByOfficeId(@PathVariable Long id, @PathVariable String faceType) {
        return loadRateService.getLoadRateByOfficeId(id,faceType);
    }
}

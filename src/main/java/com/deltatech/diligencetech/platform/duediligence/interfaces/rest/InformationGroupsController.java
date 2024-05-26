package com.deltatech.diligencetech.platform.duediligence.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupCommandService;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/information-groups")
public class InformationGroupsController {
    private final InformationGroupQueryService informationGroupQueryService;
    private final InformationGroupCommandService informationGroupCommandService;

    public InformationGroupsController(InformationGroupQueryService informationGroupQueryService, InformationGroupCommandService informationGroupCommandService) {
        this.informationGroupQueryService = informationGroupQueryService;
        this.informationGroupCommandService = informationGroupCommandService;
    }
}

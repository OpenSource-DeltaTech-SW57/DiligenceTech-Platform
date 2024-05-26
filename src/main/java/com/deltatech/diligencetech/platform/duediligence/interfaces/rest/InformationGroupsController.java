package com.deltatech.diligencetech.platform.duediligence.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllInformationGroupsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupCommandService;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupQueryService;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.InformationGroupResource;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.CreateInformationGroupCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.InformationGroupResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/information-groups")
public class InformationGroupsController {
    private final InformationGroupQueryService informationGroupQueryService;
    private final InformationGroupCommandService informationGroupCommandService;

    public InformationGroupsController(InformationGroupQueryService informationGroupQueryService, InformationGroupCommandService informationGroupCommandService) {
        this.informationGroupQueryService = informationGroupQueryService;
        this.informationGroupCommandService = informationGroupCommandService;
    }

    @PostMapping
    public ResponseEntity<InformationGroupResource> createInformationGroup(@RequestBody InformationGroupResource resource) {
        Optional<InformationGroup> informationGroup = informationGroupCommandService.handle(
                CreateInformationGroupCommandFromResourceAssembler.toCommandFromResource(resource));
        return informationGroup.map(source -> new ResponseEntity<>(
                InformationGroupResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<InformationGroupResource>> getAllInformationGroups() {
        var getAllInformationGroupsQuery = new GetAllInformationGroupsQuery();
        var informationGroups = informationGroupQueryService.handle(getAllInformationGroupsQuery);
        var informationGroupResources = informationGroups.stream()
                .map(InformationGroupResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(informationGroupResources);
    }
}

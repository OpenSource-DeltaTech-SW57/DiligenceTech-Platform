package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllAreasQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAreaByIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.AreaResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateAreaResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.UpdateAreaNameResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.AreaResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.CreateAreaCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.UpdateAreaNameCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

  @RestController
  @RequestMapping(value = "/api/v1/areas", produces = APPLICATION_JSON_VALUE)
  @Tag(name = "Areas", description = "Area Management Endpoints")
  public class AreaController
  {
    private final AreaCommandService areaCommandService;
    private final AreaQueryService areaQueryService;

    public AreaController(AreaCommandService areaCommandService, AreaQueryService areaQueryService) {
      this.areaCommandService = areaCommandService;
      this.areaQueryService = areaQueryService;
    }


    /**
     * Creates a new course.
     * @param createAreaResource the resource containing the data for the course to be created
     * @return the created course resource
     * @see CreateAreaResource
     * @see AreaResource
     */
    @PostMapping
    public ResponseEntity<AreaResource> createArea(@RequestBody CreateAreaResource createAreaResource) {
      var createAreaCommand = CreateAreaCommandFromResourceAssembler.toCommandFromResource(createAreaResource);
      var areaId = areaCommandService.handle(createAreaCommand);
      if (areaId == null) {
        return ResponseEntity.badRequest().build();
      }
      var getAreaByIdQuery = new GetAreaByIdQuery(areaId);
      var area = areaQueryService.handle(getAreaByIdQuery);
      if (area.isEmpty()) return ResponseEntity.badRequest().build();
      var areaResource = AreaResourceFromEntityAssembler.toResourceFromEntity(area.get());
      return new ResponseEntity<>(areaResource, HttpStatus.CREATED);
    }

    /**
     * Gets an area by its id.
     *
     * @param areaId the id of the course to be retrieved
     * @return the course resource with the given id
     * @see AreaResource
     */
    @GetMapping("/{areaId}")
    public ResponseEntity<AreaResource> getAreaById(@PathVariable Long areaId) {
      var getAreaByIdQuery = new GetAreaByIdQuery(areaId);
      var area = areaQueryService.handle(getAreaByIdQuery);
      if (area.isEmpty()) return ResponseEntity.badRequest().build();
      var areaResource = AreaResourceFromEntityAssembler.toResourceFromEntity(area.get());
      return ResponseEntity.ok(areaResource);
    }


    /**
     * Gets all the courses.
     *
     * @return the list of all the course resources
     * @see AreaResource
     */
    @GetMapping
    public ResponseEntity<List<AreaResource>> getAllAreas() {
      var getAllAreasQuery = new GetAllAreasQuery();
      var areas = areaQueryService.handle(getAllAreasQuery);
      var areaResource = areas.stream().map(AreaResourceFromEntityAssembler::toResourceFromEntity).toList();
      return ResponseEntity.ok(areaResource);
    }

    /**
     * Updates a course.
     *
     * @param areaId             the id of the course to be updated
     * @param updateAreaResource the resource containing the data for the course to be updated
     * @return the updated course resource
     * @see UpdateAreaNameResource
     * @see AreaResource
     */
    @PutMapping("/{areaId}")
    public ResponseEntity<AreaResource> updateArea(@PathVariable Long areaId, @RequestBody UpdateAreaNameResource updateAreaResource) {
      var updateAreaCommand = UpdateAreaNameCommandFromResourceAssembler.toCommandFromResource(areaId, updateAreaResource.name());
      var updatedArea = areaCommandService.handle(updateAreaCommand);
      if (updatedArea.isEmpty()) {
        return ResponseEntity.badRequest().build();
      }
      var areaResource = AreaResourceFromEntityAssembler.toResourceFromEntity(updatedArea.get());
      return ResponseEntity.ok(areaResource);
    }
  }

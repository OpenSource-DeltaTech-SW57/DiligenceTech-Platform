package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllFoldersQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllFoldersQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetFolderByAreaIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetFolderByIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateFolderResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.FolderResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.UpdateFolderNameResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.CreateFolderCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.FolderResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.UpdateFolderNameCommandFromResourceAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;



  @RestController
  @RequestMapping(value = "/api/v1/folders", produces = APPLICATION_JSON_VALUE)
  @Tag(name = "folders", description = "folder Management Endpoints")
  public class FolderController
  {
    private final FolderCommandService folderCommandService;
    private final FolderQueryService folderQueryService;

    public FolderController(FolderCommandService folderCommandService, FolderQueryService folderQueryService) {
      this.folderCommandService = folderCommandService;
      this.folderQueryService = folderQueryService;
    }


    /**
     * Creates a new course.
     * @param createfolderResource the resource containing the data for the course to be created
     * @return the created course resource
     * @see CreateFolderResource
     * @see FolderResource
     */
    @PostMapping
    public ResponseEntity<FolderResource> createfolder(@RequestBody CreateFolderResource createfolderResource) {
      var createfolderCommand = CreateFolderCommandFromResourceAssembler.toCommandFromResource(createfolderResource);
      var folderId = folderCommandService.handle(createfolderCommand);
      if (folderId == null) {
        return ResponseEntity.badRequest().build();
      }
      var getfolderByIdQuery = new GetFolderByIdQuery(folderId);
      var folder = folderQueryService.handle(getfolderByIdQuery);
      if (folder.isEmpty()) return ResponseEntity.badRequest().build();
      var folderResource = FolderResourceFromEntityAssembler.toResourceFromEntity(folder.get());
      return new ResponseEntity<>(folderResource, HttpStatus.CREATED);
    }

    /**
     * Gets a folder by its id.
     *
     * @param areaId the id of the course to be retrieved
     * @return the course resource with the given id
     * @see FolderResource
     */
    @GetMapping("/{areaId}")
    public ResponseEntity<List<FolderResource>> getfolderByAreaId(@PathVariable Long areaId) {
      var getFolderByAreaIdQuery = new GetFolderByAreaIdQuery(areaId);
      var folders = folderQueryService.handle(getFolderByAreaIdQuery);
      var folderResource = folders.stream().map(FolderResourceFromEntityAssembler::toResourceFromEntity).toList();
      return ResponseEntity.ok(folderResource);
    }


    /**
     * Gets all the courses.
     *
     * @return the list of all the course resources
     * @see FolderResource
     */
    @GetMapping
    public ResponseEntity<List<FolderResource>> getAllfolders() {
      var getAllfoldersQuery = new GetAllFoldersQuery();
      var folders = folderQueryService.handle(getAllfoldersQuery);
      var folderResource = folders.stream().map(FolderResourceFromEntityAssembler::toResourceFromEntity).toList();
      return ResponseEntity.ok(folderResource);
    }

    /**
     * Updates a folder.
     *
     * @param folderId             the id of the course to be updated
     * @param updatefolderResource the resource containing the data for the course to be updated
     * @return the updated course resource
     * @see UpdateFolderNameResource
     * @see FolderResource
     */
    @PutMapping("/{folderId}")
    public ResponseEntity<FolderResource> updatefolder(@PathVariable Long folderId, @RequestBody UpdateFolderNameResource updatefolderResource) {
      var updatefolderCommand = UpdateFolderNameCommandFromResourceAssembler.toCommandFromResource(folderId, updatefolderResource.name());
      var updatedfolder = folderCommandService.handle(updatefolderCommand);
      if (updatedfolder.isEmpty()) {
        return ResponseEntity.badRequest().build();
      }
      var folderResource = FolderResourceFromEntityAssembler.toResourceFromEntity(updatedfolder.get());
      return ResponseEntity.ok(folderResource);
    }
  }


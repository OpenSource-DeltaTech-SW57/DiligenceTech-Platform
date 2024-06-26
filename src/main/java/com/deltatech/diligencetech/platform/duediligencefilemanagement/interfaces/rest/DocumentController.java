package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.DeleteDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetDocumentByIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetDocumentsByFolderIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.DocumentCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.DocumentQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.DocumentResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateDocumentResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.InfoMessageResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.UpdateDocumentNameResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.DocumentResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.CreateDocumentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform.UpdateDocumentNameCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/Documents", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Documents", description = "Document Management Endpoints")
public class DocumentController
{
  private final DocumentCommandService documentCommandService;
  private final DocumentQueryService documentQueryService;

  public DocumentController(DocumentCommandService documentCommandService, DocumentQueryService documentQueryService) {
    this.documentCommandService = documentCommandService;
    this.documentQueryService = documentQueryService;
  }


  /**
   * Creates a new course.
   * @param createDocumentResource the resource containing the data for the course to be created
   * @return the created course resource
   * @see CreateDocumentResource
   * @see DocumentResource
   */
  @PostMapping
  public ResponseEntity<DocumentResource> createDocument(@RequestBody CreateDocumentResource createDocumentResource) {
    var createDocumentCommand = CreateDocumentCommandFromResourceAssembler.toCommandFromResource(createDocumentResource);
    var DocumentId = documentCommandService.handle(createDocumentCommand);
    if (DocumentId == null) {
      return ResponseEntity.badRequest().build();
    }
    var getDocumentByIdQuery = new GetDocumentByIdQuery(DocumentId);
    var Document = documentQueryService.handle(getDocumentByIdQuery);
    if (Document.isEmpty()) return ResponseEntity.badRequest().build();
    var DocumentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(Document.get());
    return new ResponseEntity<>(DocumentResource, HttpStatus.CREATED);
  }

  /**
   * Gets Document by its id.
   *
   * @param documentId the id of the course to be retrieved
   * @return the course resource with the given id
   * @see DocumentResource
   */
  @GetMapping("/{folderId}")
  public ResponseEntity<List<DocumentResource>> getDocumentByFolderId(@PathVariable Long folderId) {
    var getDocumentsByFolderIdQuery = new GetDocumentsByFolderIdQuery(folderId);
    var Documents = documentQueryService.handle(getDocumentsByFolderIdQuery);
    if (Documents.isEmpty()) return ResponseEntity.badRequest().build();
    var DocumentResource = Documents.stream().map(DocumentResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(DocumentResource);
  }


  /**
   * Gets all the courses.
   *
   * @return the list of all the course resources
   * @see DocumentResource
   */
  @GetMapping
  public ResponseEntity<List<DocumentResource>> getAllDocuments() {
    var getAllDocumentsQuery = new GetAllDocumentsQuery();
    var Documents = documentQueryService.handle(getAllDocumentsQuery);
    var DocumentResource = Documents.stream().map(DocumentResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(DocumentResource);
  }

  /**
   * Updates a document.
   *
   * @param DocumentId             the id of the course to be updated
   * @param updateDocumentResource the resource containing the data for the course to be updated
   * @return the updated course resource
   * @see UpdateDocumentNameResource
   * @see DocumentResource
   */
  @PutMapping("/{DocumentId}")
  public ResponseEntity<DocumentResource> updateDocument(@PathVariable Long DocumentId, @RequestBody UpdateDocumentNameResource updateDocumentResource) {
    var updateDocumentCommand = UpdateDocumentNameCommandFromResourceAssembler.toCommandFromResource(DocumentId, updateDocumentResource.filename());
    var updatedDocument = documentCommandService.handle(updateDocumentCommand);
    if (updatedDocument.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var DocumentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(updatedDocument.get());
    return ResponseEntity.ok(DocumentResource);
  }
  /**
   * Deletes a document.
   */
    @DeleteMapping("/{DocumentId}")
    public ResponseEntity<InfoMessageResource> deleteDocument(@PathVariable Long DocumentId) {
        var deleteDocumentCommand = new DeleteDocumentCommand(DocumentId);
        documentCommandService.handle(deleteDocumentCommand);
        var infoMessageResource = new InfoMessageResource("Document with given id successfully deleted");
        return ResponseEntity.ok(infoMessageResource);
    }
}
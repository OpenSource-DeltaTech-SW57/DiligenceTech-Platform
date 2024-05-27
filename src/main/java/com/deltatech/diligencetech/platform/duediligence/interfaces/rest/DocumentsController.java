package com.deltatech.diligencetech.platform.duediligence.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllInformationGroupsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetDocumentByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentCommandService;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentQueryService;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.DocumentResource;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.InformationGroupResource;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.CreateDocumentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.DocumentResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.InformationGroupResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentsController {
    private final DocumentQueryService documentQueryService;
    private final DocumentCommandService documentCommandService;

    public DocumentsController(DocumentQueryService documentQueryService, DocumentCommandService documentCommandService) {
        this.documentQueryService = documentQueryService;
        this.documentCommandService = documentCommandService;
    }

    @PostMapping
    public ResponseEntity<DocumentResource> createDocument(@RequestBody DocumentResource resource) {
        Optional<Document> document = documentCommandService.handle(
                CreateDocumentCommandFromResourceAssembler.toCommandFromResource(resource));
        return document.map(source -> new ResponseEntity<>(
                        DocumentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResource> getDocumentById(@PathVariable Long id) {
        var getDocumentByIdQuery = new GetDocumentByIdQuery(id);
        var document = documentQueryService.handle(getDocumentByIdQuery);
        if (document.isEmpty()) return ResponseEntity.notFound().build();
        var documentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(document.get());
        return ResponseEntity.ok(documentResource);
    }

    @GetMapping
    public ResponseEntity<List<DocumentResource>> getAllDocuments() {
        var getAllDocumentsQuery = new GetAllDocumentsQuery();
        var documents = documentQueryService.handle(getAllDocumentsQuery);
        var documentResources = documents.stream()
                .map(DocumentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(documentResources);
    }
}

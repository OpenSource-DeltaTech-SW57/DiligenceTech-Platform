package com.deltatech.diligencetech.platform.duediligence.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.entities.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetDocumentByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupCommandService;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupQueryService;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.DocumentResource;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.CreateDocumentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform.DocumentResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/documents")
public class DocumentsController {
    private final InformationGroupQueryService informationGroupQueryService;
    private final InformationGroupCommandService informationGroupCommandService;


    public DocumentsController(InformationGroupQueryService informationGroupQueryService, InformationGroupCommandService informationGroupCommandService) {
        this.informationGroupQueryService = informationGroupQueryService;
        this.informationGroupCommandService = informationGroupCommandService;
    }
    /*
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
    */
}

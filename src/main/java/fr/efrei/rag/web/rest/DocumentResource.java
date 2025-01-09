package fr.efrei.rag.web.rest;

import fr.efrei.rag.domain.Document;
import fr.efrei.rag.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class DocumentResource {
    private final Logger log = LoggerFactory.getLogger(DocumentResource.class);
    private final DocumentService documentService;
    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        log.debug("REST request to save Document : {}", document);
        Document result = documentService.buildAndSaveDocument(document);
        return ResponseEntity
                .created(URI.create("/documents/" + result.getId()))
                .body(result);
    }

}

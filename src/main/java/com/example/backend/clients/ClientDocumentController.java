package com.example.backend.clients;


import com.example.backend.clients.entity.ClientDocument;
import com.example.backend.clients.services.ClientDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/documents")
public class ClientDocumentController {

    @Autowired
    private ClientDocumentService clientDocumentService;

    @PostMapping("/upload-url/{clientId}")
    public ResponseEntity<ClientDocument> saveFileUrl(
            @PathVariable Long clientId,
            @RequestBody Map<String, String> payload) {

        System.out.println("Received Payload: " + payload);
        String fileUrl = payload.get("fileUrl");
        String fileName = payload.get("fileName");
        Long clientId2 = Long.valueOf(payload.get("clientId"));
        //String uploadedBy = payload.get("uploadedBy");
        ClientDocument document = clientDocumentService.saveFileUrl(clientId2, fileUrl, fileName);
        return ResponseEntity.status(HttpStatus.OK).body(document);
    }


    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ClientDocument>> getAllFilesByClientId(@PathVariable Long clientId) {
        List<ClientDocument> documents = clientDocumentService.getAllFilesByClientId(clientId);
        return ResponseEntity.status(HttpStatus.OK).body(documents);
    }


    // Other existing methods...
}


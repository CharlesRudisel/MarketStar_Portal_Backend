package com.example.backend.clients.services;


import com.example.backend.clients.entity.ClientDocument;
import com.example.backend.clients.repository.ClientDocumentRepository;
import com.example.backend.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ClientDocumentService {

    @Autowired
    private ClientDocumentRepository clientDocumentRepository;

    @Autowired
    private ClientRepository clientRepository;

    public ClientDocument saveFileUrl(Long clientId, String fileUrl, String fileName) {
        ClientDocument document = new ClientDocument();
        document.setClientId(clientId);
        document.setFileUrl(fileUrl);
        document.setDocumentContent(fileUrl.getBytes());
        document.setDocumentType(fileUrl);
        document.setDocumentName(fileName);
        document.setUploadedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        return clientDocumentRepository.save(document);
    }

    public List<ClientDocument> getAllFilesByClientId(Long clientId) {
        return clientDocumentRepository.findByClientId(clientId);
    }


    // Other existing methods...
}

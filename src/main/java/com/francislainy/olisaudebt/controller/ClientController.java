package com.francislainy.olisaudebt.controller;

import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.service.ClientService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/client")
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<AppClient> createClient(@RequestBody AppClient appClient) {
        return new ResponseEntity<>(clientService.createClient(appClient), HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<AppClient> retrieveClient(@PathParam("clientId") UUID clientId) {
        return new ResponseEntity<>(clientService.retrieveClient(clientId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppClient>> retrieveAllClients() {
        return new ResponseEntity<>(clientService.retrieveAllClients(), HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<AppClient> updateClient(@PathParam("clientId") UUID clientId, @RequestBody AppClient appClient) {
        return new ResponseEntity<>(clientService.updateClient(clientId, appClient), HttpStatus.OK);
    }
}

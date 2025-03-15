package com.francislainy.olisaudebt.controller;

import com.francislainy.olisaudebt.model.AppClient;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/client")
@RestController
public class ClientController {

    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody AppClient appClient) {
        return new ResponseEntity<>(appClient, HttpStatus.CREATED);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Object> retrieveClient(@PathParam("clientId") UUID clientId) {
        return new ResponseEntity<>(clientId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> retrieveAllClients() {
        return new ResponseEntity<>("All clients", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> editClient(@RequestBody AppClient appClient) {
        return new ResponseEntity<>(appClient, HttpStatus.OK);
    }
}

package com.francislainy.olisaudebt.service.impl;

import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public AppClient createClient(AppClient appClient) {

        return appClient;

    }

    @Override
    public AppClient retrieveClient(UUID clientId) {
        return null;
    }

    @Override
    public List<AppClient> retrieveAllClients() {
        return List.of();
    }

    @Override
    public AppClient updateClient(UUID clientId, AppClient appClient) {
        return null;
    }
}

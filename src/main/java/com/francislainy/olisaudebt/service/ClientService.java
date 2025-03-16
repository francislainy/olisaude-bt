package com.francislainy.olisaudebt.service;

import com.francislainy.olisaudebt.model.AppClient;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    AppClient createClient(AppClient appClient);

    AppClient retrieveClient(UUID clientId);

    List<AppClient> retrieveAllClients();

    AppClient updateClient(UUID clientId, AppClient appClient);
}

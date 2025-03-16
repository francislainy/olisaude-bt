package com.francislainy.olisaudebt.service.impl;

import com.francislainy.olisaudebt.entity.AppClientEntity;
import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.repository.ClientRepository;
import com.francislainy.olisaudebt.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public AppClient createClient(AppClient appClient) {
        AppClientEntity appClientEntity = clientRepository.save(appClient.toEntity());
        return appClientEntity.toModel();
    }

    @Override
    public AppClient retrieveClient(UUID clientId) {
        return clientRepository.findById(clientId)
                .map(AppClientEntity::toModel)
                .orElse(null); // test negative and throw exception when not found
    }

    @Override
    public List<AppClient> retrieveAllClients() {
        return clientRepository.findAll().stream().map(AppClientEntity::toModel).toList();
    }

    @Override
    public AppClient updateClient(UUID clientId, AppClient appClient) {
        AppClientEntity appClientEntity = appClient.toEntity().withId(clientId);
        return clientRepository.save(appClientEntity).toModel();
    }
}

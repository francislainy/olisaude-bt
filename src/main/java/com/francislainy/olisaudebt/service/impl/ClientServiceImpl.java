package com.francislainy.olisaudebt.service.impl;

import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.model.HealthIssue;
import com.francislainy.olisaudebt.service.ClientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.francislainy.olisaudebt.enums.Gender.FEMALE;
import static java.util.UUID.randomUUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public AppClient createClient(AppClient appClient) {
        return appClient;
    }

    @Override
    public AppClient retrieveClient(UUID clientId) {
        return AppClient.builder()
                .id(clientId)
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }

    @Override
    public List<AppClient> retrieveAllClients() {
        UUID clientId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        AppClient appClient = AppClient.builder()
                .id(clientId)
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        return List.of(appClient);
    }

    @Override
    public AppClient updateClient(UUID clientId, AppClient appClient) {
        return AppClient.builder()
                .id(clientId)
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }
}

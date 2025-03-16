package com.francislainy.olisaudebt.service;

import com.francislainy.olisaudebt.entity.AppClientEntity;
import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.model.HealthIssue;
import com.francislainy.olisaudebt.repository.ClientRepository;
import com.francislainy.olisaudebt.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.francislainy.olisaudebt.enums.Gender.FEMALE;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    ClientServiceImpl clientService;

    @Mock
    ClientRepository clientRepository;

    @Test
    void shouldCreateClient() {
        AppClient appClient = AppClient.builder()
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        AppClientEntity appClientEntity = appClient.toEntity().withId(randomUUID());

        when(clientRepository.save(any())).thenReturn(appClientEntity);
        AppClient result = clientService.createClient(appClient);

        assertNotNull(result);

        assertAll(
                () -> assertNotNull(result.getId()),
                () -> assertEquals(result.getName(), appClient.getName()),
                () -> assertEquals(result.getBirthDate(), appClient.getBirthDate()),
                () -> assertEquals(result.getGender(), appClient.getGender()),
                () -> assertEquals(result.getHealthIssue(), appClient.getHealthIssue()),
                () -> assertEquals(result.getCreatedAt(), appClient.getCreatedAt()),
                () -> assertEquals(result.getUpdatedAt(), appClient.getUpdatedAt())
        );

        verify(clientRepository, times(1)).save(any());
    }

    @Test
    void shouldRetrieveClient() {
        AppClient appClient = AppClient.builder()
                .id(randomUUID())
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        when(clientRepository.findById(any())).thenReturn(Optional.of(appClient.toEntity()));
        AppClient result = clientService.retrieveClient(appClient.getId());

        assertNotNull(result);

        assertAll(
                () -> assertNotNull(result.getId()),
                () -> assertEquals(result.getName(), appClient.getName()),
                () -> assertEquals(result.getBirthDate(), appClient.getBirthDate()),
                () -> assertEquals(result.getGender(), appClient.getGender()),
                () -> assertEquals(result.getHealthIssue(), appClient.getHealthIssue()),
                () -> assertEquals(result.getCreatedAt(), appClient.getCreatedAt()),
                () -> assertEquals(result.getUpdatedAt(), appClient.getUpdatedAt())
        );

        verify(clientRepository, times(1)).findById(any());
    }

    @Test
    void shouldRetrieveAllClients() {
        UUID clientId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");

        AppClientEntity appClient = AppClientEntity.builder()
                .id(clientId)
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        List<AppClientEntity> appClientList = List.of(appClient);

        when(clientRepository.findAll()).thenReturn(appClientList);
        List<AppClient> result = clientService.retrieveAllClients();

        assertFalse(result.isEmpty());

        assertAll(
                () -> assertEquals(result.size(), appClientList.size()),
                () -> assertEquals(result.get(0).getId(), appClientList.get(0).getId()),
                () -> assertEquals(result.get(0).getName(), appClientList.get(0).getName()),
                () -> assertEquals(result.get(0).getBirthDate(), appClientList.get(0).getBirthDate()),
                () -> assertEquals(result.get(0).getGender(), appClientList.get(0).getGender()),
                () -> assertEquals(result.get(0).getHealthIssue(), appClientList.get(0).getHealthIssue()),
                () -> assertEquals(result.get(0).getCreatedAt(), appClientList.get(0).getCreatedAt()),
                () -> assertEquals(result.get(0).getUpdatedAt(), appClientList.get(0).getUpdatedAt())
        );

        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void shouldUpdateClient() {
        UUID clientId = randomUUID();
        AppClient appClient = AppClient.builder()
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        when(clientRepository.save(any())).thenReturn(appClient.toEntity().withId(clientId));
        AppClient result = clientService.updateClient(clientId, appClient);

        assertNotNull(result);

        assertAll(
                () -> assertNotNull(result.getId()),
                () -> assertEquals(result.getName(), appClient.getName()),
                () -> assertEquals(result.getBirthDate(), appClient.getBirthDate()),
                () -> assertEquals(result.getGender(), appClient.getGender()),
                () -> assertEquals(result.getHealthIssue(), appClient.getHealthIssue()),
                () -> assertEquals(result.getCreatedAt(), appClient.getCreatedAt()),
                () -> assertEquals(result.getUpdatedAt(), appClient.getUpdatedAt())
        );

        verify(clientRepository, times(1)).save(any());
    }
}
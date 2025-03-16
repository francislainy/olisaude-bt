package com.francislainy.olisaudebt.controller;

import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.model.HealthIssue;
import com.francislainy.olisaudebt.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static com.francislainy.olisaudebt.enums.Gender.FEMALE;
import static com.francislainy.olisaudebt.util.TestUtil.toJson;
import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    ClientService clientService;

    @Test
    void shouldCreateClient() throws Exception {
        AppClient appClient = AppClient.builder()
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/client")
                        .contentType("application/json")
                        .content(toJson(appClient)))
                .andExpect(status().isCreated());

        verify(clientService, times(1)).createClient(any());
    }

    @Test
    void shouldRetrieveClient() throws Exception {
        UUID clientId = randomUUID();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client/{clientId}", clientId))
                .andExpect(status().isOk());

        verify(clientService, times(1)).retrieveClient(any(UUID.class));
    }

    @Test
    void shouldRetrieveAllClients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/client"))
                .andExpect(status().isOk());

        verify(clientService, times(1)).retrieveAllClients();
    }

    @Test
    void shouldUpdateClient() throws Exception {
        UUID clientId = randomUUID();
        AppClient appClient = AppClient.builder()
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/client/{clientIc}", clientId)
                        .contentType("application/json")
                        .content(toJson(appClient)))
                .andExpect(status().isOk());

        verify(clientService, times(1)).updateClient(any(), any());
    }
}
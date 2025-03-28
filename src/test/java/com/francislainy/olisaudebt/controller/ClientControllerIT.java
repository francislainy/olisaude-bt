package com.francislainy.olisaudebt.controller;

import com.francislainy.olisaudebt.config.BasePostgresConfig;
import com.francislainy.olisaudebt.entity.AppClientEntity;
import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.model.HealthIssue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

import static com.francislainy.olisaudebt.enums.Gender.FEMALE;
import static com.francislainy.olisaudebt.util.TestUtil.fromJson;
import static com.francislainy.olisaudebt.util.TestUtil.toJson;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientControllerIT extends BasePostgresConfig {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateClient() throws Exception {
        AppClient appClient = AppClient.builder()
                .name("anyName")
                .birthDate(LocalDate.now())
                .gender(FEMALE)
                .healthIssue(new HealthIssue("diabetes", 2))
                .build();

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(appClient)))
                .andExpect(status().isCreated())
                .andReturn();

        AppClientEntity createdClient = (AppClientEntity) fromJson(mvcResult.getResponse().getContentAsString(), AppClientEntity.class);
        assertNotNull(createdClient, "AppClient should not be null");
        assertAll(
                () -> assertNotNull(createdClient.getId(), "AppClient ID should not be null"),
                () -> assertEquals(appClient.getName(), createdClient.getName(), "AppClient name should match"),
                () -> assertEquals(appClient.getBirthDate(), createdClient.getBirthDate(), "AppClient birth date should match"),
                () -> assertEquals(appClient.getGender(), createdClient.getGender(), "AppClient gender should match"),
                () -> assertEquals(appClient.getHealthIssue(), createdClient.getHealthIssue(), ""),
                () -> assertNotNull(createdClient.getCreatedAt()));
    }
}

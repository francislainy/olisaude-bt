package com.francislainy.olisaudebt.model;

import com.francislainy.olisaudebt.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppClient {

    private UUID id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private HealthIssue healthIssue;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

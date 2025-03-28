package com.francislainy.olisaudebt.entity;

import com.francislainy.olisaudebt.enums.Gender;
import com.francislainy.olisaudebt.model.AppClient;
import com.francislainy.olisaudebt.model.HealthIssue;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@With
public class AppClientEntity {
    @GeneratedValue
    @Id
    private UUID id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "health_issue_name")),
            @AttributeOverride(name = "severity", column = @Column(name = "health_issue_severity"))
    })
    private HealthIssue healthIssue;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // to model

    public AppClient toModel() {
        return AppClient.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .gender(gender)
                .healthIssue(healthIssue)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
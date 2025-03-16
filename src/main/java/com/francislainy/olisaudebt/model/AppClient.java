package com.francislainy.olisaudebt.model;

import com.francislainy.olisaudebt.entity.AppClientEntity;
import com.francislainy.olisaudebt.enums.Gender;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@With
public class AppClient {

    private UUID id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private HealthIssue healthIssue;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // to entity
    public AppClientEntity toEntity() {
        return AppClientEntity.builder()
                .id(this.id)
                .name(this.name)
                .birthDate(this.birthDate)
                .gender(this.gender)
                .healthIssue(this.healthIssue)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

}

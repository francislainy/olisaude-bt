package com.francislainy.olisaudebt.repository;

import com.francislainy.olisaudebt.entity.AppClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<AppClientEntity, UUID> {
}

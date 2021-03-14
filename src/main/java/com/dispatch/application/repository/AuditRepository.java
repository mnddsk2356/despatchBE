package com.dispatch.application.repository;

import com.dispatch.application.entities.Audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {
}

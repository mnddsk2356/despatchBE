package com.dispatch.application.repository;


import com.dispatch.application.entities.TruckType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckTypeRepository extends JpaRepository<TruckType, Integer> {
}

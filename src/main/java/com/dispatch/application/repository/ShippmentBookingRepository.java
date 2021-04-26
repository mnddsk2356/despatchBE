package com.dispatch.application.repository;


import com.dispatch.application.entities.ShipmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippmentBookingRepository extends JpaRepository<ShipmentBooking, Integer> {
}

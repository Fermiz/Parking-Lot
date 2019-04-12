package com.thoughtworks.capability.parking.infrastructure.jpaRepository;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotJpaRepository extends JpaRepository<ParkingLot, Long> {
}

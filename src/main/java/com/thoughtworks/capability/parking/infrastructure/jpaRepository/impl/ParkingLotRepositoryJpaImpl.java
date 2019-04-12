package com.thoughtworks.capability.parking.infrastructure.jpaRepository.impl;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLotRepository;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.ParkingLotJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotRepositoryJpaImpl implements ParkingLotRepository {

    private final ParkingLotJpaRepository repository;

    @Autowired
    public ParkingLotRepositoryJpaImpl(ParkingLotJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public ParkingLot find(Long parkingLotId) {
        return repository.findById(parkingLotId).orElse(null);
    }

    @Override
    public void save(ParkingLot parkingLot) {
        repository.saveAndFlush(parkingLot);
    }
}

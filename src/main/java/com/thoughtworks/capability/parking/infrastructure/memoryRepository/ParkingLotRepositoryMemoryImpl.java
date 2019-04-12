package com.thoughtworks.capability.parking.infrastructure.memoryRepository;

import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLotRepository;

import java.util.List;

public class ParkingLotRepositoryMemoryImpl implements ParkingLotRepository {
    private List<ParkingLot> parkingLots;

    @Override
    public ParkingLot find(Long parkingLotId) {
        return parkingLots.stream()
                .filter(it -> it.getParkingLotId().equals(parkingLotId))
                .findFirst()
                .get();
    }

    @Override
    public void save(ParkingLot parkingLot) {
        parkingLots.remove(parkingLot);
        parkingLots.add(parkingLot);
    }
}

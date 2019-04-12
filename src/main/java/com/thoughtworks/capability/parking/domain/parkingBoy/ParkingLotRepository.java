package com.thoughtworks.capability.parking.domain.parkingBoy;

public interface ParkingLotRepository {
    ParkingLot find(Long parkingLotId);
    void save(ParkingLot parkingLot);
}

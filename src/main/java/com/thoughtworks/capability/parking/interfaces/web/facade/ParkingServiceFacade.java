package com.thoughtworks.capability.parking.interfaces.web.facade;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;

public interface ParkingServiceFacade {
    ParkingBoyDTO find(String parkingBoyId);

    ParkingLot parking(String parkingBoyId, String licensePlateNumber);

    LicensePlateId pick(String ticketId);
}

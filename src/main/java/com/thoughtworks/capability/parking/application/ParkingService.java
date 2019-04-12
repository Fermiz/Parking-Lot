package com.thoughtworks.capability.parking.application;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoy;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingBoyId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;


public interface ParkingService {
    ParkingLot parking(ParkingBoyId parkingBoyId, LicensePlateId licensePlateId);
    ParkingBoy get(ParkingBoyId parkingBoyId);
    LicensePlateId pick(TicketId ticketId);

}

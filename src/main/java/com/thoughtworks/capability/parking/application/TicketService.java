package com.thoughtworks.capability.parking.application;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;

public interface TicketService {
    Ticket create(Long parkingLotId, LicensePlateId licensePlateId);
}

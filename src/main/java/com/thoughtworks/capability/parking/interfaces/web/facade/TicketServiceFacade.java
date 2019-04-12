package com.thoughtworks.capability.parking.interfaces.web.facade;

import com.thoughtworks.capability.parking.domain.ticket.Ticket;

public interface TicketServiceFacade {
    Ticket create(Long parkingLotId, String licensePlateId);
}

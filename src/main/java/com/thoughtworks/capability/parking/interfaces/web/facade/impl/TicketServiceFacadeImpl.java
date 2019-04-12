package com.thoughtworks.capability.parking.interfaces.web.facade.impl;

import com.thoughtworks.capability.parking.application.TicketService;
import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.interfaces.web.facade.TicketServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceFacadeImpl implements TicketServiceFacade {

    private final TicketService ticketService;

    @Autowired
    public TicketServiceFacadeImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public Ticket create(Long parkingLotId, String licensePlateId) {
        return ticketService.create(parkingLotId, new LicensePlateId(licensePlateId));
    }
}

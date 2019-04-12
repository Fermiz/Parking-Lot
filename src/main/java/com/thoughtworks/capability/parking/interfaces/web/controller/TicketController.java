package com.thoughtworks.capability.parking.interfaces.web.controller;

import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.interfaces.web.facade.TicketServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketController {
    private TicketServiceFacade ticketServiceFacade;

    @Autowired
    public TicketController(TicketServiceFacade ticketServiceFacade) {
        this.ticketServiceFacade = ticketServiceFacade;
    }

    @PostMapping()
    public TicketId parking(@RequestBody TicketRequest param) {
        return ticketServiceFacade.create(param.getParkingLotId(), param.getLicensePlateId()).getTicketId();
    }
}

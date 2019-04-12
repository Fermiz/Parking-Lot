package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.application.TicketService;
import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLotRepository;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Ticket create(Long parkingLotId, LicensePlateId licensePlateId) {

        ParkingLot parkingLot = parkingLotRepository.find(parkingLotId);

        TicketId ticketId = new TicketId(ticketRepository.nextTicketId());
        Ticket newTicket = new Ticket(ticketId, parkingLot, licensePlateId);

        ticketRepository.save(newTicket);

        return newTicket;
    }
}

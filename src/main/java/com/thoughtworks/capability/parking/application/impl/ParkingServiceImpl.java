package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.application.ParkingService;
import com.thoughtworks.capability.parking.domain.parkingBoy.*;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingBoyRepository parkingBoyRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public ParkingServiceImpl(ParkingBoyRepository parkingBoyRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.parkingBoyRepository = parkingBoyRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public ParkingLot parking(ParkingBoyId parkingBoyId, LicensePlateId licensePlateId) {
        ParkingBoy parkingBoy = parkingBoyRepository.find(parkingBoyId);

        ParkingLot parkingLot = parkingBoy.park(licensePlateId);
        parkingLotRepository.save(parkingLot);

        return parkingLot;
    }

    @Override
    public ParkingBoy get(ParkingBoyId parkingBoyId) {
        return parkingBoyRepository.find(parkingBoyId);
    }

    @Override
    public LicensePlateId pick(TicketId ticketId) {
        Ticket ticket = ticketRepository.find(ticketId);
        ParkingBoy parkingBoy = parkingBoyRepository.find(ticket.getParkingLot().getParkingBoyId());
        return parkingBoy.pick(ticket.getLicensePlateId());
    }
}

package com.thoughtworks.capability.parking.interfaces.web.controller;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.interfaces.web.facade.ParkingServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.TicketServiceFacade;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingBoyDTO;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.ParkingRequest;
import com.thoughtworks.capability.parking.interfaces.web.facade.dto.PickRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parking-boy")
public class ParkingController {

    private ParkingServiceFacade parkingServiceFacade;
    private TicketServiceFacade ticketServiceFacade;

    @Autowired
    public ParkingController(ParkingServiceFacade parkingServiceFacade, TicketServiceFacade ticketServiceFacade) {
        this.parkingServiceFacade = parkingServiceFacade;
        this.ticketServiceFacade = ticketServiceFacade;
    }


    @GetMapping("/{parkingBoyId}")
    public ParkingBoyDTO getParkingBoy(@PathVariable String parkingBoyId) {
        return parkingServiceFacade.find(parkingBoyId);
    }

    @PostMapping("/parking")
    public TicketId parking(@RequestBody ParkingRequest param) {
        ParkingLot parkingLot = parkingServiceFacade.parking(param.getParkingBoyId(), param.getLicensePlateId());
        return ticketServiceFacade.create(parkingLot.getParkingLotId(), param.getLicensePlateId()).getTicketId();
    }

    @PostMapping("/pick")
    public LicensePlateId pick(@RequestBody PickRequest param) {

        return parkingServiceFacade.pick(param.getTicketId());
    }
}

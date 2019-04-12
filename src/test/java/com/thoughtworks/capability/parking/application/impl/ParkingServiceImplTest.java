package com.thoughtworks.capability.parking.application.impl;

import com.thoughtworks.capability.parking.domain.parkingBoy.*;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ParkingServiceImplTest {

    @Test
    public void pick_should_return_target_license_plate_given_valid_ticket(){
        ParkingBoyRepository parkingBoyRepositoryMock = mock(ParkingBoyRepository.class);
        ParkingLotRepository parkingLotRepositoryMock = mock(ParkingLotRepository.class);
        TicketRepository ticketRepositoryMock = mock(TicketRepository.class);

        ParkingServiceImpl parkingService = new ParkingServiceImpl(parkingBoyRepositoryMock, parkingLotRepositoryMock,ticketRepositoryMock);
        ParkingLot parkingLot = new ParkingLot(2);
        when(parkingBoyRepositoryMock.find(any())).thenReturn(new ParkingBoy(new ParkingBoyId("abc"), "parkingBoy1", Arrays.asList(parkingLot)));
        when(ticketRepositoryMock.find(any())).thenReturn(new Ticket(new TicketId("12345"), parkingLot, new LicensePlateId("1234")));

        parkingService.parking(new ParkingBoyId("abc"), new LicensePlateId("1234"));

        assertTrue(parkingService.pick(new TicketId("12345")).sameValueAs(new LicensePlateId("1234")));
    }

}
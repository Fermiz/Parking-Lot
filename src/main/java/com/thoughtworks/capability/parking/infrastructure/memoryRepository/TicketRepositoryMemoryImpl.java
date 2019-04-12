package com.thoughtworks.capability.parking.infrastructure.memoryRepository;

import com.thoughtworks.capability.parking.domain.parkingBoy.IllegalTicketException;
import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketRepositoryMemoryImpl implements TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public String nextTicketId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Ticket find(TicketId ticketId) {
        return tickets.stream().filter(it -> it.getTicketId().sameValueAs(ticketId)).findFirst().orElseThrow(IllegalTicketException::new);
    }
}
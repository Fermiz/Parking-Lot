package com.thoughtworks.capability.parking.infrastructure.jpaRepository.impl;

import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import com.thoughtworks.capability.parking.domain.ticket.TicketRepository;
import com.thoughtworks.capability.parking.infrastructure.jpaRepository.TicketJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TicketRepositoryJpaImpl implements TicketRepository {

    private TicketJpaRepository repository;

    @Autowired
    public TicketRepositoryJpaImpl(TicketJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Ticket ticket) {
        repository.saveAndFlush(ticket);
    }

    @Override
    public String nextTicketId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Ticket find(TicketId ticketId) {
        return repository.findById(ticketId).orElseThrow(IllegalAccessError::new);
    }
}

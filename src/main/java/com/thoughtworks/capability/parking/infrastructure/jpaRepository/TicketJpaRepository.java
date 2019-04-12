package com.thoughtworks.capability.parking.infrastructure.jpaRepository;

import com.thoughtworks.capability.parking.domain.ticket.Ticket;
import com.thoughtworks.capability.parking.domain.ticket.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketJpaRepository extends JpaRepository<Ticket, TicketId> {
}

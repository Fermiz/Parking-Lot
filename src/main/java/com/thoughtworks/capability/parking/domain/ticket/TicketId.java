package com.thoughtworks.capability.parking.domain.ticket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.capability.parking.domain.shared.ValueObject;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class TicketId implements ValueObject<TicketId> {

    @Column(name = "ticket_id")
    @JsonProperty("ticketId")
    private String uuid;

    public TicketId(){}

    public TicketId(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        TicketId other = (TicketId) obj;

        return sameValueAs(other);
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean sameValueAs(TicketId other) {
        return other !=null && uuid.equals(other.uuid);
    }
}

package com.thoughtworks.capability.parking.domain.ticket;

import com.thoughtworks.capability.parking.domain.parkingBoy.LicensePlateId;
import com.thoughtworks.capability.parking.domain.parkingBoy.ParkingLot;
import com.thoughtworks.capability.parking.domain.shared.DomainEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class Ticket implements DomainEntity<Ticket> {
    @EmbeddedId
    private TicketId ticketId;

    public TicketId getTicketId() {
        return ticketId;
    }

    @OneToOne
    @JoinColumn(name="parking_lot_id")
    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    @Embedded
    private LicensePlateId licensePlateId;

    public Ticket(TicketId ticketId, ParkingLot parkingLot, LicensePlateId licensePlateId) {
        this.ticketId = ticketId;
        this.parkingLot = parkingLot;
        this.licensePlateId = licensePlateId;
    }

    public LicensePlateId getLicensePlateId() {
        return this.licensePlateId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Ticket other = (Ticket) obj;

        return sameIdentityAs(other);
    }

    @Override
    public boolean sameIdentityAs(Ticket other) {
        return other != null && ticketId.equals(other.ticketId);
    }
}

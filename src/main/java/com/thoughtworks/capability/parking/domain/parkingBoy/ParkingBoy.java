package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.DomainEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@NoArgsConstructor
public class ParkingBoy implements Parkable, DomainEntity<ParkingBoy> {

    @EmbeddedId
    private ParkingBoyId parkingBoyId;

    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "parking_boy_id")
    private List<ParkingLot> parkingLots;


    public ParkingBoy(ParkingBoyId parkingBoyId, String name, List<ParkingLot> parkingLots) {
        this.parkingBoyId = parkingBoyId;
        this.name = name;
        this.parkingLots = parkingLots;
    }

    @Override
    public ParkingLot park(LicensePlateId licensePlateId) {
        ParkingLot first = parkingLots.stream()
                .filter(it -> it.availableCapacity() > 0)
                .findFirst()
                .orElseThrow(NoEnoughCapacityException::new);

        return first.park(licensePlateId);
    }

    @Override
    public int availableCapacity() {
        return 0;
    }

    @Override
    public LicensePlateId pick(LicensePlateId lp) {
        Parkable first = parkingLots.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);

        return first.pick(lp);
    }

    public ParkingBoyId getParkingBoyId() {
        return parkingBoyId;
    }

    public List<ParkingLot> getParkingLot() {
        return Collections.unmodifiableList(parkingLots.stream().map(it -> (ParkingLot) it).collect(Collectors.toList()));
    }

    @Override
    public boolean sameIdentityAs(ParkingBoy other) {
        return other != null && parkingBoyId.equals(other.parkingBoyId);
    }

    @Override
    public String toString() {
        return "ParkingBoy{\n" +
                "\tparkingBoyId=" + parkingBoyId +
                ",\n\tparkingLots=" + parkingLots +
                '}';
    }

    public String getName() {
        return name;
    }
}

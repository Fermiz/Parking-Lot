package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "parking_lot")
@NoArgsConstructor
public class ParkingLot implements Parkable, ValueObject<ParkingLot> {

    private int capacity;

    @Id
    private Long parkingLotId;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    private ParkingBoyId parkingBoyId;

    public ParkingBoyId getParkingBoyId() {
        return parkingBoyId;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parking_lot_id")
    private List<StoredLicensePlate> storedLicensePlates;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        storedLicensePlates = new ArrayList<>();
    }

    public ParkingLot(int capacity, Long parkingLotId, ParkingBoyId parkingBoyId, List<LicensePlateId> licensePlateIds) {
        this.capacity = capacity;
        this.parkingLotId = parkingLotId;
        this.parkingBoyId = parkingBoyId;
        this.storedLicensePlates = licensePlateIds.stream().map(it -> new StoredLicensePlate(parkingLotId, it)).collect(Collectors.toList());
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public ParkingLot park(LicensePlateId licensePlateId) {

        if(availableCapacity() < 1) {
            throw new NoEnoughCapacityException();
        }

        storedLicensePlates.add(new StoredLicensePlate(parkingLotId, licensePlateId));

        return this;
    }

    @Override
    public int availableCapacity() {
        return capacity - storedLicensePlates.size();
    }

    @Override
    public LicensePlateId pick(LicensePlateId lp) {
        StoredLicensePlate storedLicensePlate = storedLicensePlates.stream()
                .filter(license -> license.getLicensePlate().equals(lp))
                .findFirst()
                .orElseThrow(IllegalTicketException::new);

        storedLicensePlates.remove(storedLicensePlate);
        return storedLicensePlate.getLicensePlate();
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "capacity=" + capacity +
                ", storedLicensePlates=" + storedLicensePlates +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        ParkingLot other = (ParkingLot) obj;
        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(ParkingLot other) {
        return other!=null && new EqualsBuilder()
                .append(parkingLotId, other.parkingLotId)
                .append(parkingBoyId, other.parkingBoyId)
                .append(storedLicensePlates, other.storedLicensePlates)
                .isEquals();
    }
}

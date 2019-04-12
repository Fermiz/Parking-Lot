package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.DomainEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="license_plate")
public class StoredLicensePlate implements DomainEntity<StoredLicensePlate> {

    @Id
    @Column(name = "parking_lot_id")
    private Long parkingLotId;

    @Embedded
    private LicensePlateId licensePlate;

    public StoredLicensePlate() {
    }

    public StoredLicensePlate(Long parkingLotId, LicensePlateId licensePlateId) {
        this.parkingLotId = parkingLotId;
        this.licensePlate = licensePlateId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != this.getClass()) return false;

        StoredLicensePlate other = (StoredLicensePlate) obj;
        return sameIdentityAs(other);
    }

    @Override
    public boolean sameIdentityAs(StoredLicensePlate other) {
        return other != null && parkingLotId.equals(other.parkingLotId) && licensePlate.sameValueAs(other.getLicensePlate());
    }

    @Override
    public String toString() {
        return "LicensePlateId{" +
                "parkingLotId='" + parkingLotId + '\'' +
                "licensePlateId='" + licensePlate.getLicensePlateId() + '\'' +
                '}';
    }
}

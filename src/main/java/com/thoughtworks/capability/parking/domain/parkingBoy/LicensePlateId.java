package com.thoughtworks.capability.parking.domain.parkingBoy;

import com.thoughtworks.capability.parking.domain.shared.ValueObject;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class LicensePlateId implements ValueObject<LicensePlateId> {

    @Column(name="license_plate_id")
    private String licensePlateId;

    public LicensePlateId() {
    }

    public LicensePlateId(String licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != this.getClass()) return false;

        LicensePlateId other = (LicensePlateId) obj;
        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(LicensePlateId other) {
        return other != null && licensePlateId.equals(other.licensePlateId);
    }

    @Override
    public String toString() {
        return "LicensePlateId{" +
                "licensePlateId='" + licensePlateId + '\'' +
                '}';
    }
}

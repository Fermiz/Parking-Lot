package com.thoughtworks.capability.parking.interfaces.web.facade.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest{
    private String parkingBoyId;
    private String licensePlateId;
}

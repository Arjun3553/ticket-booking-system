package com.tbs.partnerprofile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "vehicle_details")
public class VehicleDetailsHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;

}

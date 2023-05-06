package com.example.Lab2.Model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    private Long maintenanceID;

    private String difficulty;

    private String urgency;

    private String description;

    private Long mechanicID;

    private Long carID;
}

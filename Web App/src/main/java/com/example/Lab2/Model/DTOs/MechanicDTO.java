package com.example.Lab2.Model.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MechanicDTO {
    private Long id;

    private String name;

    private String cnp;

    private String address;

    private int experience;

    private String favouriteCarBrand;
}

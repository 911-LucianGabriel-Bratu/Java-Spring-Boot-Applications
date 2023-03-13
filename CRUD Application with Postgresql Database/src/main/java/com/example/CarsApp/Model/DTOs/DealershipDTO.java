package com.example.CarsApp.Model.DTOs;

import com.example.CarsApp.Model.Dealership;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealershipDTO {
    private Long id;

    private String name;

    private int capacity;

    private String address;

    private double reputation;

    private boolean hasService;

    private boolean offersTradeIn;

    @JsonIgnore
    public DealershipDTO getDealershipWithoutCars(){
        return this;
    }

}

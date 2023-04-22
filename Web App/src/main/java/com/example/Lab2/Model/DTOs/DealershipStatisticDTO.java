package com.example.Lab2.Model.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DealershipStatisticDTO {
    private double avgInventoryValue;
    private DealershipDTO dealershipDTO;
    @JsonIgnore
    public DealershipStatisticDTO getStatistic(){
        return this;
    }
}

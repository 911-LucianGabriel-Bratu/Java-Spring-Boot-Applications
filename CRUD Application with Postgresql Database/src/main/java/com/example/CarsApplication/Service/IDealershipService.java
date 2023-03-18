package com.example.CarsApplication.Service;

import com.example.CarsApplication.Model.DTOs.DealershipDTO;
import com.example.CarsApplication.Model.DTOs.DealershipStatisticDTO;
import com.example.CarsApplication.Model.Dealership;

import java.util.List;

public interface IDealershipService {
    Dealership saveDealership(Dealership dealership);
    //read
    List<DealershipDTO> fetchDealershipDTOList();

    List<Dealership> fetchDealershipList();
    Dealership one(Long dealershipID);
    //update
    Dealership updateDealership(Dealership dealership, Long dealershipID);

    List<DealershipStatisticDTO> fetchStatisticForDealershipsInventories();
    //delete
    void deleteDealership(Long dealershipID);
}
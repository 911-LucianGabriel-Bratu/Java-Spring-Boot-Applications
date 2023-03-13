package com.example.CarsApp.Service;

import com.example.CarsApp.Model.DTOs.DealershipDTO;
import com.example.CarsApp.Model.Dealership;

import java.util.List;

public interface IDealershipService {
    Dealership saveDealership(Dealership dealership);
    //read
    List<DealershipDTO> fetchDealershipDTOList();

    List<Dealership> fetchDealershipList();
    Dealership one(Long dealershipID);
    //update
    Dealership updateDealership(Dealership dealership, Long dealershipID);
    //delete
    void deleteDealership(Long dealershipID);
}

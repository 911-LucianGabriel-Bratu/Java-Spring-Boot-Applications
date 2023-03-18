package com.example.CarsApplication.Controller;

import com.example.CarsApplication.Model.DTOs.DealershipDTO;
import com.example.CarsApplication.Model.DTOs.DealershipStatisticDTO;
import com.example.CarsApplication.Model.Dealership;
import com.example.CarsApplication.Service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DealershipController {
    @Autowired
    private DealershipService dealershipService;

    @GetMapping("/dealerships")
    public List<DealershipDTO> fetchDealerships(){
        return this.dealershipService.fetchDealershipDTOList();
    }

    @GetMapping("/dealerships/{dealershipID}")
    public Dealership one(@PathVariable("dealershipID") Long dealershipID){
        return this.dealershipService.one(dealershipID);
    }

    @GetMapping("/dealerships/filter/{filterValue}")
    public List<Dealership> fetchDealershipsWithGreaterRating(@PathVariable("filterValue") Double filterValue){
        List<Dealership> dealershipList = new ArrayList<>();
        for(Dealership dealership : this.dealershipService.fetchDealershipList()){
            if(dealership.getReputation() > filterValue){
                dealershipList.add(dealership);
            }
        }
        return dealershipList;
    }

    @GetMapping("/dealerships/avgInventory")
    public List<DealershipStatisticDTO> fetchInventoryStatistic(){
        return this.dealershipService.fetchStatisticForDealershipsInventories();
    }

    @PostMapping("/dealerships")
    public Dealership saveDealership(@RequestBody Dealership dealership){
        return this.dealershipService.saveDealership(dealership);
    }

    @PutMapping("/dealerships/{dealershipID}")
    public Dealership updateDealership(@RequestBody Dealership dealership, @PathVariable("dealershipID") Long dealershipID){
        return this.dealershipService.updateDealership(dealership, dealershipID);
    }

    @DeleteMapping("/dealerships/{dealershipID}")
    public String deleteDealership(@PathVariable("dealershipID") Long dealershipID){
        this.dealershipService.deleteDealership(dealershipID);
        return "Dealership successfully deleted";
    }
}

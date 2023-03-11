package com.example.CarsApp.Controller;

import com.example.CarsApp.Model.Dealership;
import com.example.CarsApp.Service.DealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DealershipController {
    @Autowired
    private DealershipService dealershipService;

    @GetMapping("/dealerships")
    public List<Dealership> fetchDealerships(){
        return this.dealershipService.fetchDealershipList();
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

package com.example.CarsApp.Service;

import com.example.CarsApp.Model.Dealership;
import com.example.CarsApp.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipService implements IDealershipService{
    @Autowired
    private DealershipRepository dealershipRepository;

    @Override
    public Dealership saveDealership(Dealership dealership) {
        return this.dealershipRepository.save(dealership);
    }

    @Override
    public List<Dealership> fetchDealershipList() {
        return this.dealershipRepository.findAll();
    }

    @Override
    public Dealership one(Long dealershipID) {
        return this.dealershipRepository.findById(dealershipID).get();
    }

    @Override
    public Dealership updateDealership(Dealership dealership, Long dealershipID) {
        Dealership foundDealership = this.dealershipRepository.findById(dealershipID).get();
        foundDealership.setName(dealership.getName());
        foundDealership.setAddress(dealership.getAddress());
        foundDealership.setCapacity(dealership.getCapacity());
        foundDealership.setReputation(dealership.getReputation());
        foundDealership.setHasService(dealership.isHasService());
        foundDealership.setOffersTradeIn(dealership.isOffersTradeIn());
        foundDealership.setCars(dealership.getCars());
        return this.dealershipRepository.save(foundDealership);
    }

    @Override
    public void deleteDealership(Long dealershipID) {
        this.dealershipRepository.deleteById(dealershipID);
    }
}

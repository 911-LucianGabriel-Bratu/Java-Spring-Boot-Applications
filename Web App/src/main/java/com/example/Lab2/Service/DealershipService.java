package com.example.Lab2.Service;

import com.example.Lab2.Model.Car;
import com.example.Lab2.Model.DTOs.DealershipDTO;
import com.example.Lab2.Model.DTOs.DealershipStatisticDTO;
import com.example.Lab2.Model.Dealership;
import com.example.Lab2.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class SortByInv implements Comparator<DealershipStatisticDTO> {

    public int compare(DealershipStatisticDTO dto1, DealershipStatisticDTO dto2){
        if(dto1.getAvgInventoryValue() < dto2.getAvgInventoryValue()){
            return 1;
        }
        else if(dto1.getAvgInventoryValue() > dto2.getAvgInventoryValue()){
            return -1;
        }
        else{
            return 0;
        }
    }
}

@Service
public class DealershipService implements IDealershipService{
    @Autowired
    private DealershipRepository dealershipRepository;

    @Override
    public Dealership saveDealership(Dealership dealership) {
        return this.dealershipRepository.save(dealership);
    }

    public List<Dealership> fetchDealershipList(){
        return this.dealershipRepository.findAll();
    }


    public long getDealershipCount(){
        return this.dealershipRepository.count();
    }

    public List<DealershipDTO> fetchDealershipsPaginated(int pageNr){
        List<DealershipDTO> dealershipDTOS = new ArrayList<>();
        long start_id = (pageNr-1) * 10 + 1;
        long max_id = start_id + 10;
        List<Dealership> dealershipList =  new ArrayList<>();
        while(start_id < max_id){
            try {
                Dealership d = this.dealershipRepository.findById(start_id).get();
                dealershipList.add(d);
                start_id += 1;
            }
            catch (java.util.NoSuchElementException e){
                start_id += 1;
            }
        }
        for(Dealership dealership : dealershipList){
            DealershipDTO dealershipDTO = new DealershipDTO();
            dealershipDTO.setId(dealership.getDealershipID());
            dealershipDTO.setName(dealership.getName());
            dealershipDTO.setReputation(dealership.getReputation());
            dealershipDTO.setCapacity(dealership.getCapacity());
            dealershipDTO.setHasService(dealership.isHasService());
            dealershipDTO.setOffersTradeIn(dealership.isOffersTradeIn());
            dealershipDTO.setAddress(dealership.getAddress());
            dealershipDTOS.add(dealershipDTO);
        }
        return dealershipDTOS;
    }
    @Override
    public List<DealershipDTO> fetchDealershipDTOList() {
        List<DealershipDTO> dealershipDTOS = new ArrayList<>();
        long id_limit = 100;
        List<Dealership> dealershipList =  new ArrayList<>();
        while(id_limit > 0){
            Dealership d = this.dealershipRepository.findById(id_limit).get();
            dealershipList.add(d);
            id_limit -= 1;
        }
        for(Dealership dealership : dealershipList){
            DealershipDTO dealershipDTO = new DealershipDTO();
            dealershipDTO.setId(dealership.getDealershipID());
            dealershipDTO.setName(dealership.getName());
            dealershipDTO.setReputation(dealership.getReputation());
            dealershipDTO.setCapacity(dealership.getCapacity());
            dealershipDTO.setHasService(dealership.isHasService());
            dealershipDTO.setOffersTradeIn(dealership.isOffersTradeIn());
            dealershipDTO.setAddress(dealership.getAddress());
            dealershipDTOS.add(dealershipDTO);
        }
        return dealershipDTOS;
    }

    @Override
    public Dealership one(Long dealershipID) {
        return this.dealershipRepository.findById(dealershipID).get();
    }

    public DealershipDTO oneDTO(Long dealershipID){
        Dealership dealership = this.dealershipRepository.findById(dealershipID).get();
        DealershipDTO dealershipDTO = new DealershipDTO();
        dealershipDTO.setId(dealership.getDealershipID());
        dealershipDTO.setName(dealership.getName());
        dealershipDTO.setReputation(dealership.getReputation());
        dealershipDTO.setCapacity(dealership.getCapacity());
        dealershipDTO.setHasService(dealership.isHasService());
        dealershipDTO.setOffersTradeIn(dealership.isOffersTradeIn());
        dealershipDTO.setAddress(dealership.getAddress());
        return dealershipDTO;
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

    public List<DealershipStatisticDTO> fetchPaginatedStatisticForDealershipsInventories(int pageNr){
        int start_id = (pageNr-1) * 10;
        int max_id = start_id + 9;
        List<DealershipStatisticDTO> dealershipStatisticDTOS = this.fetchStatisticForDealershipsInventories();
        List<DealershipStatisticDTO> dealershipStatisticDTOSPaginated = new ArrayList<>();
        while(start_id <= max_id){
            dealershipStatisticDTOSPaginated.add(dealershipStatisticDTOS.get(start_id));
            start_id += 1;
        }
        return dealershipStatisticDTOSPaginated;
    }

    @Override
    public List<DealershipStatisticDTO> fetchStatisticForDealershipsInventories() {
        List<DealershipStatisticDTO> dealershipStatisticDTOS = new ArrayList<>();
        List<Dealership> dealershipList = this.dealershipRepository.findAll();
        for(Dealership dealership : dealershipList){
            double avg_value = 0;
            int size = 0;
            for(Car car: dealership.getCars()){
                size += 1;
                avg_value += car.getCarRetailPrice();
            }
            avg_value = avg_value/size;

            DealershipDTO dealershipDTO = new DealershipDTO();
            dealershipDTO.setId(dealership.getDealershipID());
            dealershipDTO.setName(dealership.getName());
            dealershipDTO.setReputation(dealership.getReputation());
            dealershipDTO.setCapacity(dealership.getCapacity());
            dealershipDTO.setHasService(dealership.isHasService());
            dealershipDTO.setOffersTradeIn(dealership.isOffersTradeIn());
            dealershipDTO.setAddress(dealership.getAddress());

            dealershipStatisticDTOS.add(new DealershipStatisticDTO(avg_value, dealershipDTO));
        }
        dealershipStatisticDTOS.sort(new SortByInv());
        return dealershipStatisticDTOS;
    }

    @Override
    public List<DealershipStatisticDTO> testFetchStatisticForDealershipsInventories() {
        List<DealershipStatisticDTO> dealershipStatisticDTOS = new ArrayList<>();
        List<Dealership> dealershipList =  this.dealershipRepository.findAll();
        int limit = 100;
        for(Dealership dealership : dealershipList){
            if(limit >= 0) {
                double avg_value = 0;
                int size = 0;
                for (Car car : dealership.getCars()) {
                    size += 1;
                    avg_value += car.getCarRetailPrice();
                }
                avg_value = avg_value / size;

                DealershipDTO dealershipDTO = new DealershipDTO();
                dealershipDTO.setId(dealership.getDealershipID());
                dealershipDTO.setName(dealership.getName());
                dealershipDTO.setReputation(dealership.getReputation());
                dealershipDTO.setCapacity(dealership.getCapacity());
                dealershipDTO.setHasService(dealership.isHasService());
                dealershipDTO.setOffersTradeIn(dealership.isOffersTradeIn());
                dealershipDTO.setAddress(dealership.getAddress());

                dealershipStatisticDTOS.add(new DealershipStatisticDTO(avg_value, dealershipDTO));

                limit -= 1;
            }
            else{
                break;
            }
        }

        Collections.sort(dealershipStatisticDTOS, new SortByInv());

        return dealershipStatisticDTOS.stream().limit(100).collect(Collectors.toList());
    }

    @Override
    public void deleteDealership(Long dealershipID) {
        this.dealershipRepository.deleteById(dealershipID);
    }
}


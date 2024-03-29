package com.example.Lab2.Service;

import com.example.Lab2.Model.Car;
import com.example.Lab2.Model.DTOs.MaintenanceDTO;
import com.example.Lab2.Model.DTOs.NrCarsStatisticDTO;
import com.example.Lab2.Model.Dealership;
import com.example.Lab2.Model.Mechanic;
import com.example.Lab2.Model.PerformsMaintenance;
import com.example.Lab2.Repository.CarRepository;
import com.example.Lab2.Repository.MaintenanceRepository;
import com.example.Lab2.Repository.MechanicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService{
    @Autowired private MaintenanceRepository maintenanceRepository;

    @Autowired private CarRepository carRepository;

    @Autowired private MechanicRepository mechanicRepository;

    @Override
    public List<PerformsMaintenance> fetchMaintenanceList() {
        return this.maintenanceRepository.findAll();
    }
    @Override
    public MaintenanceDTO oneDTO(Long maintenanceID){
        PerformsMaintenance maintenance = this.maintenanceRepository.findById(maintenanceID).get();
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();

        maintenanceDTO.setMaintenanceID(maintenance.getMaintenanceID());
        maintenanceDTO.setDescription(maintenance.getDescription());
        maintenanceDTO.setDifficulty(maintenance.getDifficulty());
        maintenanceDTO.setUrgency(maintenance.getUrgency());
        maintenanceDTO.setMechanicID(maintenance.getMechanic().getMechanicID());
        maintenanceDTO.setCarID(maintenance.getCar().getCarID());

        return maintenanceDTO;
    }

    public List<MaintenanceDTO> fetchMaintenanceListPaginated(int pageNr){
        long start_id = (pageNr-1) * 10 + 1;
        long max_id = start_id + 10;
        List<MaintenanceDTO> maintenanceDTOList = new ArrayList<>();

        while(start_id < max_id){
            try{
                PerformsMaintenance maintenance = maintenanceRepository.findById(start_id).get();
                MaintenanceDTO maintenanceDTO = new MaintenanceDTO();
                maintenanceDTO.setMaintenanceID(maintenance.getMaintenanceID());
                maintenanceDTO.setDescription(maintenance.getDescription());
                maintenanceDTO.setDifficulty(maintenance.getDifficulty());
                maintenanceDTO.setUrgency(maintenance.getUrgency());
                maintenanceDTO.setMechanicID(maintenance.getMechanic().getMechanicID());
                maintenanceDTO.setCarID(maintenance.getCar().getCarID());
                maintenanceDTOList.add(maintenanceDTO);
                start_id+=1;
            }
            catch (java.util.NoSuchElementException e){
                start_id +=1;
            }
        }

        return maintenanceDTOList;
    }

    @Override
    public PerformsMaintenance one(Long maintenanceID) {
        return this.maintenanceRepository.findById(maintenanceID).get();
    }

    @Override
    public Long fetchMaintenanceCount(){
        return this.maintenanceRepository.count();
    }

    @Override
    public PerformsMaintenance saveMaintenance(PerformsMaintenance maintenance, Long carID, Long mechanicID) {
        Car car = this.carRepository.findById(carID).get();
        List<PerformsMaintenance> carPerformsMaintenance = car.getPerformsMaintenancesList();
        carPerformsMaintenance.add(maintenance);
        car.setPerformsMaintenancesList(carPerformsMaintenance);
        this.carRepository.save(car);

        Mechanic mechanic = this.mechanicRepository.findById(mechanicID).get();
        List<PerformsMaintenance> mechanicPerformsMaintenance = mechanic.getPerformsMaintenancesList();
        mechanicPerformsMaintenance.add(maintenance);
        mechanic.setPerformsMaintenancesList(mechanicPerformsMaintenance);
        this.mechanicRepository.save(mechanic);

        maintenance.setCar(car);
        maintenance.setMechanic(mechanic);

        return this.maintenanceRepository.save(maintenance);
    }

    @Override
    public PerformsMaintenance updateMaintenance(MaintenanceDTO maintenance, Long maintenanceID) {
        PerformsMaintenance maintenance1 = this.maintenanceRepository.findById(maintenanceID).get();

        Car car = this.carRepository.findById(maintenance.getCarID()).get();
        Mechanic mechanic = this.mechanicRepository.findById(maintenance.getMechanicID()).get();

        maintenance1.setDifficulty(maintenance.getDifficulty());
        maintenance1.setUrgency(maintenance.getUrgency());
        maintenance1.setDescription(maintenance.getDescription());
        maintenance1.setCar(car);
        maintenance1.setMechanic(mechanic);

        return this.maintenanceRepository.save(maintenance1);
    }

    @Override
    public List<PerformsMaintenance> bulkAddMechanicsForCars(Long carID, List<Mechanic> mechanicsList) {
        List<PerformsMaintenance> performsMaintenanceList = new ArrayList<>();
        Car car = this.carRepository.findById(carID).get();
        for(Mechanic mechanic: mechanicsList){
            List<PerformsMaintenance> performsMaintenanceList1 = new ArrayList<>();
            PerformsMaintenance performsMaintenance = new PerformsMaintenance();
            Mechanic mechanic1 = new Mechanic();
            mechanic1.setCnp(mechanic.getCnp());
            mechanic1.setAddress(mechanic.getAddress());
            mechanic1.setName(mechanic.getName());
            mechanic1.setExperience(mechanic.getExperience());
            mechanic1.setFavouriteCarBrand(mechanic.getFavouriteCarBrand());

            this.mechanicRepository.save(mechanic1);

            performsMaintenance.setUrgency("urgent");
            performsMaintenance.setDifficulty("easy");
            performsMaintenance.setCar(car);
            performsMaintenance.setMechanic(mechanic1);

            this.maintenanceRepository.save(performsMaintenance);
            performsMaintenanceList.add(performsMaintenance);

            performsMaintenanceList1.add(performsMaintenance);
            mechanic.setPerformsMaintenancesList(performsMaintenanceList1);

            performsMaintenanceList1.clear();

            performsMaintenanceList1 = car.getPerformsMaintenancesList();
            performsMaintenanceList1.add(performsMaintenance);
            car.setPerformsMaintenancesList(performsMaintenanceList);
            this.mechanicRepository.save(mechanic1);
        }
        this.carRepository.save(car);
        return performsMaintenanceList;
    }

    @Override
    public void deleteMaintenance(Long maintenanceID) {
        this.maintenanceRepository.deleteById(maintenanceID);
    }

    @Override
    public List<NrCarsStatisticDTO> fetchCarsMaintenanceStatistic() {
        List<Car> carList = this.carRepository.findAll();
        List<NrCarsStatisticDTO> statisticDTOList = new ArrayList<>();


        for(Car c : carList){
            NrCarsStatisticDTO nrCarsStatisticDTO = new NrCarsStatisticDTO();
            nrCarsStatisticDTO.setCarID(c.getCarID());
            nrCarsStatisticDTO.setCarManufacturer(c.getCarManufacturer());
            nrCarsStatisticDTO.setCarModel(c.getCarModel());
            nrCarsStatisticDTO.setCarRetailPrice(c.getCarRetailPrice());
            nrCarsStatisticDTO.setCarWeight(c.getCarWeight());
            nrCarsStatisticDTO.setCarTopSpeed(c.getCarTopSpeed());
            nrCarsStatisticDTO.setNrMechanics(c.getPerformsMaintenancesList().size());
            statisticDTOList.add(nrCarsStatisticDTO);
        }

        for(int i = 0; i<statisticDTOList.size()-1; i++){
            for(int j = i+1; j<statisticDTOList.size(); j++){
                if(statisticDTOList.get(i).getNrMechanics() < statisticDTOList.get(j).getNrMechanics()){
                    NrCarsStatisticDTO nrCarsStatisticDTO = statisticDTOList.get(i);
                    statisticDTOList.set(i, statisticDTOList.get(j));
                    statisticDTOList.set(j, nrCarsStatisticDTO);
                }
            }
        }


        return statisticDTOList;
    }
}

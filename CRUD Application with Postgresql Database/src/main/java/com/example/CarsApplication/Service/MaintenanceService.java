package com.example.CarsApplication.Service;

import com.example.CarsApplication.Model.Car;
import com.example.CarsApplication.Model.Mechanic;
import com.example.CarsApplication.Model.PerformsMaintenance;
import com.example.CarsApplication.Repository.CarRepository;
import com.example.CarsApplication.Repository.MaintenanceRepository;
import com.example.CarsApplication.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PerformsMaintenance one(Long maintenanceID) {
        return this.maintenanceRepository.findById(maintenanceID).get();
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
    public PerformsMaintenance updateMaintenance(PerformsMaintenance maintenance, Long maintenanceID) {
        PerformsMaintenance maintenance1 = this.maintenanceRepository.findById(maintenanceID).get();
        maintenance1.setDifficulty(maintenance.getDifficulty());
        maintenance1.setUrgency(maintenance.getUrgency());
        return this.maintenanceRepository.save(maintenance1);
    }

    @Override
    public void deleteMaintenance(Long maintenanceID) {
        this.maintenanceRepository.deleteById(maintenanceID);
    }
}

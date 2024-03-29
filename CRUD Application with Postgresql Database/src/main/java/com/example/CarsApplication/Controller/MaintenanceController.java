package com.example.CarsApplication.Controller;

import com.example.CarsApplication.Model.PerformsMaintenance;
import com.example.CarsApplication.Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaintenanceController {
    @Autowired private MaintenanceService maintenanceService;

    @GetMapping("/maintenance")
    public List<PerformsMaintenance> fetchMaintenanceList(){
        return this.maintenanceService.fetchMaintenanceList();
    }

    @GetMapping("/maintenance/{maintenanceID}")
    public PerformsMaintenance one(@PathVariable("maintenanceID") Long maintenanceID){
        return this.maintenanceService.one(maintenanceID);
    }

    @PostMapping("/maintenance/cars/{carID}/mechanics/{mechanicID}")
    public PerformsMaintenance saveMaintenance(@RequestBody PerformsMaintenance maintenance, @PathVariable("carID") Long carID, @PathVariable("mechanicID") Long mechanicID){
        return this.maintenanceService.saveMaintenance(maintenance, carID, mechanicID);
    }

    @PutMapping("/maintenance/{maintenanceID}")
    public PerformsMaintenance updateMaintenance(@RequestBody PerformsMaintenance maintenance, @PathVariable("maintenanceID") Long maintenanceID){
        return this.maintenanceService.updateMaintenance(maintenance, maintenanceID);
    }

    @DeleteMapping("/maintenance/{maintenanceID}")
    public String deleteMaintenance(@PathVariable("maintenanceID") Long maintenanceID){
        this.maintenanceService.deleteMaintenance(maintenanceID);
        return "Maintenance successfully deleted";
    }
}

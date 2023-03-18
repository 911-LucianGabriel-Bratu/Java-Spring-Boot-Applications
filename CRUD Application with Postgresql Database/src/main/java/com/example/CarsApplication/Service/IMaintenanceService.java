package com.example.CarsApplication.Service;

import com.example.CarsApplication.Model.PerformsMaintenance;

import java.util.List;

public interface IMaintenanceService {
    List<PerformsMaintenance> fetchMaintenanceList();
    PerformsMaintenance one(Long maintenanceID);
    PerformsMaintenance saveMaintenance(PerformsMaintenance maintenance, Long carID, Long mechanicID);
    PerformsMaintenance updateMaintenance(PerformsMaintenance maintenance, Long maintenanceID);
    void deleteMaintenance(Long maintenanceID);
}

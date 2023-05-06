package com.example.Lab2.Service;

import com.example.Lab2.Model.DTOs.MaintenanceDTO;
import com.example.Lab2.Model.DTOs.NrCarsStatisticDTO;
import com.example.Lab2.Model.Mechanic;
import com.example.Lab2.Model.PerformsMaintenance;
import com.sun.tools.javac.Main;

import java.util.List;

public interface IMaintenanceService {
    List<PerformsMaintenance> fetchMaintenanceList();
    PerformsMaintenance one(Long maintenanceID);
    PerformsMaintenance saveMaintenance(PerformsMaintenance maintenance, Long carID, Long mechanicID);
    PerformsMaintenance updateMaintenance(MaintenanceDTO maintenance, Long maintenanceID);

    List<MaintenanceDTO> fetchMaintenanceListPaginated(int pageNr);

    Long fetchMaintenanceCount();

    MaintenanceDTO oneDTO(Long maintenanceID);

    List<PerformsMaintenance> bulkAddMechanicsForCars(Long carID, List<Mechanic> mechanicsList);
    void deleteMaintenance(Long maintenanceID);

    List<NrCarsStatisticDTO> fetchCarsMaintenanceStatistic();
}

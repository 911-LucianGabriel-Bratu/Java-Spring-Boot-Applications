package com.example.Lab2.Service;

import com.example.Lab2.Model.Car;
import com.example.Lab2.Model.DTOs.MechanicDTO;
import com.example.Lab2.Model.Dealership;
import com.example.Lab2.Model.Mechanic;

import java.util.List;

public interface IMechanicService {
    Mechanic saveMechanic(Mechanic mechanic);
    //read
    List<Mechanic> fetchMechanicList();
    List<MechanicDTO> fetchMechanicListPaginated(int pageNr);

    long fetchMechanicCount();
    Mechanic one(Long mechanicID);

    MechanicDTO oneDTO(Long mechanicID);
    //update
    Mechanic updateMechanic(Mechanic mechanic, Long mechanicID);
    //delete
    void deleteMechanic(Long mechanicID);
}

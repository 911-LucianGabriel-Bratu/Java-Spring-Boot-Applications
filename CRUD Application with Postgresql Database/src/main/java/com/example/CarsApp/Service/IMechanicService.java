package com.example.CarsApp.Service;

import com.example.CarsApp.Model.Mechanic;

import java.util.List;

public interface IMechanicService {
    Mechanic saveMechanic(Mechanic mechanic);
    //read
    List<Mechanic> fetchMechanicList();
    Mechanic one(Long mechanicID);
    //update
    Mechanic updateMechanic(Mechanic mechanic, Long mechanicID);
    //delete
    void deleteMechanic(Long mechanicID);
}

package com.example.CarsApplication.Controller;

import com.example.CarsApplication.Model.Mechanic;
import com.example.CarsApplication.Service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MechanicController {
    @Autowired private MechanicService mechanicService;

    @GetMapping("/mechanics")
    public List<Mechanic> fetchAllMechanics(){
        return this.mechanicService.fetchMechanicList();
    }

    @GetMapping("/mechanics/{mechanicID}")
    public Mechanic one(@PathVariable("mechanicID") Long mechanicID){
        return this.mechanicService.one(mechanicID);
    }

    @PostMapping("/mechanics")
    public Mechanic saveMechanic(@RequestBody Mechanic mechanic){
        return this.mechanicService.saveMechanic(mechanic);
    }

    @PutMapping("/mechanics/{mechanicID}")
    public Mechanic updateMechanic(@RequestBody Mechanic mechanic, @PathVariable("mechanicID") Long mechanicID){
        return this.mechanicService.updateMechanic(mechanic, mechanicID);
    }

    @DeleteMapping("/mechanics/{mechanicID}")
    public String deleteMechanic(@PathVariable("mechanicID") Long mechanicID){
        this.mechanicService.deleteMechanic(mechanicID);
        return "Successfully deleted mechanic";
    }

}

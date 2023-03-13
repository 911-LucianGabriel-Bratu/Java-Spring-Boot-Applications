package com.example.CarsApp.Controller;

import com.example.CarsApp.Model.Car;
import com.example.CarsApp.Model.DTOs.CarDealershipDTO;
import com.example.CarsApp.Model.DTOs.CarDealershipIDDTO;
import com.example.CarsApp.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired private CarService carService;

    @PostMapping("/dealerships/{dealershipID}/cars")
    public Car saveCar(@PathVariable("dealershipID") Long dealershipID, @RequestBody Car car){
        return this.carService.saveCar(dealershipID, car);
    }

    @GetMapping("/dealerships/{dealershipID}/cars")
    public List<Car> fetchCarListForDealershipID(@PathVariable("dealershipID") Long dealershipID){
        return this.carService.fetchCarListForDealershipID(dealershipID);
    }

    @GetMapping("/dealerships/{dealershipID}/cars/{carID}")
    public Car one(@PathVariable("dealershipID") Long dealershipID, @PathVariable("carID") Long carID){
        return this.carService.one(dealershipID, carID);
    }

    @GetMapping("/cars")
    public List<CarDealershipIDDTO> fetchCars(){
        return this.carService.getAllCars();
    }

    @GetMapping("/cars/{carID}")
    public CarDealershipDTO fetchCarByIdWithDealershipDTO(@PathVariable("carID") Long carID){
        return this.carService.getOneCarWithDealershipObject(carID);
    }

    @PutMapping("/dealerships/{dealershipID}/cars/{carID}")
    public Car updateCar(@RequestBody Car car, @PathVariable("dealershipID") Long dealershipID, @PathVariable("carID") Long carID){
        return this.carService.updateCar(car, dealershipID, carID);
    }

    @DeleteMapping("/dealerships/{dealershipID}/cars/{id}")
    public String deleteCar(@PathVariable("dealershipID") Long dealershipID, @PathVariable("id") Long carID){
        this.carService.deleteCar(dealershipID, carID);
        return "Car successfully deleted";
    }
}
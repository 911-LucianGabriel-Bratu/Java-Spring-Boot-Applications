package com.example.Lab1Cars.Controller;

import com.example.Lab1Cars.Model.Car;
import com.example.Lab1Cars.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired private CarService carService;

    @PostMapping("/cars")
    public Car saveCar(@RequestBody Car car){
        return this.carService.saveCar(car);
    }

    @GetMapping("/cars")
    public List<Car> fetchCars(){
        return this.carService.fetchCarList();
    }

    @GetMapping("/cars/{id}")
    public Car one(@PathVariable("id") Long carID){
        return this.carService.one(carID);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@RequestBody Car car, @PathVariable("id") Long carID){
        return this.carService.updateCar(car, carID);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable("id") Long carID){
        this.carService.deleteCar(carID);
        return "Car successfully deleted";
    }
}

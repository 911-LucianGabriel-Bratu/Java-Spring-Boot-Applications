package com.example.Lab1Cars.Service;

import com.example.Lab1Cars.Model.Car;

import java.util.List;

public interface ICarService {
    //save
    Car saveCar(Car car);
    //read
    List<Car> fetchCarList();
    Car one(Long carID);
    //update
    Car updateCar(Car car, Long carID);
    //delete
    void deleteCar(Long carID);
}

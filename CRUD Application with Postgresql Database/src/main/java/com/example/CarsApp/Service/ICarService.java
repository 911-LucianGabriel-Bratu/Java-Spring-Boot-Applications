package com.example.CarsApp.Service;

import com.example.CarsApp.Model.Car;
import com.example.CarsApp.Model.DTOs.CarDealershipDTO;
import com.example.CarsApp.Model.DTOs.CarDealershipIDDTO;

import java.util.List;

public interface ICarService {
    //save
    Car saveCar(Long dealershipID, Car car);
    //read
    List<Car> fetchCarListForDealershipID(Long dealershipID);
    Car one(Long dealershipID, Long carID);

    List<CarDealershipIDDTO> getAllCars();
    CarDealershipDTO getOneCarWithDealershipObject(Long carID);
    //update
    Car updateCar(Car car, Long carID, Long dealershipID);
    //delete
    void deleteCar(Long carID, Long dealershipID);
}
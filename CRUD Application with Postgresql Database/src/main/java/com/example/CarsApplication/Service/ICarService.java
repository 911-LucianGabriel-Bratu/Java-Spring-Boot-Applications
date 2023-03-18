package com.example.CarsApplication.Service;

import com.example.CarsApplication.Model.Car;
import com.example.CarsApplication.Model.DTOs.CarDealershipDTO;
import com.example.CarsApplication.Model.DTOs.CarDealershipIDDTO;

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
package com.example.Lab2.Service;

import com.example.Lab2.Model.Car;
import com.example.Lab2.Model.DTOs.CarDTO;
import com.example.Lab2.Model.DTOs.CarDealershipDTO;
import com.example.Lab2.Model.DTOs.CarDealershipIDDTO;

import java.util.List;

public interface ICarService {
    //save
    Car saveCar(Long dealershipID, Car car);
    //read
    List<Car> fetchCarListForDealershipID(Long dealershipID);
    Car one(Long dealershipID, Long carID);
    Long fetchCarCount();

    List<CarDealershipIDDTO> getAllCars();

    CarDTO oneDTO(long carID);
    List<CarDTO> getAllCarsPaginated(int pageNr);
    CarDealershipDTO getOneCarWithDealershipObject(Long carID);
    //update
    Car updateCar(Car car, Long carID, Long dealershipID);
    //delete
    void deleteCar(Long carID);
}
package com.example.CarsApp.Service;

import com.example.CarsApp.Model.Car;
import com.example.CarsApp.Model.Dealership;
import com.example.CarsApp.Repository.CarRepository;
import com.example.CarsApp.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarService implements ICarService{
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DealershipRepository dealershipRepository;

    @Override
    public Car saveCar(Long dealershipID, Car car) {
        Dealership dealership = this.dealershipRepository.findById(dealershipID).get();
        car.setDealership(dealership);
        return this.carRepository.save(car);
    }

    @Override
    public List<Car> fetchCarListForDealershipID(Long dealershipID) {
        Dealership dealership = dealershipRepository.findById(dealershipID).get();
        return dealership.getCars();
    }

    @Override
    public Car one(Long dealershipID, Long carID) {
        Dealership dealership =  this.dealershipRepository.findById(dealershipID).get();
        List<Car> carList = dealership.getCars();
        for(Car car: carList){
            if(Objects.equals(car.getCarID(), carID)){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car updateCar(Car car, Long dealershipID, Long carID) {
        Dealership dealership = dealershipRepository.findById(dealershipID).get();

        Car foundCar = this.carRepository.findById(carID).get();
        foundCar.setCarManufacturer(car.getCarManufacturer());
        foundCar.setCarModel(car.getCarModel());
        foundCar.setCarRetailPrice(car.getCarRetailPrice());
        foundCar.setCarTopSpeed(car.getCarTopSpeed());
        foundCar.setCarWeight(car.getCarWeight());
        foundCar.setDealership(dealership);
        return this.carRepository.save(foundCar);
    }

    @Override
    public void deleteCar(Long dealershipID, Long carID) {
        Dealership dealership = dealershipRepository.findById(dealershipID).get();

        this.carRepository.deleteById(carID);
    }
}

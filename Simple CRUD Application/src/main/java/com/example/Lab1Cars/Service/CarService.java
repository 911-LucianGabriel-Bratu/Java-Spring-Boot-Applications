package com.example.Lab1Cars.Service;

import com.example.Lab1Cars.Model.Car;
import com.example.Lab1Cars.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> fetchCarList() {
        return this.carRepository.findAll();
    }

    @Override
    public Car one(Long carID) {
        return this.carRepository.findById(carID).get();
    }

    @Override
    public Car updateCar(Car car, Long carID) {
        Car foundCar = this.carRepository.findById(carID).get();
        foundCar.setCarManufacturer(car.getCarManufacturer());
        foundCar.setCarModel(car.getCarModel());
        foundCar.setCarRetailPrice(car.getCarRetailPrice());
        foundCar.setCarTopSpeed(car.getCarTopSpeed());
        foundCar.setCarWeight(car.getCarWeight());
        return this.carRepository.save(foundCar);
    }

    @Override
    public void deleteCar(Long carID) {
        this.carRepository.deleteById(carID);
    }
}

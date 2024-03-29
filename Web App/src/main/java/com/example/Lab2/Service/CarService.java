package com.example.Lab2.Service;

import com.example.Lab2.Model.Car;
import com.example.Lab2.Model.DTOs.CarDTO;
import com.example.Lab2.Model.DTOs.CarDealershipDTO;
import com.example.Lab2.Model.DTOs.CarDealershipIDDTO;
import com.example.Lab2.Model.DTOs.DealershipDTO;
import com.example.Lab2.Model.Dealership;
import com.example.Lab2.Repository.CarRepository;
import com.example.Lab2.Repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Long fetchCarCount() {
        return this.carRepository.count();
    }

    public List<CarDealershipIDDTO> getAllCars(){
        List<CarDealershipIDDTO> carDealershipIDDTOList = new ArrayList<>();

        List<Car> cars = this.carRepository.findAll();
        List<Dealership> dealerships = this.dealershipRepository.findAll();

        for(Car c : cars){
            for(Dealership d : dealerships){
                List<Car> carList = d.getCars();
                if(carList.contains(c)){
                    CarDealershipIDDTO carDealershipIDDTO = new CarDealershipIDDTO();
                    carDealershipIDDTO.setCarID(c.getCarID());
                    carDealershipIDDTO.setCarManufacturer(c.getCarManufacturer());
                    carDealershipIDDTO.setCarModel(c.getCarModel());
                    carDealershipIDDTO.setCarRetailPrice(c.getCarRetailPrice());
                    carDealershipIDDTO.setCarWeight(c.getCarWeight());
                    carDealershipIDDTO.setCarTopSpeed(c.getCarTopSpeed());
                    carDealershipIDDTO.setDealershipID(d.getDealershipID());
                    carDealershipIDDTOList.add(carDealershipIDDTO);
                }
            }
        }

        return carDealershipIDDTOList;
    }

    @Override
    public CarDTO oneDTO(long carID) {
        Car car = this.carRepository.findById(carID).get();
        CarDTO carDTO = new CarDTO();

        carDTO.setCarID(car.getCarID());
        carDTO.setCarManufacturer(car.getCarManufacturer());
        carDTO.setCarModel(car.getCarModel());
        carDTO.setCarTopSpeed(car.getCarTopSpeed());
        carDTO.setCarRetailPrice(car.getCarRetailPrice());
        carDTO.setCarWeight(car.getCarWeight());
        carDTO.setDealershipID(car.getDealership().getDealershipID());

        return carDTO;
    }

    @Override
    public List<CarDTO> getAllCarsPaginated(int pageNr) {
        long start_id = (pageNr-1) * 10 + 1;
        long max_id = start_id + 10;
        List<Car> carList = new ArrayList<>();
        List<CarDTO> carDTOList = new ArrayList<>();

        while(start_id < max_id){
            try{
                Car car = this.carRepository.findById(start_id).get();
                carList.add(car);
                start_id += 1;
            }
            catch (java.util.NoSuchElementException e){
                start_id += 1;
            }
        }

        for(Car car: carList){
            CarDTO carDTO = new CarDTO();

            carDTO.setCarID(car.getCarID());
            carDTO.setCarManufacturer(car.getCarManufacturer());
            carDTO.setCarModel(car.getCarModel());
            carDTO.setCarTopSpeed(car.getCarTopSpeed());
            carDTO.setCarRetailPrice(car.getCarRetailPrice());
            carDTO.setCarWeight(car.getCarWeight());
            carDTO.setDealershipID(car.getDealership().getDealershipID());

            carDTOList.add(carDTO);
        }
        return carDTOList;
    }

    @Override
    public CarDealershipDTO getOneCarWithDealershipObject(Long carID) {

        List<Car> carList = this.carRepository.findAll();
        List<Dealership> dealerships = this.dealershipRepository.findAll();

        Car foundCar = new Car();

        for(Car c : carList){
            if(Objects.equals(c.getCarID(), carID)) foundCar = c;
        }

        CarDealershipDTO carDealershipDTO = new CarDealershipDTO();

        for(Dealership d : dealerships){
            List<Car> carDealershipList = d.getCars();
            if(carDealershipList.contains(foundCar)){
                DealershipDTO dealershipDTO = new DealershipDTO();
                carDealershipDTO.setCarID(foundCar.getCarID());
                carDealershipDTO.setCarManufacturer(foundCar.getCarManufacturer());
                carDealershipDTO.setCarModel(foundCar.getCarModel());
                carDealershipDTO.setCarRetailPrice(foundCar.getCarRetailPrice());
                carDealershipDTO.setCarWeight(foundCar.getCarWeight());
                carDealershipDTO.setCarTopSpeed(foundCar.getCarTopSpeed());

                dealershipDTO.setId(d.getDealershipID());
                dealershipDTO.setName(d.getName());
                dealershipDTO.setReputation(d.getReputation());
                dealershipDTO.setCapacity(d.getCapacity());
                dealershipDTO.setHasService(d.isHasService());
                dealershipDTO.setOffersTradeIn(d.isOffersTradeIn());
                dealershipDTO.setAddress(d.getAddress());

                carDealershipDTO.setDealershipDTO(dealershipDTO);

                return carDealershipDTO;
            }
        }
        return carDealershipDTO;
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
    public void deleteCar(Long carID) {
        this.carRepository.deleteById(carID);
    }
}

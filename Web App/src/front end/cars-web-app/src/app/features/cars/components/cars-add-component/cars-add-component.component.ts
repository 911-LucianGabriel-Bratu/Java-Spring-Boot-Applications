import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CarsServiceService } from 'src/app/common/service/cars-service.service';
import { CarAddDTO } from '../../models/cars.models';

@Component({
  selector: 'app-cars-add-component',
  templateUrl: './cars-add-component.component.html',
  styleUrls: ['./cars-add-component.component.css']
})
export class CarsAddComponentComponent {
  carManufacturer?:string;
  carModel?:string;
  carRetailPrice?:number;
  carTopSpeed?:number;
  carWeight?:number;
  dealershipID?:number;

  constructor(private carSvc: CarsServiceService, private router: Router){}
  addCar(){
    if(this.carManufacturer&&this.carModel&&this.carRetailPrice&&this.carTopSpeed&&this.carWeight&&this.dealershipID){
      const car: CarAddDTO = {
        carManufacturer: this.carManufacturer,
        carModel: this.carModel,
        carRetailPrice: this.carRetailPrice,
        carTopSpeed: this.carTopSpeed,
        carWeight: this.carWeight
      }
      this.carSvc.addCar(car, this.dealershipID).subscribe(result =>{
        this.router.navigateByUrl('cars/paginated/1');
      },(err) => {console.log(err), alert("Error!")})
    }
  }
}

import { Component } from '@angular/core';
import { CarDTO, CarNoIDDTO } from '../../models/cars.models';
import { Router, ActivatedRoute } from '@angular/router';
import { CarsServiceService } from 'src/app/common/service/cars-service.service';

@Component({
  selector: 'app-cars-update-component',
  templateUrl: './cars-update-component.component.html',
  styleUrls: ['./cars-update-component.component.css']
})
export class CarsUpdateComponentComponent {
  carDTO!:CarDTO;
  carID?:number;
  carManufacturer?:string;
  carModel?:string;
  carRetailPrice?:number;
  carTopSpeed?:number;
  carWeight?:number;
  dealershipID?:number;

  constructor(private carSvc: CarsServiceService, private router: Router, private activatedRoute: ActivatedRoute){}
  updateCar():void{
    this.activatedRoute.params.subscribe(params => {
      this.carID = params['id'];
      if(this.carID&&this.carManufacturer&&this.carModel&&this.carRetailPrice&&this.carTopSpeed&&this.carWeight&&this.dealershipID){
        const car: CarNoIDDTO = {
          carManufacturer:this.carManufacturer,
          carModel:this.carModel,
          carRetailPrice:this.carRetailPrice,
          carTopSpeed:this.carTopSpeed,
          carWeight:this.carWeight,
        }
        this.carSvc.updateCar(car, this.dealershipID, this.carID).subscribe(result => {
          this.router.navigateByUrl('cars/paginated/1');
        }
        ,(err) =>{alert(err), console.log(err)}
        );
      }
    });
  }

  ngOnInit(): void {
      this.activatedRoute.params.subscribe(params => {
        this.carSvc.getOneCar(params['id']).subscribe((car: CarDTO) =>{
          this.carDTO = car;
          this.carManufacturer = this.carDTO.carManufacturer;
          this.carModel = this.carDTO.carModel;
          this.carRetailPrice = this.carDTO.carRetailPrice;
          this.carTopSpeed = this.carDTO.carTopSpeed;
          this.carWeight = this.carDTO.carWeight;
          this.dealershipID = this.carDTO.dealershipID;
        })
      });
  }
}

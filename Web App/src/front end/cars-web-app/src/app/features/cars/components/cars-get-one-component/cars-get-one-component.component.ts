import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CarsServiceService } from 'src/app/common/service/cars-service.service';
import { CarDTO } from '../../models/cars.models';

@Component({
  selector: 'app-cars-get-one-component',
  templateUrl: './cars-get-one-component.component.html',
  styleUrls: ['./cars-get-one-component.component.css']
})
export class CarsGetOneComponentComponent {
  id?:number;
  car?: CarDTO;

  constructor(private carSvc: CarsServiceService, private router: Router, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      this.carSvc.getOneCar(this.id!).subscribe((car: CarDTO) =>{
        this.car = car;
        this.car.carID = this.id!;
      })
    });
  }

  goToGetOneCar(id: number){
    this.router.navigateByUrl(`cars/${id}`);
  }

  goToGetOneDealership(id: number){
    this.router.navigateByUrl(`dealerships/${id}`);
  }
}

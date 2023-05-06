import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CarsServiceService } from 'src/app/common/service/cars-service.service';

@Component({
  selector: 'app-cars-delete-component',
  templateUrl: './cars-delete-component.component.html',
  styleUrls: ['./cars-delete-component.component.css']
})
export class CarsDeleteComponentComponent {
  carID?: number;

  constructor(private carSvc: CarsServiceService, private activatedRoute: ActivatedRoute){}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params =>{
      this.carID = params['id'];
      this.deleteCar();
  }) 
  }

  deleteCar():void {
    if(this.carID){
      this.carSvc.deleteCar(this.carID).subscribe(o =>{
        console.log(o);
      },
      (err) => {console.log("Error!")}
      )
    }
  }
}

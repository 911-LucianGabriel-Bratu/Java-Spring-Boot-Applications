import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MechanicsServiceService } from 'src/app/common/service/mechanics-service.service';

@Component({
  selector: 'app-mechanic-delete-component',
  templateUrl: './mechanic-delete-component.component.html',
  styleUrls: ['./mechanic-delete-component.component.css']
})
export class MechanicDeleteComponentComponent implements OnInit{
  mechanicID?: number;

  constructor(private mechanicSvc: MechanicsServiceService, private activatedRoute: ActivatedRoute){}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params =>{
      this.mechanicID = params['id'];
      this.deleteMechanic();
  }) 
  }

  deleteMechanic():void {
    if(this.mechanicID){
      this.mechanicSvc.deleteMechanic(this.mechanicID).subscribe(o =>{
        console.log(o);
      },
      (err) => {console.log("Error!")}
      )
    }
  }
}

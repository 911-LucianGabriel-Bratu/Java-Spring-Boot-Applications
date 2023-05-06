import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MaintenanceServiceService } from 'src/app/common/service/maintenance-service.service';

@Component({
  selector: 'app-maintenance-delete-component',
  templateUrl: './maintenance-delete-component.component.html',
  styleUrls: ['./maintenance-delete-component.component.css']
})
export class MaintenanceDeleteComponentComponent {
  maintenanceID?: number;

  constructor(private maintenanceSvc: MaintenanceServiceService, private activatedRoute: ActivatedRoute){}
  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params =>{
      this.maintenanceID = params['id'];
      this.deleteMaintenance();
  }) 
  }

  deleteMaintenance():void {
    if(this.maintenanceID){
      this.maintenanceSvc.deleteMaintenance(this.maintenanceID).subscribe(o =>{
        console.log(o);
      },
      (err) => {console.log("Error!")}
      )
    }
  }
}

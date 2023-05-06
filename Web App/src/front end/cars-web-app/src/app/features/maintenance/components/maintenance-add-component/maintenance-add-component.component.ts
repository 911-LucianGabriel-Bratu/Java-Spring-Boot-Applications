import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MaintenanceServiceService } from 'src/app/common/service/maintenance-service.service';
import { MechanicDTO } from 'src/app/features/mechanics/models/mechanics.models';
import { MaintenanceAddDTO } from '../../models/maintenance.models';

@Component({
  selector: 'app-maintenance-add-component',
  templateUrl: './maintenance-add-component.component.html',
  styleUrls: ['./maintenance-add-component.component.css']
})
export class MaintenanceAddComponentComponent {
  difficulty?: string;
  urgency?: string;
  description?: string;
  mechanicID?: number;
  carID?: number;

  constructor(private maintenanceSvc: MaintenanceServiceService, private router: Router){}
  addMaintenance(){
    if(this.difficulty&&this.urgency&&this.description&&this.mechanicID&&this.carID){
      const maintenance: MaintenanceAddDTO = {
        difficulty:this.difficulty,
        urgency:this.urgency,
        description:this.description
      }
      this.maintenanceSvc.addMaintenance(maintenance, this.carID, this.mechanicID).subscribe(result =>{
        this.router.navigateByUrl('maintenance/paginated/1');
      },(err) => {console.log(err), alert("Error!")})
    }
  }
}

import { Component } from '@angular/core';
import { MaintenanceDTO } from '../../models/maintenance.models';
import { Router, ActivatedRoute } from '@angular/router';
import { MaintenanceServiceService } from 'src/app/common/service/maintenance-service.service';
import { MechanicIDDTO } from 'src/app/features/mechanics/models/mechanics.models';

@Component({
  selector: 'app-maintenance-update-component',
  templateUrl: './maintenance-update-component.component.html',
  styleUrls: ['./maintenance-update-component.component.css']
})
export class MaintenanceUpdateComponentComponent {
  maintenanceDTO!:MaintenanceDTO;
  maintenanceID?: number;
  difficulty?: string;
  urgency?: string;
  description?: string;
  mechanicID?: number;
  carID?: number;

  constructor(private maintenanceSvc: MaintenanceServiceService, private router: Router, private activatedRoute: ActivatedRoute){}
  updateMaintenance():void{
    this.activatedRoute.params.subscribe(params => {
      this.maintenanceID = params['id'];
      if(this.maintenanceID&&this.difficulty&&this.urgency&&this.description&&this.mechanicID&&this.carID){
        const maintenance: MaintenanceDTO = {
          maintenanceID:this.maintenanceID,
          difficulty:this.difficulty,
          urgency:this.urgency,
          description:this.description,
          mechanicID:this.mechanicID,
          carID:this.carID
        }
        this.maintenanceSvc.updateMaintenance(maintenance, this.maintenanceID).subscribe(result => {
          this.router.navigateByUrl('maintenance/paginated/1');
        }
        ,(err) =>{alert(err), console.log(err)}
        );
      }
    });
  }

  ngOnInit(): void {
      this.activatedRoute.params.subscribe(params => {
        this.maintenanceSvc.getOneMaintenance(params['id']).subscribe((maintenance: MaintenanceDTO) =>{
          this.maintenanceDTO = maintenance;
          this.difficulty = this.maintenanceDTO.difficulty;
          this.urgency = this.maintenanceDTO.urgency;
          this.description = this.maintenanceDTO.description;
          this.mechanicID = this.maintenanceDTO.mechanicID;
          this.carID = this.maintenanceDTO.carID;
        })
      });
  }
}

import { Component } from '@angular/core';
import { MaintenanceDTO } from '../../models/maintenance.models';
import { MaintenanceServiceService } from 'src/app/common/service/maintenance-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-maintenance-get-one-component',
  templateUrl: './maintenance-get-one-component.component.html',
  styleUrls: ['./maintenance-get-one-component.component.css']
})
export class MaintenanceGetOneComponentComponent {
  id?:number;
  maintenance?: MaintenanceDTO;

  constructor(private maintenanceSvc: MaintenanceServiceService, private router: Router, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      this.maintenanceSvc.getOneMaintenance(this.id!).subscribe((maintenance: MaintenanceDTO) =>{
        this.maintenance = maintenance;
        this.maintenance.maintenanceID = this.id!;
      })
    });
  }

  goToGetOneCar(id: number){
    this.router.navigateByUrl(`cars/${id}`);
  }

  goToGetOneMechanic(id: number){
    this.router.navigateByUrl(`mechanics/${id}`);
  }
}

import { ChangeDetectorRef, Component } from '@angular/core';
import { MaintenanceDTO } from '../../models/maintenance.models';
import { MaintenanceServiceService } from 'src/app/common/service/maintenance-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-maintenance-overview',
  templateUrl: './maintenance-overview.component.html',
  styleUrls: ['./maintenance-overview.component.css']
})
export class MaintenanceOverviewComponent {
  maintenance?:MaintenanceDTO[] = [];
  pageNumber?: number;
  maxPages?: number;
  totalMaintenance?: number;

  constructor(private maintenanceSvc: MaintenanceServiceService, private router: Router, private changeDetectorRefs: ChangeDetectorRef, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.pageNumber = params['id'];
      this.maintenanceSvc.getMaintenancePaginated(this.pageNumber!).subscribe((result: MaintenanceDTO[])=>{
        this.maintenanceSvc.getMaintenanceCount().subscribe((nr:number)=>{
          this.totalMaintenance = nr;
          this.maintenance = result;
          this.maxPages = Math.floor(this.totalMaintenance / 10) + 1;
        });
      });
    });
  }

  goToAdd(){
    this.router.navigateByUrl(`maintenance/add`);
  }
  
  goToUpdate(id: number){
    this.router.navigateByUrl(`maintenance/update/${id}`);
  }
  
  goToDelete(id: number){
    this.router.navigateByUrl(`maintenance/delete/${id}`);
  }
  
  goToGetOne(id: number){
    this.router.navigateByUrl(`maintenance/${id}`);
  }
  
  goToPaginated(id: number){
    this.router.navigateByUrl(`maintenance/paginated/${id}`)
    this.changeDetectorRefs.detectChanges();
  }

  goToGetOneCar(id: number){
    this.router.navigateByUrl(`cars/${id}`);
  }

  goToGetOneMechanic(id: number){
    this.router.navigateByUrl(`mechanics/${id}`);
  }
}

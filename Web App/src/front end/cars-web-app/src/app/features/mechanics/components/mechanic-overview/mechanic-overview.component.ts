import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MechanicsServiceService } from 'src/app/common/service/mechanics-service.service';
import { MechanicDTO, MechanicIDDTO } from 'src/app/features/mechanics/models/mechanics.models';

@Component({
  selector: 'app-mechanic-overview',
  templateUrl: './mechanic-overview.component.html',
  styleUrls: ['./mechanic-overview.component.css']
})
export class MechanicOverviewComponent implements OnInit{
  mechanics?: MechanicIDDTO[] = [];
  pageNumber?: number;
  maxPages?: number;
  totalMechanics?: number;

  constructor(private mechanicSvc: MechanicsServiceService, private router: Router, private changeDetectorRefs: ChangeDetectorRef, private activatedRoute: ActivatedRoute) {}
  ngOnInit(): void {
      this.activatedRoute.params.subscribe(params => {
        this.pageNumber = params['id'];
        this.mechanicSvc.getMechanicsPaginated(this.pageNumber!).subscribe((result: MechanicIDDTO[])=>{
          this.mechanicSvc.getMechanicCount().subscribe((nr:number)=>{
            this.totalMechanics = nr;
            this.mechanics = result;
            this.maxPages = Math.floor(this.totalMechanics / 10) + 1;
          });
        });
      });
  }

  goToAdd(){
    this.router.navigateByUrl(`mechanics/add`);
  }
  
  goToUpdate(id: number){
    this.router.navigateByUrl(`mechanics/update/${id}`);
  }
  
  goToDelete(id: number){
    this.router.navigateByUrl(`mechanics/delete/${id}`);
  }
  
  goToGetOne(id: number){
    this.router.navigateByUrl(`mechanics/${id}`);
  }
  
  goToPaginated(id: number){
    this.router.navigateByUrl(`mechanics/paginated/${id}`)
    this.changeDetectorRefs.detectChanges();
  }
}

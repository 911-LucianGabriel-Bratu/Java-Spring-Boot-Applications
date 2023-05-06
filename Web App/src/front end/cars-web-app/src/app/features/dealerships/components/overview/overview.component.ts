import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ApiService } from 'src/app/common/service/services.service';
import { DealershipDTO } from './models/dealerships.models';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  dealerships: DealershipDTO[] = [];
  pageNumber?: number;
  maxPages?: number;
  totalDealershipCount?: number;

  constructor(private apiSvc: ApiService, private router: Router, private changeDetectorRefs: ChangeDetectorRef, private activatedRoute: ActivatedRoute)  {}
  ngOnInit(): void{
      this.activatedRoute.params.subscribe(params =>{
        this.pageNumber = params['id'];
        this.apiSvc.getPaginatedDealerships(this.pageNumber!).subscribe((result: DealershipDTO[]) => {
          this.apiSvc.getDealershipCount().subscribe((nr: number) =>{
            this.totalDealershipCount = nr;
            this.dealerships = result;
            this.maxPages = Math.floor(this.totalDealershipCount / 10) + 1;
          });
      });
      }) 
  }

sortTableData(): void{
  this.dealerships.sort((a,b)=>(a.capacity > b.capacity) ? 1: (a.capacity < b.capacity) ? -1:0);
  this.changeDetectorRefs.detectChanges();
}

goToAdd(){
  this.router.navigateByUrl(`dealerships/add`);
}

goToUpdate(id: number){
  this.router.navigateByUrl(`dealerships/update/${id}`);
}

goToDelete(id: number){
  this.router.navigateByUrl(`dealerships/delete/${id}`);
}

goToGetOne(id: number){
  this.router.navigateByUrl(`dealerships/${id}`);
}

goToPaginated(id: number){
  this.router.navigateByUrl(`dealerships/paginated/${id}`)
  this.changeDetectorRefs.detectChanges();
}
}

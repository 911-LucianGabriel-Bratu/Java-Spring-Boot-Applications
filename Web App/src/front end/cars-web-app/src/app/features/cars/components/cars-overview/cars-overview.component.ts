import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CarsServiceService } from 'src/app/common/service/cars-service.service';
import { CarDTO } from '../../models/cars.models';

@Component({
  selector: 'app-cars-overview',
  templateUrl: './cars-overview.component.html',
  styleUrls: ['./cars-overview.component.css']
})
export class CarsOverviewComponent {
  cars?:CarDTO[] = [];
  pageNumber?: number;
  maxPages?: number;
  totalCars?: number;

  constructor(private carSvc: CarsServiceService, private router: Router, private changeDetectorRefs: ChangeDetectorRef, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.pageNumber = params['id'];
      this.carSvc.getCarsPaginated(this.pageNumber!).subscribe((result: CarDTO[])=>{
        this.carSvc.getCarsCount().subscribe((nr:number)=>{
          this.totalCars = nr;
          this.cars = result;
          this.maxPages = Math.floor(this.totalCars / 10) + 1;
        });
      });
    });
  }

  goToAdd(){
    this.router.navigateByUrl(`cars/add`);
  }
  
  goToUpdate(id: number){
    this.router.navigateByUrl(`cars/update/${id}`);
  }
  
  goToDelete(id: number){
    this.router.navigateByUrl(`cars/delete/${id}`);
  }
  
  goToGetOne(id: number){
    this.router.navigateByUrl(`cars/${id}`);
  }
  
  goToPaginated(id: number){
    this.router.navigateByUrl(`cars/paginated/${id}`)
    this.changeDetectorRefs.detectChanges();
  }

  goToGetOneDealership(id: number){
    this.router.navigateByUrl(`dealerships/${id}`);
  }
}

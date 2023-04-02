import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { ApiService } from 'src/app/common/service/services.service';
import { Dealerships } from './models/dealerships.models';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  dealerships: Dealerships[] = [];

  constructor(private apiSvc: ApiService, private router: Router)  {}
  ngOnInit(): void{
      this.apiSvc.getDealerships().subscribe((result: Dealerships[]) => {
          this.dealerships = result;
      });
  }

  goToAdd(){
      this.router.navigateByUrl(`dealerships/add`);
  }

  goToUpdate(){
    this.router.navigateByUrl(`dealerships/update`);
  }

  goToDelete(){
    this.router.navigateByUrl(`dealerships/delete`);
  }
}

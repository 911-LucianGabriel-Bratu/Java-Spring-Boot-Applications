import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/common/service/services.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent {
  dealershipID?:number;

  constructor(private apiSvc: ApiService, private router:Router){}
  deleteDealership(){
    if(this.dealershipID){
      this.apiSvc.deleteDealership(this.dealershipID);
      console.log(this.dealershipID);
      this.router.navigateByUrl('dealerships');
    }
  }
}

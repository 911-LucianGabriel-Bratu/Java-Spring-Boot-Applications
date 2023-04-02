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
      this.apiSvc.deleteDealership(this.dealershipID).subscribe(() => console.log("deleted"));
      this.router.navigateByUrl('dealerships');
    }
  }
}

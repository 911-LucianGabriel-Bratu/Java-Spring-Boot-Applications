import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ApiService } from 'src/app/common/service/services.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit{
  dealershipID?:number;

  constructor(private apiSvc: ApiService, private router:Router, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params =>{
        this.dealershipID = params['id'];
        this.deleteDealership();
    }) 
  }

  deleteDealership(){
    if(this.dealershipID){
      this.apiSvc.deleteDealership(this.dealershipID).subscribe(o => {
        console.log(o);
      }
      ,(err) =>{console.log("Error!")}
      );
    }
  }
}

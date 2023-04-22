import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/common/service/services.service';
import { DealershipDTO, DealershipsDTO } from '../components/overview/models/dealerships.models';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})

export class UpdateComponent implements OnInit{
  dealershipDTO!:DealershipDTO;
  dealershipID?:number;
  name?:string;
  capacity?: number;
  address?: string;
  reputation?: number;
  hasService?: boolean;
  offersTradeIn?:boolean;

  constructor(private apiSvc: ApiService, private router:Router, private activatedRoute: ActivatedRoute){}
  updateDealership(){
    this.activatedRoute.params.subscribe(params => {
      this.dealershipID = params['id'];
      if(this.dealershipID&&this.name&&this.capacity&&this.address&&this.reputation&&this.hasService&&this.offersTradeIn){
        const dealership: DealershipsDTO = {
          name:this.name,
          capacity: this.capacity,
          address: this.address,
          reputation: this.reputation,
          hasService: this.hasService,
          offersTradeIn: this.offersTradeIn
        }
        this.apiSvc.updateDealership(dealership, this.dealershipID).subscribe(result => {
          this.router.navigateByUrl('dealerships');
        }
        ,(err) =>{alert(err), console.log(err)}
        );
      }
    });
    }

    ngOnInit(): void {
      this.activatedRoute.params.subscribe(params => {
        this.apiSvc.getDealership(params['id']).subscribe((dealership: DealershipDTO) =>{
          this.dealershipDTO = dealership;
        })
      });
    }
}

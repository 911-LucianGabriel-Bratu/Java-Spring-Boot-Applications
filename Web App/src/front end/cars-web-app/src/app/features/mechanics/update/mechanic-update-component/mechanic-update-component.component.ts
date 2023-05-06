import { Component, OnInit } from '@angular/core';
import { MechanicDTO, MechanicIDDTO } from '../../models/mechanics.models';
import { MechanicsServiceService } from 'src/app/common/service/mechanics-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-mechanic-update-component',
  templateUrl: './mechanic-update-component.component.html',
  styleUrls: ['./mechanic-update-component.component.css']
})
export class MechanicUpdateComponentComponent implements OnInit{
  mechanicIDDTO!:MechanicIDDTO;
  mechanicID?:number;
  name?:string;
  cnp?: string;
  address?: string;
  experience?: number;
  favouriteCarBrand?: string;

  constructor(private mechanicSvc: MechanicsServiceService, private router: Router, private activatedRoute: ActivatedRoute){}
  updateMechanic():void{
    this.activatedRoute.params.subscribe(params => {
      this.mechanicID = params['id'];
      if(this.mechanicID&&this.name&&this.cnp&&this.address&&this.experience&&this.favouriteCarBrand){
        const mechanic: MechanicDTO = {
          name:this.name,
          cnp: this.cnp,
          address: this.address,
          experience: this.experience,
          favouriteCarBrand: this.favouriteCarBrand
        }
        this.mechanicSvc.updateMechanic(mechanic, this.mechanicID).subscribe(result => {
          this.router.navigateByUrl('mechanics/paginated/1');
        }
        ,(err) =>{alert(err), console.log(err)}
        );
      }
    });
  }

  ngOnInit(): void {
      this.activatedRoute.params.subscribe(params => {
        this.mechanicSvc.getOneMechanic(params['id']).subscribe((mechanic: MechanicIDDTO) =>{
          this.mechanicIDDTO = mechanic;
          this.name = this.mechanicIDDTO.name;
          this.cnp = this.mechanicIDDTO.cnp;
          this.address = this.mechanicIDDTO.address;
          this.experience = this.mechanicIDDTO.experience;
          this.favouriteCarBrand = this.mechanicIDDTO.favouriteCarBrand;
        })
      });
  }
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MechanicsServiceService } from 'src/app/common/service/mechanics-service.service';
import { MechanicDTO } from '../../models/mechanics.models';

@Component({
  selector: 'app-mechanic-add-component',
  templateUrl: './mechanic-add-component.component.html',
  styleUrls: ['./mechanic-add-component.component.css']
})
export class MechanicAddComponentComponent {
  name?:string;
  cnp?: string;
  address?: string;
  experience?: number;
  favouriteCarBrand?: string;

  constructor(private mechanicSvc: MechanicsServiceService, private router: Router){}
  addMechanic(){
    if(this.name&&this.cnp&&this.address&&this.experience&&this.favouriteCarBrand){
      const mechanic: MechanicDTO = {
        name:this.name,
        cnp:this.cnp,
        address:this.address,
        experience:this.experience,
        favouriteCarBrand:this.favouriteCarBrand
      }
      this.mechanicSvc.addMechanic(mechanic).subscribe(result =>{
        this.router.navigateByUrl('mechanics/paginated/1');
      },(err) => {console.log(err), alert("Error!")})
    }
  }
}

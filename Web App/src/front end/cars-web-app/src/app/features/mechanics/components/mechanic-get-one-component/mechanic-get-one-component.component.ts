import { Component, OnInit } from '@angular/core';
import { MechanicIDDTO } from '../../models/mechanics.models';
import { MechanicsServiceService } from 'src/app/common/service/mechanics-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-mechanic-get-one-component',
  templateUrl: './mechanic-get-one-component.component.html',
  styleUrls: ['./mechanic-get-one-component.component.css']
})
export class MechanicGetOneComponentComponent implements OnInit{
  id?:number;
  mechanic?: MechanicIDDTO;

  constructor(private mechanicSvc: MechanicsServiceService, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      this.mechanicSvc.getOneMechanic(this.id!).subscribe((mechanic: MechanicIDDTO) =>{
        this.mechanic = mechanic;
        this.mechanic.id = this.id!;
      })
    });
  }
}

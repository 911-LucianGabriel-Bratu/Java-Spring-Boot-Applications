import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { MechanicDTO, MechanicIDDTO } from 'src/app/features/mechanics/models/mechanics.models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MechanicsServiceService {

  baseUrl:string = "http://localhost:80/";

  constructor(private http: HttpClient) { }

  getMechanicsPaginated(pageNumber:number): Observable<MechanicIDDTO[]>{
    return this.http.get(`${this.baseUrl}mechanics/paginated/${pageNumber}`) as Observable<MechanicIDDTO[]>;
  }

  getMechanicCount(): Observable<number>{
    return this.http.get(`${this.baseUrl}mechanics/count`) as Observable<number>;
  }

  getOneMechanic(mechanicID:number): Observable<MechanicIDDTO>{
    return this.http.get(`${this.baseUrl}mechanics/dto/${mechanicID}`) as Observable<MechanicIDDTO>;
  }

  addMechanic(mechanic: MechanicDTO): Observable<MechanicDTO>{
    return this.http.post(`${this.baseUrl}mechanics`, mechanic) as Observable<MechanicDTO>;
  }

  updateMechanic(mechanic: MechanicDTO, mechanicID:number): Observable<MechanicDTO>{
    return this.http.put(`${this.baseUrl}mechanics/${mechanicID}`, mechanic) as Observable<MechanicIDDTO>;
  }

  deleteMechanic(mechanicID:number):Observable<string> {
    return this.http.delete(`${this.baseUrl}mechanics/${mechanicID}`) as Observable<string>;
  }
}

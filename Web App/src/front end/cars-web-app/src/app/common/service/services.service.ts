import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Dealerships, DealershipsDTO } from 'src/app/features/dealerships/components/overview/models/dealerships.models';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrl:string = "http://13.49.148.93/";

  constructor(private http: HttpClient) { }
  getDealerships(): Observable<Dealerships[]>{
    return this.http.get(`${this.baseUrl}dealerships`) as Observable<Dealerships[]>;
  }

  getDealership(dealershipId: number): Observable<Dealerships>{
    return this.http.get(`${this.baseUrl}dealerships/${dealershipId}`) as Observable<Dealerships>;
  }

  addDealership(dealership: DealershipsDTO): Observable<DealershipsDTO>{
    return this.http.post(`${this.baseUrl}dealerships`, dealership) as Observable<DealershipsDTO>;
  }

  updateDealership(dealership: DealershipsDTO, dealershipID:number): Observable<Dealerships>{
    return this.http.put(`${this.baseUrl}dealerships/${dealershipID}`, dealership) as Observable<Dealerships>;
  }

  deleteDealership(dealershipID:number):Observable<Object> {
    return this.http.delete(`${this.baseUrl}dealerships/${dealershipID}`);
  }
}

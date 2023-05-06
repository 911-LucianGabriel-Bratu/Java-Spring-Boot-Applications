import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarAddDTO, CarDTO, CarNoIDDTO } from 'src/app/features/cars/models/cars.models';

@Injectable({
  providedIn: 'root'
})
export class CarsServiceService {

  baseUrl:string = "http://localhost:80/";

  constructor(private http: HttpClient) { }

  getCarsPaginated(pageNumber:number): Observable<CarDTO[]>{
    return this.http.get(`${this.baseUrl}cars/paginated/${pageNumber}`) as Observable<CarDTO[]>;
  }

  getCarsCount(): Observable<number>{
    return this.http.get(`${this.baseUrl}cars/count`) as Observable<number>;
  }

  getOneCar(carID:number): Observable<CarDTO>{
    return this.http.get(`${this.baseUrl}cars/dto/${carID}`) as Observable<CarDTO>;
  }

  addCar(car: CarAddDTO, dealershipID: number): Observable<CarDTO>{
    return this.http.post(`${this.baseUrl}dealerships/${dealershipID}/cars`, car) as Observable<CarDTO>;
  }

  updateCar(car: CarNoIDDTO, dealershipID:number, carID:number): Observable<CarDTO>{
    return this.http.put(`${this.baseUrl}dealerships/${dealershipID}/cars/${carID}`, car) as Observable<CarDTO>;
  }

  deleteCar(carID:number):Observable<string> {
    return this.http.delete(`${this.baseUrl}cars/${carID}`) as Observable<string>;
  }
}

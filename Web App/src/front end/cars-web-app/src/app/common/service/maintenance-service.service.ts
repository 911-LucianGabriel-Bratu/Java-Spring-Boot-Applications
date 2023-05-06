import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MaintenanceAddDTO, MaintenanceDTO, MaintenanceNoIDDTO } from 'src/app/features/maintenance/models/maintenance.models';

@Injectable({
  providedIn: 'root'
})
export class MaintenanceServiceService {

  baseUrl:string = "http://localhost:80/";

  constructor(private http: HttpClient) { }

  getMaintenancePaginated(pageNumber:number): Observable<MaintenanceDTO[]>{
    return this.http.get(`${this.baseUrl}maintenance/paginated/${pageNumber}`) as Observable<MaintenanceDTO[]>;
  }

  getMaintenanceCount(): Observable<number>{
    return this.http.get(`${this.baseUrl}maintenance/count`) as Observable<number>;
  }

  getOneMaintenance(maintenanceID:number): Observable<MaintenanceDTO>{
    return this.http.get(`${this.baseUrl}maintenance/dto/${maintenanceID}`) as Observable<MaintenanceDTO>;
  }

  addMaintenance(maintenance: MaintenanceAddDTO, carID:number, mechanicID:number): Observable<MaintenanceAddDTO>{
    return this.http.post(`${this.baseUrl}maintenance/cars/${carID}/mechanics/${mechanicID}`, maintenance) as Observable<MaintenanceAddDTO>;
  }

  updateMaintenance(maintenance: MaintenanceDTO, maintenanceID:number): Observable<MaintenanceDTO>{
    return this.http.put(`${this.baseUrl}maintenance/${maintenanceID}`, maintenance) as Observable<MaintenanceDTO>;
  }

  deleteMaintenance(maintenanceID:number):Observable<string> {
    return this.http.delete(`${this.baseUrl}maintenance/${maintenanceID}`) as Observable<string>;
  }
}

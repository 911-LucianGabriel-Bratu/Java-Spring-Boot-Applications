import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './common/home/home.component';
import { OverviewComponent } from './features/dealerships/components/overview/overview.component';
import { StatisticsoverviewComponent } from './features/statistics/components/statisticsoverview/statisticsoverview.component';
import { HttpClientModule } from '@angular/common/http';
import { AddComponent } from './features/dealerships/add/add.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './features/dealerships/update/update.component';
import { DeleteComponent } from './features/dealerships/delete/delete.component';
import { GetOneComponentComponent } from './features/dealerships/components/get-one-component/get-one-component.component';
import { MechanicOverviewComponent } from './features/mechanics/components/mechanic-overview/mechanic-overview.component';
import { MechanicAddComponentComponent } from './features/mechanics/add/mechanic-add-component/mechanic-add-component.component';
import { MechanicUpdateComponentComponent } from './features/mechanics/update/mechanic-update-component/mechanic-update-component.component';
import { MechanicDeleteComponentComponent } from './features/mechanics/delete/mechanic-delete-component/mechanic-delete-component.component';
import { MechanicGetOneComponentComponent } from './features/mechanics/components/mechanic-get-one-component/mechanic-get-one-component.component';
import { MaintenanceOverviewComponent } from './features/maintenance/components/maintenance-overview/maintenance-overview.component';
import { MaintenanceGetOneComponentComponent } from './features/maintenance/components/maintenance-get-one-component/maintenance-get-one-component.component';
import { MaintenanceDeleteComponentComponent } from './features/maintenance/components/maintenance-delete-component/maintenance-delete-component.component';
import { MaintenanceAddComponentComponent } from './features/maintenance/components/maintenance-add-component/maintenance-add-component.component';
import { MaintenanceUpdateComponentComponent } from './features/maintenance/components/maintenance-update-component/maintenance-update-component.component';
import { CarsOverviewComponent } from './features/cars/components/cars-overview/cars-overview.component';
import { CarsGetOneComponentComponent } from './features/cars/components/cars-get-one-component/cars-get-one-component.component';
import { CarsDeleteComponentComponent } from './features/cars/components/cars-delete-component/cars-delete-component.component';
import { CarsAddComponentComponent } from './features/cars/components/cars-add-component/cars-add-component.component';
import { CarsUpdateComponentComponent } from './features/cars/components/cars-update-component/cars-update-component.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    OverviewComponent,
    StatisticsoverviewComponent,
    AddComponent,
    UpdateComponent,
    DeleteComponent,
    GetOneComponentComponent,
    MechanicOverviewComponent,
    MechanicAddComponentComponent,
    MechanicUpdateComponentComponent,
    MechanicDeleteComponentComponent,
    MechanicGetOneComponentComponent,
    MaintenanceOverviewComponent,
    MaintenanceGetOneComponentComponent,
    MaintenanceDeleteComponentComponent,
    MaintenanceAddComponentComponent,
    MaintenanceUpdateComponentComponent,
    CarsOverviewComponent,
    CarsGetOneComponentComponent,
    CarsDeleteComponentComponent,
    CarsAddComponentComponent,
    CarsUpdateComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './common/home/home.component';
import { AddComponent } from './features/dealerships/add/add.component';
import { OverviewComponent } from './features/dealerships/components/overview/overview.component';
import { DeleteComponent } from './features/dealerships/delete/delete.component';
import { UpdateComponent } from './features/dealerships/update/update.component';
import { StatisticsoverviewComponent } from './features/statistics/components/statisticsoverview/statisticsoverview.component';
import { GetOneComponentComponent } from './features/dealerships/components/get-one-component/get-one-component.component';
import { MechanicOverviewComponent } from './features/mechanics/components/mechanic-overview/mechanic-overview.component';
import { MechanicGetOneComponentComponent } from './features/mechanics/components/mechanic-get-one-component/mechanic-get-one-component.component';
import { MechanicDeleteComponentComponent } from './features/mechanics/delete/mechanic-delete-component/mechanic-delete-component.component';
import { MechanicUpdateComponentComponent } from './features/mechanics/update/mechanic-update-component/mechanic-update-component.component';
import { MechanicAddComponentComponent } from './features/mechanics/add/mechanic-add-component/mechanic-add-component.component';
import { MaintenanceOverviewComponent } from './features/maintenance/components/maintenance-overview/maintenance-overview.component';
import { MaintenanceAddComponentComponent } from './features/maintenance/components/maintenance-add-component/maintenance-add-component.component';
import { MaintenanceUpdateComponentComponent } from './features/maintenance/components/maintenance-update-component/maintenance-update-component.component';
import { MaintenanceDeleteComponentComponent } from './features/maintenance/components/maintenance-delete-component/maintenance-delete-component.component';
import { MaintenanceGetOneComponentComponent } from './features/maintenance/components/maintenance-get-one-component/maintenance-get-one-component.component';
import { CarsAddComponentComponent } from './features/cars/components/cars-add-component/cars-add-component.component';
import { CarsDeleteComponentComponent } from './features/cars/components/cars-delete-component/cars-delete-component.component';
import { CarsGetOneComponentComponent } from './features/cars/components/cars-get-one-component/cars-get-one-component.component';
import { CarsOverviewComponent } from './features/cars/components/cars-overview/cars-overview.component';
import { CarsUpdateComponentComponent } from './features/cars/components/cars-update-component/cars-update-component.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "dealerships",
    component: OverviewComponent
  },
  {
    path: "statistics",
    component: StatisticsoverviewComponent
  },
  {
    path: "dealerships/add",
    component: AddComponent
  },
  {
    path: "dealerships/update/:id",
    component: UpdateComponent
  },
  {
    path: "dealerships/delete/:id",
    component: DeleteComponent
  },
  {
    path: "dealerships/:id",
    component: GetOneComponentComponent
  },
  {
    path: "dealerships/paginated/:id",
    component: OverviewComponent
  },
  {
    path: "mechanics/paginated/:id",
    component: MechanicOverviewComponent
  },
  {
    path: "mechanics/add",
    component: MechanicAddComponentComponent
  },
  {
    path: "mechanics/update/:id",
    component: MechanicUpdateComponentComponent
  },
  {
    path: "mechanics/delete/:id",
    component: MechanicDeleteComponentComponent
  },
  {
    path: "mechanics/:id",
    component: MechanicGetOneComponentComponent
  },
  {
    path: "maintenance/paginated/:id",
    component: MaintenanceOverviewComponent
  },
  {
    path: "maintenance/add",
    component: MaintenanceAddComponentComponent
  },
  {
    path: "maintenance/update/:id",
    component: MaintenanceUpdateComponentComponent
  },
  {
    path: "maintenance/delete/:id",
    component: MaintenanceDeleteComponentComponent
  },
  {
    path: "maintenance/:id",
    component: MaintenanceGetOneComponentComponent
  },
  {
    path: "cars/paginated/:id",
    component: CarsOverviewComponent
  },
  {
    path: "cars/add",
    component: CarsAddComponentComponent
  },
  {
    path: "cars/update/:id",
    component: CarsUpdateComponentComponent
  },
  {
    path: "cars/delete/:id",
    component: CarsDeleteComponentComponent
  },
  {
    path: "cars/:id",
    component: CarsGetOneComponentComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

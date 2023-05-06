import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceGetOneComponentComponent } from './maintenance-get-one-component.component';

describe('MaintenanceGetOneComponentComponent', () => {
  let component: MaintenanceGetOneComponentComponent;
  let fixture: ComponentFixture<MaintenanceGetOneComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaintenanceGetOneComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaintenanceGetOneComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

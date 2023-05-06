import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceDeleteComponentComponent } from './maintenance-delete-component.component';

describe('MaintenanceDeleteComponentComponent', () => {
  let component: MaintenanceDeleteComponentComponent;
  let fixture: ComponentFixture<MaintenanceDeleteComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaintenanceDeleteComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaintenanceDeleteComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

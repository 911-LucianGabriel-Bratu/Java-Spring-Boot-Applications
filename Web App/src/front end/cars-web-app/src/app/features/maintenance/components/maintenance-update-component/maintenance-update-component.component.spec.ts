import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceUpdateComponentComponent } from './maintenance-update-component.component';

describe('MaintenanceUpdateComponentComponent', () => {
  let component: MaintenanceUpdateComponentComponent;
  let fixture: ComponentFixture<MaintenanceUpdateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaintenanceUpdateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaintenanceUpdateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

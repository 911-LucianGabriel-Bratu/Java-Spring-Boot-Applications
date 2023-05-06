import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaintenanceAddComponentComponent } from './maintenance-add-component.component';

describe('MaintenanceAddComponentComponent', () => {
  let component: MaintenanceAddComponentComponent;
  let fixture: ComponentFixture<MaintenanceAddComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaintenanceAddComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MaintenanceAddComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarsUpdateComponentComponent } from './cars-update-component.component';

describe('CarsUpdateComponentComponent', () => {
  let component: CarsUpdateComponentComponent;
  let fixture: ComponentFixture<CarsUpdateComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarsUpdateComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarsUpdateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
